package com.example.vote.storage.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.vote.dto.SessionDTO;
import com.example.vote.storage.SessionStorage;

public class SessionStorageImpl implements SessionStorage {

	private Map<String, SessionDTO> dataStorage;

	public SessionStorageImpl() {
		this.dataStorage = new HashMap<>();
	}

	@Override
	public SessionDTO removeSession(String uuid) {
		return dataStorage.remove(uuid);
	}

	@Override
	public List<SessionDTO> getSessions() {
		return new ArrayList<>(dataStorage.values());
	}

	@Override
	public SessionDTO addSession(SessionDTO sessionDTO) {
		dataStorage.put(sessionDTO.getUuid(), sessionDTO);
		return sessionDTO;
	}

	@Override
	public Optional<SessionDTO> findByUsername(String username) {
		for(SessionDTO sessionDTO : dataStorage.values()) {
			if(username.equals(sessionDTO.getAccount().getUsername())) {
				return Optional.of(sessionDTO);
			}
		}
		return Optional.empty();
	}

}
