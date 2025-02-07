package com.ramirez.eventos.service;

import com.ramirez.eventos.entity.Evento;
import java.util.List;

public interface EventoService {
	public List<Evento> findall();
	public Evento findById(int id);
	public Evento save(Evento obj);
	public void delete(int id);
	List<Evento> findAll();

}
