package br.com.communication.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.communication.api.dto.CommunicationSchedulingDto;
import br.com.communication.domain.scheduling.CommunicationSchedulingEntity;
import br.com.communication.domain.scheduling.ICommunicationSchedulingRepository;


@Service
public class CommunicationSchedulingService {

	@Autowired
	@Qualifier("CommunicationSchedulingRepository")
	private ICommunicationSchedulingRepository communicationSchedulingRepository;
	
	public void save(CommunicationSchedulingDto dto) {
		communicationSchedulingRepository.save(CommunicationSchedulingEntity.of(dto));
	}
	
	public List<CommunicationSchedulingEntity> findAllByTargetId(Long targetId) {
		return null;
	}
	
	public List<CommunicationSchedulingEntity> cancelById(Long id) {
		return null;
	}
}
