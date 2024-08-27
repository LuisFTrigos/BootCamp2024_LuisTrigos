package com.example.tienda_emazon.domain.model;

public interface PageableQuery {

    Integer getPage();

    Integer getItemsPerPage();

    String getSortedBy();

    String getInOrder();
}
