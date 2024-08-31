package com.example.tienda_emazon.domain.model.query;

public class PagebleQueryImpl implements PageableQuery {

    private int page;
    private int itemsPerPage;
    private String sortedBy;
    private String inOrder;

    public PagebleQueryImpl(int page, int itemsPerPage, String sortedBy, String inOrder) {
        this.page = page;
        this.itemsPerPage = itemsPerPage;
        this.sortedBy = sortedBy;
        this.inOrder = inOrder;
    }

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    @Override
    public String getSortedBy() {
        return sortedBy;
    }

    @Override
    public String getInOrder() {
        return inOrder;
    }
}
