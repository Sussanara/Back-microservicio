package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.Optional;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Trabajador;

public interface TrabajadorService {
	
	public Iterable<Trabajador> findAll();
	
	public Optional<Trabajador> findById(Long id);
	
	public Trabajador save(Trabajador trabajador);
	
	public void deleteById(Long id);

	public Object obtenerTrabajadorPorId(long id);

	public Object eliminarTrabajador(long id);

	public Object agregarTrabajador(Trabajador trabajador1);

	public Object editarTrabajador(Trabajador trabajador2);

	public static Optional<?> getTrabajadorById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
