package br.com.communication.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.communication.api.dto.CommunicationSchedulingDto;
import br.com.communication.app.service.CommunicationSchedulingService;
import br.com.communication.domain.scheduling.CommunicationSchedulingEntity;


@RestController
@RequestMapping("scheduling")
public class CommunicationSchedulingController {
	
	@Autowired
	private CommunicationSchedulingService communicationSchedulingService;
	
	@PostMapping(path = "/{targetId}/{ownerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createCommunicationScheduling(@PathVariable(name = "targetId", required = true) Long targetId, @PathVariable(name = "ownerId", required = true) Long ownerId,  @RequestBody CommunicationSchedulingDto dto) {
		communicationSchedulingService.save(generateCreateCommand(dto, ownerId, targetId));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(path = "/{target}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommunicationSchedulingEntity>> getAllCommunicationSchedulingByTarget(@PathVariable(name = "targetId", required = true) Long targetId) {
		return  new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}/cancel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> cancelCommunicationSchedulingById(@PathVariable(name = "id", required = true) Long id) {
		communicationSchedulingService.cancelById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	private CommunicationSchedulingDto generateCreateCommand(CommunicationSchedulingDto dto, Long ownerId, Long targetId) {
		if (dto == null) dto = new CommunicationSchedulingDto();
		dto.setTargetId(targetId);
		dto.setOwnerId(ownerId);
		return dto;
	}
}
