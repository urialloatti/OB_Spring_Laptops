package com.example.Exercises04to06.controllers;

import com.example.Exercises04to06.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);

    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findById() {
        ResponseEntity<Laptop> response =
                testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void createLaptop() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json = """
                {
                    "id": null,
                    "brand": "Lenovo",
                    "model": "ThinkPad",
                    "size": 15.6,
                    "processor": "AMD Ryzen 5",
                    "ram": 16,
                    "hasDedicatedGraphicCard": true
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST,request, Laptop.class);
        Laptop result = response.getBody();
        assertEquals(1L, result.getId());
    }

    @Test
    void updateLaptop() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json = """
                {
                    "id": 1,
                    "brand": "Lenovo",
                    "model": "ThinkPad",
                    "size": 15.6,
                    "processor": "AMD Ryzen 5",
                    "ram": 16,
                    "hasDedicatedGraphicCard": true
                }
                """;
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST,request, Laptop.class);
        Laptop result = response.getBody();
        assertEquals("Lenovo", result.getBrand());
    }

    @Test
    void deleteAll() {
    }

    @Test
    void deleteById() {
    }
}