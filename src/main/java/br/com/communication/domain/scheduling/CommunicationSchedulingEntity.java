package br.com.communication.domain.scheduling;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import br.com.communication.api.dto.CommunicationSchedulingDto;
import br.com.communication.domain.CommunicationFormat;
import br.com.communication.domain.OwnerEntity;
import br.com.communication.domain.SchedulingStatusCode;
import br.com.communication.domain.TargetEntity;
import nonapi.io.github.classgraph.json.Id;

@Entity
@Table(name = "communication_scheduling")
public class CommunicationSchedulingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "start_at")
	private LocalDateTime startAt;
	private TargetEntity target;
	private OwnerEntity owner;
	private String message;
	private CommunicationFormat format;
	private SchedulingStatus status;
	
	private CommunicationSchedulingEntity() {}
	
	public static CommunicationSchedulingEntity of() {
		return new CommunicationSchedulingEntity();
	}
	
	public static CommunicationSchedulingEntity of(CommunicationSchedulingDto dto) {
		if (dto == null) return null;
		return new CommunicationSchedulingEntity()
				.setStartAt(dto.getStartAt())
//				.setTarget(TargetEntity.of(dto.getTarget()))
//				.setOwner(OwnerEntity.of(dto.getOwner()))
				.setMessage(dto.getMessage())
				.setFormat(dto.getFormat())
				.setStatus(SchedulingStatus.of().setCode(SchedulingStatusCode.WAITING));
	}
	
	public Long getId() {
		return id;
	}
	public LocalDateTime getStartAt() {
		return startAt;
	}
	public CommunicationSchedulingEntity setStartAt(LocalDateTime startAt) {
		this.startAt = startAt;
		return this;
	}
	public TargetEntity getTarget() {
		return target;
	}
	public CommunicationSchedulingEntity setTarget(TargetEntity target) {
		this.target = target;
		return this;
	}
	public OwnerEntity getOwner() {
		return owner;
	}
	public CommunicationSchedulingEntity setOwner(OwnerEntity owner) {
		this.owner = owner;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public CommunicationSchedulingEntity setMessage(String message) {
		this.message = message;
		return this;
	}
	public CommunicationFormat getFormat() {
		return format;
	}
	public CommunicationSchedulingEntity setFormat(CommunicationFormat format) {
		this.format = format;
		return this;
	}
	public SchedulingStatus getStatus() {
		return status;
	}
	public CommunicationSchedulingEntity setStatus(SchedulingStatus status) {
		this.status = status;
		return this;
	}
	
	public void statusSent() {
		status = SchedulingStatus.of().setCode(SchedulingStatusCode.SENT);
	}
	public void statusCanceled() {
		statusCanceled(null);
	}
	public void statusCanceled(String reason) {
		status = SchedulingStatus.of()
				.setCode(SchedulingStatusCode.CANCELED)
				.setReason(reason);
	}

}
