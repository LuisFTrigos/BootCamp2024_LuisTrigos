package com.example.tienda_emazon.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class Category {

    @jakarta.persistence.Id
    @GeneratedValue
    private long Id;
    private String name;
    private String description;

    private static final int MaxSizeWord = 50;
    private static final int MaxSizeDescription = 90;

    public Category(long id, String name, String description) {
        Id = id;
        if (name.length() > MaxSizeWord) {
            throw new IllegalArgumentException("El nombre no puede tener más de " + MaxSizeWord + " caracteres.");
        }else {
            this.name = name;
        }
        if (description.length() > MaxSizeDescription) {
            throw new IllegalArgumentException("La descripciòn no puede tener más de " + MaxSizeDescription + " caracteres.");
        }else {
            this.description = description;
        }
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
