package com.example.tienda_emazon.infrastructure.out.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Builder
@Table(name = "supplies")
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String supplyName;
    private String supplyDescription;
    private long amount;
    private long price;

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brandId")
    private BrandEntity brandEntity;*/

    //@ManyToMany(fetch = FetchType.EAGER)
    /*@JoinTable(
            name = "supply_category",
            joinColumns = @JoinColumn(name = "supplyId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))*/
    //private List<CategoryEntity> supplyCategories;
}
