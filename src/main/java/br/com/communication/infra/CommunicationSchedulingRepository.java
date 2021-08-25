package br.com.communication.infra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.communication.domain.scheduling.CommunicationSchedulingEntity;
import br.com.communication.domain.scheduling.ICommunicationSchedulingRepository;

@Repository("CommunicationSchedulingRepository")
public interface CommunicationSchedulingRepository extends JpaRepository<CommunicationSchedulingEntity, Long>, ICommunicationSchedulingRepository {

	@Query( "SELECT cs from #{#entityName} cs WHERE cs.target = :target" )
	List<CommunicationSchedulingEntity> findAllByTarget(@Param("target") String target);
}
