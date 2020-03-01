package com.example.vote.controller;

import java.util.List;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.vote.dto.SessionDTO;
import com.example.vote.service.LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class VoteWebSocketController {
	
	private final LoginService loginService;
	
	@SendTo("/topic/sessions")
	public List<SessionDTO> getSessionOnline() {
		return loginService.getSessions();
	}

}
