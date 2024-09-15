package com.harrisson.graph_parking.core;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

@Audited
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class EntityBase {

	@JsonIgnore
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@JsonIgnore
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@JsonIgnore
	@UpdateTimestamp
	private LocalDateTime deletedAt;
}
