package com.stulikov.public_transport_stops_on_spring.jpa.repositories;

import com.stulikov.public_transport_stops_on_spring.logging.LogEntity;
import org.springframework.data.repository.CrudRepository;

public interface LogEntityRepository extends CrudRepository<LogEntity, Long> {

}
