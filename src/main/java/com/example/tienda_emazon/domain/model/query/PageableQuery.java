package com.example.tienda_emazon.domain.model.query;

public interface PageableQuery {

    Integer getPage();

    Integer getItemsPerPage();

    String getSortedBy();

    String getInOrder();
}
