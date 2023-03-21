package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.inti.repository.IproduitRepository;

@Controller
public class ProduitController {
	@Autowired
	IproduitRepository ipr;
	@GetMapping("products")
	public String getAllProduct(Model m)
	{
		m.addAttribute("listeP", ipr.findAll());
		return"products";
	}

}
