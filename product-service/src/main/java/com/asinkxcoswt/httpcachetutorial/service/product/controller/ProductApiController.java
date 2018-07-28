package com.asinkxcoswt.httpcachetutorial.service.product.controller;

import com.asinkxcoswt.httpcachetutorial.service.product.dto.ProductDTO;
import com.asinkxcoswt.httpcachetutorial.service.product.service.ProductService;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductApiController {

    private ProductService productService;

    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> searchProducts(
            @RequestParam MultiValueMap<String, String> params,
            WebRequest webRequest) {

        ZonedDateTime productTableLastModifiedDate = productService.getProductTableLastModifiedDate();
        if (webRequest.checkNotModified(productTableLastModifiedDate.toEpochSecond())) {
            return null;
        }

        List<ProductDTO> productList = productService.searchProducts(params)
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .header(HttpHeaders.CACHE_CONTROL, CacheControl.empty().cachePublic().getHeaderValue())
                .body(productList);
    }
}
