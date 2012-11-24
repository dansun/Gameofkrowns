package org.hackermongo.gok.model;

public class LoginResult {
	private long sessionId;
	private long errorCode;
	
	public LoginResult(long s, long e) {
		sessionId = s;
		errorCode = e;
	}
	
	public long getSessionId() {
		return sessionId;
	}
	
	public long getErrorCode() {
		return errorCode;
	}
}