package com.ramirez.eventos.validator;

import com.ramirez.eventos.entity.Evento;
import com.ramirez.eventos.exception.ValidateException;

import java.math.BigDecimal;
import java.util.Date;

public class EventoValidator {

    public static void save(Evento registro) {
        if (registro == null) {
            throw new ValidateException("El evento no puede ser nulo");
        }

       
        if (registro.getNombre() == null || registro.getNombre().trim().isEmpty()) {
            throw new ValidateException("El nombre es requerido");
        }
        if (registro.getNombre().length() > 70) {
            throw new ValidateException("El nombre no debe exceder los 70 caracteres");
        }

 
        if (registro.getDescripcion() == null || registro.getDescripcion().trim().isEmpty()) {
            throw new ValidateException("La descripción es requerida");
        }
        if (registro.getDescripcion().length() > 255) {
            throw new ValidateException("La descripción no debe exceder los 255 caracteres");
        }

       
        if (registro.getFechaInicio() == null) {
            throw new ValidateException("La fecha de inicio es requerida");
        }
        if (registro.getFechaFin() == null) {
            throw new ValidateException("La fecha de fin es requerida");
        }
        if (registro.getFechaFin().before(registro.getFechaInicio())) {
            throw new ValidateException("La fecha de fin no puede ser anterior a la fecha de inicio");
        }

      
        if (registro.getCosto() == null) {
            throw new ValidateException("El costo es requerido");
        }
        if (registro.getCosto().compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidateException("El costo no puede ser negativo");
        }

        if (registro.getCreatedAt() == null) {
            registro.setCreatedAt(new Date()); 
        }
        if (registro.getUpdatedAt() == null) {
            registro.setUpdatedAt(new Date());
        }
    }
}

