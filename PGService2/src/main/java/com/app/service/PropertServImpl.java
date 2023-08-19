package com.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CityDao;
import com.app.dao.PropertDao;
import com.app.dto.Citiesdto;
import com.app.dto.Converterdto;
import com.app.dto.Propertydto;
import com.app.pojos.Cities;
import com.app.pojos.Properties;

@Service
@Transactional
public class PropertServImpl implements PropertServ{

	
	@Autowired
	private PropertDao propertyDao;

	@Autowired
	private CityDao citiesDao;
	
	@Autowired
	public ModelMapper mapper;
	
	List<Propertydto> maptoDto(List<Properties> list){
		List<Propertydto> propertyDtoList = new ArrayList<Propertydto>();
		
		for (Properties e : list) {
			Propertydto d = new Propertydto();
			d.setAddress(e.getAddress());
			d.setDescription(e.getDescription());
			d.setName(e.getName());
			d.setGender(e.getGender());
			d.setRatingClean(e.getRatingClean());
			d.setRatingFood(e.getRatingFood());
			d.setRatingSafety(e.getRatingSafety());
			d.setRent(e.getRent());
			
			propertyDtoList.add(d);
		}
		
		return propertyDtoList;
	}
	
	@Override
	public List<Propertydto> getPropertiesByCityName(String cityName) {
//		 List<Propertydto> propertyDtoList = new ArrayList<Propertydto>();
		Cities city=citiesDao.findByName(cityName);
//		List<Properties>listprop= (List<Properties>) propertyDao.findById(city.getId()).orElseThrow(() -> new ResourceNotFoundException("Invalid city!!!!!"));
//		propertyDtoList=Arrays.asList(mapper.map(listprop,Propertydto[].class));
		return maptoDto(city.getProperties());
	}

	@Override
	public Properties addProperty(Propertydto property) {
		Converterdto converter=new Converterdto();
		Properties propt= converter.toProperty(property);
		Properties prop = propertyDao.save(propt);
		return prop;
	}
	
	

	

	

}
