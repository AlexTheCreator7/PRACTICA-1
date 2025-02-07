package com.ramirez.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramirez.eventos.converter.EventoConverter;
import com.ramirez.eventos.dto.EventoDto;
import com.ramirez.eventos.entity.Evento;
import com.ramirez.eventos.service.EventoService;
import com.ramirez.eventos.util.WrapperResponse;

@RestController
@RequestMapping("/x1/evento")
//S
public class EventoController {
	@Autowired
	private EventoService service;
	
	@Autowired
	private EventoConverter converter;
	
	@GetMapping
	public ResponseEntity<List<EventoDto>> getAll() {
        List<EventoDto> registro = converter.FromEntity(service.findAll());
        return new WrapperResponse(true, "succes", registro).createResponse();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<EventoDto> getById(@PathVariable("id") int id) {  
	    EventoDto registro = converter.FromEntity(service.findById(id));
	    if (registro == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return new WrapperResponse(true, "succes", registro).createResponse();
    }

	
	@PostMapping
	public ResponseEntity<EventoDto> create(@RequestBody EventoDto dto){
		Evento registro=service.save(converter.FromDTO(dto));
		return new WrapperResponse(true, "succes", converter.FromEntity(registro)).createResponse(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EventoDto> update(@PathVariable("id") int id,
    		@RequestBody EventoDto evento){
    	Evento eventoEntity=converter.FromDTO(evento);
    	EventoDto registro = converter.FromEntity(service.save(eventoEntity));
		return new WrapperResponse(true, "succes", registro).createResponse();
    }
    
    @DeleteMapping("/(id)")
    public ResponseEntity<EventoDto> delete(@PathVariable("id")int id){
      service.delete(id);
      return new WrapperResponse(true, "succes", null).createResponse();
    }
    
	
	
}

