package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Trabajador;
import com.formacionbdi.microservicios.app.usuarios.models.repository.TrabajadorRepository;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {
	
	@Autowired
	private TrabajadorRepository repository;
	
	@Transactional(readOnly = true)
	public Iterable<Trabajador> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Trabajador> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Trabajador save(Trabajador trabajador) {
		return repository.save(trabajador);
	}

	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Object obtenerTrabajadorPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eliminarTrabajador(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object agregarTrabajador(Trabajador trabajador1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object editarTrabajador(Trabajador trabajador2) {
		// TODO Auto-generated method stub
		return null;
	}

}
