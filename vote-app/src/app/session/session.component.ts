import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { WebSocketService } from '../services/web-socket.service';
import { SessionModel } from '../model/session-model';

@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.scss']
})
export class SessionComponent implements OnInit {

  sessions : SessionModel[] = [];

  constructor(private loginService: LoginService,
    private webSocketService: WebSocketService) { }

  ngOnInit(): void {
    this.loginService.getSessions().subscribe((res: SessionModel[]) => this.sessions = res);
    this.webSocketService.connect();
    this.webSocketService.getSessionsObs().subscribe(res => {
      if (res.sessions != null) {
        this.sessions = res.sessions;
      }
    });
    this.calculateConnectionTime();
  }

  calculateConnectionTime(){
    setInterval(() => {
      this.sessions.forEach(data => data.connectionTime = this.calculateDiff(data.connectionDate));
    }, 1000);
  }

  signOut(session: any){
    this.loginService.signOut(session).subscribe(res => {
      console.log(res);
    });
  }

  calculateDiff(inputDate: string){
    const diff = Math.abs(new Date().getTime() - new Date(inputDate).getTime());
    return new Date(diff).toISOString().slice(11, -1)
  }

}
