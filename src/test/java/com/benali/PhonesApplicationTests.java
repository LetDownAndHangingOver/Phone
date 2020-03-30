package com.benali;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.benali.dao.ProduitRepository;
import com.benali.entitites.Produit;
import com.benali.entitites.User;
import com.benali.metier.ProduitMetier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhonesApplicationTests {

	@Autowired
	private ProduitMetier pm;
	
	@MockBean
	private ProduitRepository pr;
	
	@Test
	public void saveProduitTest() {
		Produit p = new Produit(9l, "tesla", new User());
		when(pr.save(p)).thenReturn(p);
		assertEquals(p, pm.saveProduit(p));
		
		
	}

}
