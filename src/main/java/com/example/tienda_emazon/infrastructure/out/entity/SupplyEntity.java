package com.example.tienda_emazon.infrastructure.out.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "supplies")
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSupply;
    @Column(unique = true, length = 50)
    private String name;
    @Column(length = 100)
    private String descriptionSupply;
    @Column
    private long amountSupply;
    @Column
    private long priceSupply;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brandId", nullable = false)
    private BrandEntity brandEntity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "supply_category",
            joinColumns = @JoinColumn(name = "supplyId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    List<CategoryEntity> supplyCategories;

}
