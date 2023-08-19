package com.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.Converterdto;
import com.app.dto.UserDto;

import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDao userdao;
	
	@Autowired
	public ModelMapper mapper;

	@Override
	public List<UserDto> getAllusers() {
		
		  List<UserDto> UserDtoList = new ArrayList<UserDto>();
	        List<User> users = userdao.findAll();
	        UserDtoList = Arrays.asList(mapper.map(users,UserDto[].class));
	        return UserDtoList; 
		
	}

	@Override
	public UserDto getById(Long id) {
		
		User user = userdao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User ID !!!!!"));
		return mapper.map(user, UserDto.class);
	}

	@Override
	public User addUser(UserDto user) {
		
        Converterdto dto = new Converterdto();
        User u = dto.toUser(user);
        User u1 = userdao.save(u);
		return u1;
	}

	@Override
	public String deleteUser(Long id) {
		
		User u = userdao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid city ID !!!!!"));
		userdao.delete(u);
		return "User Deleted";
	}

	@Override
	public User updateUser(UserDto udto) {
		User u = userdao.findById(udto.getId()).orElseThrow(() -> new ResourceNotFoundException("Invalid city ID !!!!!"));
		Converterdto dto = new Converterdto();
		User u1  = dto.toUser(udto);
		return userdao.save(u1);
		
	}

	@Override
	public AuthResp Signin(AuthRequest req) {
		User user =userdao.findByEmailAndPassword(req.getEmail(), req.getPassword()).orElseThrow(()-> new ResourceNotFoundException("invalid email or Password....!"));
		
		return mapper.map(user, AuthResp.class);
	}

   
	
	

}
