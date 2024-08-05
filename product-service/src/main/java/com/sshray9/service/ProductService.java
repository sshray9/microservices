package com.sshray9.service;

import com.sshray9.dto.ProductRequest;
import com.sshray9.dto.ProductResponse;
import com.sshray9.model.Product;
import com.sshray9.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

//    public ProductService(ProductRepository productRepository) {    //@RequiredArgsConstructor ye lagane
//        this.productRepository = productRepository;                 //  ke baad const bnane ki jarurat ni
//    }

    public void creatProduct(ProductRequest productRequest){

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();

    }

    private ProductResponse mapToProductResponse(Product product) {

        ProductResponse productResponse = new ProductResponse();                    //another way

        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());

        return productResponse;

//        return ProductResponse.builder()                  //another way
//                .id(product.getId())
//                .name(product.getName())
//                .description(product.getDescription())
//                .price(product.getPrice())
//                .build();
    }
}
