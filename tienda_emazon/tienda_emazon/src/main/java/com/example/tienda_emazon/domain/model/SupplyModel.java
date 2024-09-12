package com.example.tienda_emazon.domain.model;

import java.util.List;

public class SupplyModel {

    private long id;
    private String supplyName;
    private String supplyDescription;
    private List<String> associatedCategories;
    private long supplyAmount;
    private long supplyPrice;

    public List<String> getAssociatedCategories() {
        return associatedCategories;
    }

    public void setAssociatedCategories(List<String> associatedCategories) {
        this.associatedCategories = associatedCategories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public String getSupplyDescription() {
        return supplyDescription;
    }

    public void setSupplyDescription(String supplyDescription) {
        this.supplyDescription = supplyDescription;
    }

    public long getSupplyAmount() {
        return supplyAmount;
    }

    public void setSupplyAmount(long supplyAmount) {
        this.supplyAmount = supplyAmount;
    }

    public long getSupplyPrice() {
        return supplyPrice;
    }

    public void setSupplyPrice(long supplyPrice) {
        this.supplyPrice = supplyPrice;
    }
}
