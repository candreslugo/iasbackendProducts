package com.ias.backendProducts.shared.sharedDomain;

public class PageQuery {

   private final Page page;
   private final PageSize pageSize;

    public PageQuery(Page page, PageSize pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Page getPage() {
        return page;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    @Override
    public String toString() {
        return "PageQuery{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
