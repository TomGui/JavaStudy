package com.tom.dto;

public class SearchBase {
    // 分页大小
    private int pageSize = 10;

    // 分页页号（从1开始）
    private int pageIndex = 1;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getBeginIndex() {
        return (pageIndex - 1) * 10;
    }
}
