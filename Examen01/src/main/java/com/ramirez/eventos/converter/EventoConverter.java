package com.ramirez.eventos.converter;
import org.springframework.stereotype.Component;

import com.ramirez.eventos.dto.EventoDto;

import com.ramirez.eventos.entity.Evento;

@Component

public class EventoConverter extends AbstractConverter<Evento, EventoDto> {
	
	@Override
	public EventoDto FromEntity(Evento entity) {
		if(entity == null) {
			return null;
		}
		return EventoDto.builder()
		.id(entity.getId())
		.nombre(entity.getNombre()).build();
	}
	@Override
	public Evento FromDTO(EventoDto dto) {
		if(dto==null) {
		return null;
	}
		return Evento.builder()
        .id(dto.getId())
        .nombre(dto.getNombre()).build();
	}
}