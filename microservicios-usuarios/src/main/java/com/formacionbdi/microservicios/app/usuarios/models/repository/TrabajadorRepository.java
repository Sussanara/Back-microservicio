package com.formacionbdi.microservicios.app.usuarios.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Trabajador;

public interface TrabajadorRepository extends CrudRepository<Trabajador, Long> {

	static Object findById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	//Iterable<Trabajador> findAll(Object object);

}
