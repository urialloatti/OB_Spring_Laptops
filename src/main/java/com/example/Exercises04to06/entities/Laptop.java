package com.example.Exercises04to06.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "Laptops")
public class Laptop {
    // Attributes
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    String brand;
    String model;
    Double size;
    String processor;
    Integer ram;
    Boolean hasDedicatedGraphicCard;

    // Constructors
    public Laptop() {
    }
    public Laptop(Long id, String brand, String model, Double size, String processor, Integer ram, Boolean hasDedicatedGraphicCard) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.processor = processor;
        this.ram = ram;
        this.hasDedicatedGraphicCard = hasDedicatedGraphicCard;
    }

// Getter & Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Double getSize() {
        return size;
    }
    public void setSize(Double size) {
        this.size = size;
    }
    public String getProcessor() {
        return processor;
    }
    public void setProcessor(String processor) {
        this.processor = processor;
    }
    public Integer getRam() {
        return ram;
    }
    public void setRam(Integer ram) {
        this.ram = ram;
    }
    public Boolean getHasDedicatedGraphicCard() {
        return hasDedicatedGraphicCard;
    }
    public void setHasDedicatedGraphicCard(Boolean hasDedicatedGraphicCard) {
        this.hasDedicatedGraphicCard = hasDedicatedGraphicCard;
    }
    // ToString

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", size=" + size +
                ", processor='" + processor + '\'' +
                ", ram=" + ram +
                ", hasDedicatedGraphicCard=" + hasDedicatedGraphicCard +
                '}';
    }
}
