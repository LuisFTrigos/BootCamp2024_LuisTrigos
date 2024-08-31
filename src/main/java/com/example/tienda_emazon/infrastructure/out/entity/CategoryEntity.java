package com.example.tienda_emazon.infrastructure.out.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategory;
    @Column(unique = true,length = 50)
    private String name;
    @Column(length = 90)
    private String descriptionCategory;

    @ManyToMany(mappedBy = "supplyCategories", fetch = FetchType.LAZY)
    private Set<SupplyEntity> supplies;

}
