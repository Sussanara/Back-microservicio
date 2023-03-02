package com.formacionbdi.microservicios.app.usuarios.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Trabajador;
import com.formacionbdi.microservicios.app.usuarios.services.TrabajadorService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/trabajadores")
public class TrabajadorController {
	
	@Autowired
	private TrabajadorService service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<Trabajador> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Trabajador trabajador){
		Trabajador trabajadorDb = service.save(trabajador);
		return ResponseEntity.status(HttpStatus.CREATED).body(trabajadorDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Trabajador trabajador, @PathVariable Long id){
		Optional <Trabajador> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Trabajador trabajadorDb = o.get();
		trabajadorDb.setNombre(trabajador.getNombre());
		trabajadorDb.setEmail(trabajador.getEmail());
		trabajadorDb.setArea(trabajador.getArea());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(trabajadorDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	public Trabajador obtenerPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Trabajador agregar(Trabajador trabajadorN) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Trabajador> listado() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> create(Trabajador trabajador) {
		// TODO Auto-generated method stub
		return null;
	}
}
