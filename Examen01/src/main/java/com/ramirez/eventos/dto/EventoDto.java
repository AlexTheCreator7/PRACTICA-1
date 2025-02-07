package com.ramirez.eventos.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventoDto {
	private int id;
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private BigDecimal costo;
    private Date createdAt;
    private Date updatedAt;
}
