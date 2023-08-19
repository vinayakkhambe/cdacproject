package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Properties")
public class Properties extends CommonEntity{
	
	@Column	
	private String name;
	@Column(length = 800)
	private String description;
	@Column
	private String address;
	@Column
	@Enumerated(EnumType.STRING) 
	private Gender gender;
	@Column
	private double rent;
	@Column
	private	float ratingClean;
	@Column
	private float ratingFood;
	@Column
	private float ratingSafety;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name ="city_id")
	private Cities myCity;
		
	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="Properties_Facilities",
	joinColumns =  @JoinColumn(name="property_id"),
	inverseJoinColumns =  @JoinColumn(name="facility_id"))
	private List<Facilities> facilities=new ArrayList<Facilities>();
	
	@ManyToMany(mappedBy = "properties",fetch = FetchType.LAZY)
	private List<User> users = new ArrayList<User>();
	
}
