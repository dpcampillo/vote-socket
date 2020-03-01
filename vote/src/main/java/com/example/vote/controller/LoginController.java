package com.example.vote.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vote.dto.AccountDTO;
import com.example.vote.dto.SessionDTO;
import com.example.vote.service.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService loginService;
	
	@PostMapping
	public SessionDTO login(@RequestBody AccountDTO accountDTO) {
		return loginService.signIn(accountDTO);
	}
	
	@PostMapping("/out")
	public SessionDTO logout(@RequestBody SessionDTO sessionDTO) {
		return loginService.signOut(sessionDTO);
	}

}
