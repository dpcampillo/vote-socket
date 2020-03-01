package com.example.vote.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vote.dto.SessionDTO;
import com.example.vote.service.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class SessionController {
	
	private final LoginService loginService;

	@GetMapping
	public List<SessionDTO> getSessions(){
		return loginService.getSessions();
	}

}
