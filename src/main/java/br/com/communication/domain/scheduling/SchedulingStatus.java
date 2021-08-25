package br.com.communication.domain.scheduling;

import br.com.communication.domain.SchedulingStatusCode;

public class SchedulingStatus {

	private SchedulingStatusCode code;
	private String reason;
	
	private SchedulingStatus() {}
	
	public static SchedulingStatus of() {
		return new SchedulingStatus();
	}
	
	public SchedulingStatusCode getCode() {
		return code;
	}
	public SchedulingStatus setCode(SchedulingStatusCode code) {
		this.code = code;
		return this;
	}
	public String getReason() {
		return reason;
	}
	public SchedulingStatus setReason(String reason) {
		this.reason = reason;
		return this;
	}
	
}
