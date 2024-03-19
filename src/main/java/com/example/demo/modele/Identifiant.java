package com.example.demo.modele;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data

@EntityListeners(AuditingEntityListener.class)
public  abstract class Identifiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	@CreatedDate
	//pourquoi qaund jecris name il cree deuw attribus
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime creationDate;
	@LastModifiedDate
	@Column(nullable = false, updatable = false)

	private LocalDateTime lastUpdate;
}
