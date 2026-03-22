package com.microservicios.app.futfem.positions.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservicios.app.futfem.positions.models.entity.Position;

public interface PositionRepository extends CrudRepository<Position, String> {

	
	
}
