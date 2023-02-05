package com.example.Exercises04to06;

import com.example.Exercises04to06.entities.Laptop;
import com.example.Exercises04to06.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Exercises04to06Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Exercises04to06Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop01 = new Laptop(null, "Lenovo", "ThinkPad", 15.6, "AMD Ryzen 5", 16, true);
		repository.save(laptop01);
		Laptop laptop02 = new Laptop(null, "HP", "Pavilion", 17.3, "Intel I5", 8, false);
		repository.save(laptop02);

	}

}
