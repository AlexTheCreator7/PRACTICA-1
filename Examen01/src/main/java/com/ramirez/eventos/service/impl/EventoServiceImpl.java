package com.ramirez.eventos.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ramirez.eventos.entity.Evento;
import com.ramirez.eventos.exception.GeneralException;
import com.ramirez.eventos.exception.NoDataFoundException;
import com.ramirez.eventos.exception.ValidateException;
import com.ramirez.eventos.repository.EventoRepository;
import com.ramirez.eventos.service.EventoService;
import com.ramirez.eventos.validator.EventoValidator;

@Service
public class EventoServiceImpl implements EventoService {
	@Autowired
	private EventoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Evento> findAll() {
		try {
			List<Evento> registros = repository.findAll();
			return registros;
		} catch (ValidateException | NoDataFoundException e) {
			throw e;
		} catch (GeneralException e) {
			throw new GeneralException("Error del servidor");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Evento findById(int id) {
		try {
			Evento registro = repository.findById(id).orElseThrow(
					()-> new NoDataFoundException("No existe un registro con ese ID") 
					);
			return registro;
		} catch (ValidateException | NoDataFoundException e) {
			throw e;
		} catch (GeneralException e) {
			throw new GeneralException("Error del servidor");
		}
	}

	@Override
	@Transactional
	public Evento save(Evento obj) {
	    EventoValidator.save(obj);
	    try {
	        if (obj.getId() == 0) {
	            return repository.save(obj);
	        }

	        Evento registro = this.findById(obj.getId());
	        registro.setNombre(obj.getNombre());
	        registro.setDescripcion(obj.getDescripcion());   
	        registro.setFechaInicio(obj.getFechaInicio());
	        registro.setFechaFin(obj.getFechaFin());
	        registro.setCosto(obj.getCosto());
	        registro.setUpdatedAt(new Date(System.currentTimeMillis())); 

	        return repository.save(registro);

	    } catch (ValidateException | NoDataFoundException e) {
	        throw e;
	    } catch (Exception e) {  
	        throw new GeneralException("Error al guardar el evento: " + e.getMessage());
	    }
	}

	@Override
	@Transactional
	public void delete(int id) {
		try {
			Evento registro = this.findById(id);
			repository.delete(registro);
		} catch (ValidateException | NoDataFoundException e) {
			throw e;
		} catch (GeneralException e) {
			throw new GeneralException("Error del servidor");
		}
	}

	@Override
	public List<Evento> findall() {
		// TODO Auto-generated method stub
		return null;
	}
}