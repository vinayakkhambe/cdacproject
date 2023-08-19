package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cities")
//@JsonIgnoreProperties(value = {"handler","hibernateLazyInializer","FieldHandler"})
public class Cities extends CommonEntity {

	@Column
	private String name;
	@OneToMany(mappedBy ="myCity", cascade = CascadeType.ALL,orphanRemoval = true,fetch= FetchType.EAGER)
	private List<Properties> properties = new ArrayList<>();

	
}
