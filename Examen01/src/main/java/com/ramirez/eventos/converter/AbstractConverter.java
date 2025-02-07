package com.ramirez.eventos.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E,D> {
      public abstract D FromEntity(E entity);
      public abstract E FromDTO(D dto);
      
      
      public List<D> FromEntity(List<E> entitys){
    	  return entitys.stream()
    			  .map(e -> FromEntity(e))
    			  .collect(Collectors.toList());
    	  
      }
      public List<E> FromDTO(List<D> entitys){
    	  return entitys.stream()
    			  .map(d -> FromDTO(d))
    			  .collect(Collectors.toList());
      }
}   

