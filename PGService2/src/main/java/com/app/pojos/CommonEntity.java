package com.app.pojos;

import javax.persistence.*;
import javax.persistence.MappedSuperclass;

import lombok.*;

@MappedSuperclass
@Getter
@Setter
public class CommonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
