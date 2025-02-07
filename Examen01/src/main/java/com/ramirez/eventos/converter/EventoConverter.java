package com.ramirez.eventos.converter;

import org.springframework.stereotype.Component;
import com.ramirez.eventos.dto.EventoDto;
import com.ramirez.eventos.entity.Evento;

@Component
public class EventoConverter extends AbstractConverter<Evento, EventoDto> {
	
    @Override
    public EventoDto FromEntity(Evento entity) {
        if (entity == null) {
            return null;
        }
        return EventoDto.builder()
            .id(entity.getId())
            .nombre(entity.getNombre())
            .descripcion(entity.getDescripcion())
            .fechaInicio(entity.getFechaInicio())
            .fechaFin(entity.getFechaFin())
            .costo(entity.getCosto())
            .createdAt(entity.getCreatedAt())
            .updatedAt(entity.getUpdatedAt())
            .build();
    }

    @Override
    public Evento FromDTO(EventoDto dto) {
        if (dto == null) {
            return null;
        }
        return Evento.builder()
            .id(dto.getId())
            .nombre(dto.getNombre())
            .descripcion(dto.getDescripcion())
            .fechaInicio(dto.getFechaInicio())
            .fechaFin(dto.getFechaFin())
            .costo(dto.getCosto())
            .createdAt(dto.getCreatedAt())
            .updatedAt(dto.getUpdatedAt())
            .build();
    }
}
