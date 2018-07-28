package com.asinkxcoswt.httpcachetutorial.service.product.service;

import com.asinkxcoswt.httpcachetutorial.service.product.domain.Product;
import org.springframework.util.MultiValueMap;

import java.time.ZonedDateTime;
import java.util.List;

public interface ProductService {
    List<Product> searchProducts(MultiValueMap<String, String> params);
    ZonedDateTime getProductTableLastModifiedDate();
}
