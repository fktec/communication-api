package br.com.communication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.communication.api.dto.TargetDto;

@Entity
@Table(name = "owner")
public class TargetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public static TargetEntity of() {
		return new TargetEntity();
	}
	
	public static TargetEntity of(TargetDto dto) {
		if (dto == null) return null;
		return new TargetEntity()
				.setName(dto.getName());
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public TargetEntity setName(String name) {
		this.name = name;
		return this;
	}
	
}
