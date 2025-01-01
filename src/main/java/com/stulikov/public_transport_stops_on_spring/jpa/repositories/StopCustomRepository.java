package com.stulikov.public_transport_stops_on_spring.jpa.repositories;

import com.stulikov.public_transport_stops_on_spring.stop.StopXmlUnmarshall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopCustomRepository extends CrudRepository<StopXmlUnmarshall, Integer> {

}
