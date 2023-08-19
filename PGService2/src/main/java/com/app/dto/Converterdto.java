package com.app.dto;

import com.app.pojos.Cities;
import com.app.pojos.Properties;
import com.app.pojos.User;

public class Converterdto {

	public Cities toCities(Citiesdto dto) {
		Cities entity = new Cities();
		entity.setName(dto.getName());
		entity.setId(dto.getId());
		return entity;
	}
	
	public Properties toProperty(Propertydto dto) {
		
		Properties entity=new Properties();
		entity.setAddress(dto.getAddress());
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setGender(dto.getGender());
		entity.setRatingClean(dto.getRatingClean());
		entity.setRatingFood(dto.getRatingFood());
		entity.setRatingSafety(dto.getRatingSafety());
		entity.setRent(dto.getRent());
		return entity;
	}
	
	public User toUser(UserDto dto)
	{
		User entity = new User();
		entity.setId(dto.getId());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setFullName(dto.getFullName());
		entity.setRole(dto.getRole());
		entity.setMobNo(dto.getMobNo());
		entity.setGender(dto.getGender());
		
		return entity;
		
	}
}
