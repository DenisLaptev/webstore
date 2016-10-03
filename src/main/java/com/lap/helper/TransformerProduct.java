package com.lap.helper;


import com.lap.dto.ProductDto;
import com.lap.dto.UserDto;
import com.lap.entity.Product;
import com.lap.entity.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kovantonlenko on 7/14/2016.
 */
public class TransformerProduct {

    public static ProductDto transformProductToProductDTO(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setShortName(product.getShortName());
        productDto.setDescription(product.getDescription());
        productDto.setCount(product.getCount());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    public static List<ProductDto> transformListProductToProductDTO(List<Product> products) {
        List<ProductDto> productDtos = new LinkedList<>();
        for (Product product : products) {
            ProductDto productDto = transformProductToProductDTO(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }
}
