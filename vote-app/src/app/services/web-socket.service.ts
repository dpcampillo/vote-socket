import { Injectable } from '@angular/core';

import { BehaviorSubject } from 'rxjs';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {

  readonly urlWebSocket = 'http://localhost:9765/vote-websocket';
  readonly topicSessions = '/topic/sessions';
  stompClient: any;

  private sessionsObs: BehaviorSubject<any> = new BehaviorSubject([]);

  constructor() { }

  connect() {
    console.log("Initialize WebSocket Connection");
    let webSocket = new SockJS(this.urlWebSocket);
    this.stompClient = Stomp.over(webSocket);
    const thisObj = this;
    thisObj.stompClient.connect({}, function (frame) {
      thisObj.stompClient.subscribe(thisObj.topicSessions, function (sdkEvent) {
        thisObj.onMessageReceived(sdkEvent);
      });
    }, this.errorCallBack);
  }

  errorCallBack(error) {
    console.log("errorCallBack -> " + error)
    setTimeout(() => {
        this.connect();
    }, 5000);
}

  onMessageReceived(message: any) {
    this.sessionsObs.next(JSON.parse(message.body));
  }

  getSessionsObs(){
    return this.sessionsObs;
  }

}
