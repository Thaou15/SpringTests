package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Produit;

//Prendre en compte les Before, After, BeaforEch .ect
@ExtendWith(SpringExtension.class)
//Faire les fontions CRUD mais faire un rollback pour pas les creer réellement car on est en test
@DataJpaTest
//Ne pas auto configurer de BDD car on va utiliser celle qu'on a configuer nous même dans properties
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProduitRepositoryTest {
	Produit p;
	Produit p1;
	@Autowired
	IproduitRepository ipr;
	
	//Avant chaque test, on appelle cette fonction
	@BeforeEach
	public void setUp()
	{
	    p = new Produit("Samsung", "S23", 1099, 1.2 );
	   
	}
	
	@Test
	public void saveTest()
	{
		//Given (informations fournis par l'utilisateur dans le formulaire)
		
//		Produit p = new Produit("Samsung", "S23", 1099, 1.2 );
			
		//When (quand on est dans cette situation)
		
		Produit savedProduit = ipr.save(p);
		
		//Then (le resultat qu'on aimerait avoir)
		
		//Verifier si le produit existe
		assertThat(savedProduit).isNotNull();
		//Verifier si l'id du produit a été autoincrémenté (si l'id est supérieur à zero)
		assertThat(savedProduit.getId()).isGreaterThan(0);
		//Vérifier si un produit avec le nom Samsung existe
		assertThat(savedProduit.getNom()).isEqualTo("Samsung");
	}
	
	@Test
	public void deleteProduit()
	{
		//Given : 
		Produit p2 = ipr.save(p);
		//When

		ipr.deleteById(p2.getId());
		
		//Then 
		Assertions.assertThrows(Exception.class,() -> ipr.getReferenceById(p2.getId()));

	}
	
	

}
