package org.example.alvin.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable {
    private static final int DEFAULT_PAGE_SIZE = 20;
    private int pageSize = DEFAULT_PAGE_SIZE;
    private final long start;
    private List<T> data;
    private final long totalCount;

    public Page() {
        this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<>());
    }

    public Page(long start, long totalCount, int pageSize, List<T> data) {
        this.pageSize = pageSize;
        this.start = start;
        this.data = data;
        this.totalCount = totalCount;
    }

    public long getTotalPageCount() {
        long pageCount;
        if (this.totalCount % this.pageSize == 0) {
            pageCount = this.totalCount / this.pageSize;
        } else {
            pageCount = this.totalCount / this.pageSize + 1;
        }
        return pageCount;
    }

    /**
     * 获取当前页码，页码从1开始
     * @return current page number
     */
    public long getCurrentPageNo() {
        return this.start / this.pageSize + 1;
    }

    public boolean hasNextPage() {
        return this.getCurrentPageNo() < this.getTotalPageCount();
    }

    public boolean hasPreviousPage() {
        return this.getCurrentPageNo() > 1;
    }


    public static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    /**
     * 获取任意一页第一条数据在数据集中的位置
     * @param pageNo 页码
     * @param pageSize 每页的记录数
     * @return 该页第一条数据下标
     */
    public static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }
}
