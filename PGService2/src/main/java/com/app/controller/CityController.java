package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.dto.Citiesdto;
import com.app.pojos.Cities;
import com.app.service.CityServ;

@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityServ cityService;
	
	public CityController() {
		System.out.println("CityControllerCalled");
	}
	
	@GetMapping
	public List<Citiesdto> listAllCities(){
		System.out.println("in listCities");
		return cityService.getAllCities();
	}
	
	@GetMapping("/{id}")
	public Citiesdto getById(@PathVariable Long id){
		System.out.println("in listCities");
		return cityService.getById(id);
	}
	
	@PostMapping
	public Cities addCity(@RequestBody Citiesdto city) {
	
		return cityService.addCity(city);
	}
	
	@DeleteMapping("/{id}")
	public String city(@PathVariable Long id) {
		return cityService.deleteCities(id);
	}
	
}
