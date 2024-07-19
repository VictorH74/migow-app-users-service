package com.service.users.migow.migow_users_service.infra.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SuppressWarnings("rawtypes")
public class CustomPage<T> implements Page<T> {
    private final int totalPages;
    private final long totalElements;
    private final Pageable pageable;
    private final boolean first;
    private final boolean last;
    private final int size;
    private final List<T> content;
    private final int number;
    private final Sort sort;
    private final int numberOfElements;
    private final boolean empty;

    public CustomPage(Page<T> page) {
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.pageable = page.getPageable();
        this.first = page.isFirst();
        this.last = page.isLast();
        this.size = page.getSize();
        this.content = page.getContent();
        this.number = page.getNumber();
        this.sort = page.getSort();
        this.numberOfElements = page.getNumberOfElements();
        this.empty = page.isEmpty();
    }

    @SuppressWarnings("unchecked")
    private <U> CustomPage(CustomPage<?> customPage, List<U> newContent) {
        this.pageable = customPage.getPageable();
        this.content = (List<T>) newContent; // tipo convertido
        this.totalPages = customPage.getTotalPages();
        this.totalElements = customPage.getTotalElements();
        this.size = customPage.getSize();
        this.number = customPage.getNumber();
        this.first = customPage.isFirst();
        this.last = customPage.isLast();
        this.sort = customPage.getSort();
        this.numberOfElements = customPage.getNumberOfElements();
        this.empty = customPage.isEmpty();
    }

    @Override
    public long getTotalElements() {
        return totalElements;
    }

    @Override
    public int getTotalPages() {
        return totalPages;
    }

    // @Override
    // public <U> Page<U> map(Function<? super T, ? extends U> converter) {
    // List<U> newContent = this.content.stream()
    // .map(converter)
    // .collect(Collectors.toList());
    // return new Page
    // }

    @Override
    public <U> CustomPage<U> map(Function<? super T, ? extends U> converter) {
        List<U> newContent = this.content.stream()
        .map(converter)
        .collect(Collectors.toList());
        return new CustomPage<>(this, newContent);
    }

    @SuppressWarnings({ "null" })
    @Override
    public List getContent() {
        return content;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public int getSize() {
        return size;
    }

    @SuppressWarnings("null")
    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public boolean hasContent() {
        return !content.isEmpty();
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasPrevious() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isFirst() {
        return first;
    }

    @Override
    public boolean isLast() {
        return last;
    }

    @Override
    public Pageable nextPageable() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pageable previousPageable() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("null")
    @Override
    public Pageable getPageable() {
        return pageable;
    }

    @Override
    public boolean isEmpty() {
        return empty;
    }

}
