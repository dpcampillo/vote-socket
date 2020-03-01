package com.example.vote.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SessionDTO {
	private String uuid;
	private AccountDTO account;
	private LocalDateTime connectionDate;
}
