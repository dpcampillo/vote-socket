package com.example.vote.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.vote.dto.AccountDTO;
import com.example.vote.dto.SessionDTO;
import com.example.vote.exception.BusinessException;
import com.example.vote.storage.SessionStorage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	private static final String ALREADY_SING_IN = "AIS";

	private final SessionStorage sessionStorage;
	private final NotifyService notifyService;

	public SessionDTO signOut(SessionDTO sessionDTO) {
		SessionDTO result = sessionStorage.removeSession(sessionDTO.getUuid());
		sendSessions();
		return result;
	}

	public SessionDTO signIn(AccountDTO accountDTO) {
		if (sessionStorage.findByUsername(accountDTO.getUsername()).isPresent()) {
			throw new BusinessException(ALREADY_SING_IN, "Account is singed! ");
		} else {
			SessionDTO sessionDTO = new SessionDTO();
			sessionDTO.setAccount(accountDTO);
			sessionDTO.setConnectionDate(LocalDateTime.now());
			sessionDTO.setUuid(UUID.randomUUID().toString());
			sessionDTO = sessionStorage.addSession(sessionDTO);
			sendSessions();
			return sessionDTO;
		}
	}

	private void sendSessions() {
		Map<String, Object> params = new HashMap<>();
		params.put("sessions", getSessions());
		params.put("name", "sessions");
		notifyService.sendEmitter(params);
	}

	public List<SessionDTO> getSessions() {
		return sessionStorage.getSessions();
	}

}
