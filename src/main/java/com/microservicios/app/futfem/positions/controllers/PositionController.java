package com.microservicios.app.futfem.positions.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.app.futfem.positions.models.entity.Position;
import com.microservicios.app.futfem.positions.services.PositionService;

@RestController
public class PositionController {
	
	@Autowired
	private PositionService service;
	
	@GetMapping ("/")  // sirve para dar una ruta al RestController, es un método Handler
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")   // pasamos un parámetro de la ruta
	public ResponseEntity<?> ver(@PathVariable String id){
		Optional<Position> o = service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build(); // HTTPStatus 404
		}else {
			return ResponseEntity.ok(o.get());  // HTTPStatus 200
		}
	}
		
	@PostMapping ("/")
	public ResponseEntity<?> crear(@RequestBody Position position){
		Position positionDb = service.save(position);
		return ResponseEntity.status(HttpStatus.CREATED).body(positionDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Position position, @PathVariable String id){
		Optional<Position> o = service.findById(id);
		
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Position positionDb = o.get();
		positionDb.setId(position.getId());
		positionDb.setDescripcion(position.getDescripcion());
		positionDb.setIdioma(position.getIdioma());
		
		
		// service.save(alumnoDb) permite persistir el alumno con los datos editados
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(positionDb));  // HTTPStatus 201
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable String id){
		service.deleteById(id);
		return ResponseEntity.noContent().build(); // HTTPStatus 204
	}
}
