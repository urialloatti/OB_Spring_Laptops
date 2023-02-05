package com.example.Exercises04to06.controllers;

import com.example.Exercises04to06.entities.Laptop;
import com.example.Exercises04to06.repositories.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    // Attributes
    private LaptopRepository repository;
    public final Logger log = LoggerFactory.getLogger(LaptopController.class);

    // Constructor
    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }

    // CRUD methods

    @GetMapping ("/api/laptops")
    public List<Laptop> findAll (@RequestHeader HttpHeaders header) {
        log.info("All laptops showed to " + header);
        return repository.findAll();
    }

    @GetMapping ("/api/laptops/{id}")
    public ResponseEntity <Laptop> findById (@PathVariable Long id, @RequestHeader HttpHeaders header) {
        Optional <Laptop> LaptopOpt = repository.findById(id);
        if (LaptopOpt.isPresent()) {
            log.info("Showed laptop " + id + " to " + header);
            return ResponseEntity.ok(LaptopOpt.get());
        } else return ResponseEntity.notFound().build();
    }

    @PostMapping ("/api/laptops")
    public ResponseEntity<Laptop> createLaptop (@RequestBody Laptop laptop) {
        if (laptop.getId() != null) {
            return ResponseEntity.badRequest().build();
        } else  {
            repository.save(laptop);
            return ResponseEntity.ok(laptop);
        }
    }

    @PutMapping ("/api/laptops")
    public ResponseEntity<Laptop> updateLaptop (@RequestBody Laptop laptop) {
        if (!repository.existsById(laptop.getId())) {
            log.info("Trying to update non existent Laptop ");
            return ResponseEntity.notFound().build();
        } else if (laptop.getId() == null){
            log.info("Trying to update Laptop without ID");
            return ResponseEntity.badRequest().build();
        } else {
            repository.save(laptop);
            return ResponseEntity.ok(laptop);
        }
    }

    @DeleteMapping ("/api/laptops")
    public ResponseEntity deleteAll(@RequestHeader HttpHeaders header) {
        log.info("All laptops deleted by " + header);
        repository.deleteAll();
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping ("api/laptops/{id}")
    public ResponseEntity deleteById (@PathVariable Long id, @RequestHeader HttpHeaders header) {
        if (repository.existsById(id)) {
            log.info("Laptop " + id + " being deleted by " + header);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
