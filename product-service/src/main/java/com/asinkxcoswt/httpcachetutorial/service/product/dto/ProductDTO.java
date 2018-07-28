package com.asinkxcoswt.httpcachetutorial.service.product.dto;

import com.asinkxcoswt.httpcachetutorial.service.product.domain.Product;

import java.math.BigDecimal;

public class ProductDTO {
    private String name;
    private BigDecimal price;
    private Integer stock;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
