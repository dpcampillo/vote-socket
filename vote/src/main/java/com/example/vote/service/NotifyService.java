package com.example.vote.service;

import java.util.Map;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotifyService {
	
	private final SimpMessagingTemplate simplMessagingTemplate;
	
	public void sendEmitter(Map<String, Object> dataEvent) {
		simplMessagingTemplate.convertAndSend("/topic/sessions", dataEvent);
	}

}
