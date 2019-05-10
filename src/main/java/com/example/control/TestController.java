package com.example.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SingerDAO;
import com.example.entity.Singer;

@Service
public class TestController {

	@Autowired
	private SingerDAO singerDAO;
	
	public void testCreation() {
		Singer s = new Singer("U2");
		System.out.println("adding U2");
		s = singerDAO.save(s);
	}
}
