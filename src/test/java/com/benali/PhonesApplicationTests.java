package com.benali;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import ch.qos.logback.core.status.Status;

import com.benali.dao.ProduitRepository;
import com.benali.entitites.Produit;
import com.benali.entitites.User;
import com.benali.metier.ProduitMetier;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PhonesApplicationTests {

	@Autowired
	private ProduitMetier pm;
	
	@MockBean
	private ProduitRepository pr;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void saveProduitTest() {
		Produit p = new Produit(9l, "tesla", new User());
		when(pr.save(p)).thenReturn(p);
		assertEquals(p, pm.saveProduit(p));
	}
	
	@Test
	@WithMockUser(roles="ADMIN")
	public void uploadFileGetTest() throws Exception{
		mockMvc.perform(get("/l/ajouterPhoto"))
			//.andExpect(status().isOk())
			.andExpect(view().name("/l/ajouterPhoto"));
	}

}
