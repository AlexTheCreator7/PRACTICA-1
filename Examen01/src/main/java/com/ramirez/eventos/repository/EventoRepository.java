package com.ramirez.eventos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramirez.eventos.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{

}

