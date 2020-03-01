package com.example.vote.storage;

import java.util.List;
import java.util.Optional;

import com.example.vote.dto.SessionDTO;

public interface SessionStorage {
	
	public List<SessionDTO> getSessions();
	
	public SessionDTO removeSession(String username);
	
	public SessionDTO addSession(SessionDTO sessionDTO);
	
	public Optional<SessionDTO> findByUsername(String username);
	
}
