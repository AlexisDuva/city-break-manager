package com.example.city_break_manager;

import com.example.city_break_manager.domain.City;
import com.example.city_break_manager.repository.CityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UnitTests {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldCreateCity() throws Exception {

        MvcResult result = mvc.perform(
                        MockMvcRequestBuilders.post("/api/cities")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("name", "Paris")
                                .param("country", "France")
                                .param("details", "Capital city")
                )
                .andExpect(status().isOk()).andReturn();

        String json = result.getResponse().getContentAsString();
        // parser le JSON → extraire l'id
        ObjectMapper mapper = new ObjectMapper();
        City createdCity = mapper.readValue(json, City.class);

        City fromRepo = cityRepository.findById(createdCity.getId())
                .orElseThrow(() -> new RuntimeException("City not found with id " + createdCity.getId()));

        assertNotNull(fromRepo);
        assertEquals("Paris", fromRepo.getName());
    }

}