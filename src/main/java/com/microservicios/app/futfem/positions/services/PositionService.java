package com.microservicios.app.futfem.positions.services;

import java.util.Optional;

import com.microservicios.app.futfem.positions.models.entity.Position;


public interface PositionService {
	
	public Iterable<Position> findAll();
	
	public Optional<Position> findById(String id);
	
	public Position save(Position position);
	
	public void deleteById(String id);

}
