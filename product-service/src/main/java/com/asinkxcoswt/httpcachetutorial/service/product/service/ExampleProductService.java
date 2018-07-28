package com.asinkxcoswt.httpcachetutorial.service.product.service;

import com.asinkxcoswt.httpcachetutorial.service.product.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class ExampleProductService implements ProductService {

    private List<Product> exampleProductList;
    private ZonedDateTime productTableLastModifiedDate;

    public ExampleProductService() {
        this.exampleProductList = getExampleProducts();
        productTableLastModifiedDate = ZonedDateTime.now();
    }

    private List<Product> getExampleProducts() {
        return Arrays.asList(
                sample("p1", BigDecimal.valueOf(10), 10),
                sample("p2", BigDecimal.valueOf(20), 20),
                sample("p3", BigDecimal.valueOf(30), 30));
    }

    private Product sample(String name, BigDecimal price, Integer stock) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setStock(stock);
        return p;
    }

    @Override
    public List<Product> searchProducts(MultiValueMap<String, String> params) {
        return this.exampleProductList;
    }

    @Override
    public ZonedDateTime getProductTableLastModifiedDate() {
        return this.productTableLastModifiedDate;
    }
}
