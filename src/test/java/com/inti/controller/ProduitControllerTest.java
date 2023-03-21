package com.inti.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.inti.repository.IproduitRepository;

//Pour tester les controllers plus precisemment le ProduitController
@WebMvcTest(ProduitController.class)
public class ProduitControllerTest {
	
	//Simuler les url
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private IproduitRepository ipr;
	
	
	@Test
	public void allProducts()
	{
		//Tester l'ouverture de la page dans le navigateur
		try {
			mock.perform(get("/products"))
			.andExpect(status().isOk())
			.andExpect(view().name("products"))
//			.andExpect((ResultMatcher) content().string(containsString("Produit")))
			.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
