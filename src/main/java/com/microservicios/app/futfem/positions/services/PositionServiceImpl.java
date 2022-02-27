package com.microservicios.app.futfem.positions.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicios.app.futfem.positions.models.entity.Position;
import com.microservicios.app.futfem.positions.models.repository.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionRepository repository;
	
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Position> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Position> findById(String id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Position save(Position position) {
		return repository.save(position);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		repository.deleteById(id);
	}

}
