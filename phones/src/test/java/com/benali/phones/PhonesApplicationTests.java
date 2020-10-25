package com.benali.phones;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class PhonesApplicationTests {

	MockMvc mockMvc;

	@Test
	public void getallProductsTest() throws Exception {
		mockMvc.perform(get("/l/listproduits/1")).andExpect(status().isOk());
		
	}

}
