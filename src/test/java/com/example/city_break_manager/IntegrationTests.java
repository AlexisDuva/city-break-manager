package com.example.city_break_manager;

import com.example.city_break_manager.domain.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void shouldCreateCity() {
        // Préparer les paramètres form-data
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "Paris");
        params.add("country", "France");
        params.add("details", "Capital city");

        // Envoyer la requête
        ResponseEntity<City> response = template.postForEntity(
                "/api/cities",
                params,
                City.class
        );

        // Vérifications
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        City created = response.getBody();
        assertThat(created).isNotNull();
        assertThat(created.getName()).isEqualTo("Paris");
    }
}