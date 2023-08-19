package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User extends CommonEntity 
{      
	  
		@Column
		private String email;
		@Column(nullable = false)
		private String password;
		@Column(nullable = false)
		private String fullName;
		@Column(nullable = false)
		private long mobNo;
		@Column
		@Enumerated(EnumType.STRING) 
		private Gender gender;
		@Column(nullable = false)
		private String role;
	
		@OneToMany(mappedBy ="user", cascade = CascadeType.ALL,orphanRemoval = true,fetch= FetchType.EAGER)
		private List<Reviews> reviews = new ArrayList<>();	
		
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinTable(name ="interested_users_properties",
				joinColumns = @JoinColumn(name ="user_id"),
				inverseJoinColumns = @JoinColumn(name="property_id"))
		private List<Properties> properties = new ArrayList<>();
}
