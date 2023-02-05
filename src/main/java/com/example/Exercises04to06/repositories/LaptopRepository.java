package com.example.Exercises04to06.repositories;

import com.example.Exercises04to06.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository <Laptop, Long> {
}
