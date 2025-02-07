package com.ramirez.eventos.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Eventos")
@EntityListeners(AuditingEntityListener.class)
public class Evento {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(nullable = false, length = 255)
	    private String nombre;

	    @Column(columnDefinition = "TEXT")
	    private String descripcion;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "fecha_inicio", nullable = false)
	    private Date fechaInicio;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "fecha_fin", nullable = false)
	    private Date fechaFin;

	    @Column(nullable = false, precision = 10, scale = 2)
	    private BigDecimal costo;

	    @Column(name = "created_at", nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreationTimestamp
	    private Date createdAt;

	    @Column(name = "updated_at", nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @UpdateTimestamp
	    private Date updatedAt;

}
