package com.app.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reviews")
public class Reviews extends CommonEntity {

	
	@ManyToOne
	@JoinColumn(name = "property_id")
	private Properties propertyid;
	
	@Column
	private String content;
	
	@Column
	private String username;
	
	@ManyToOne
	@JoinColumn(name ="User_id")
	private User user;
}
