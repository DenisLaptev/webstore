package com.lap.helper;

import com.lap.dto.ProductGroupDto;
import com.lap.dto.UserDto;
import com.lap.entity.ProductGroup;
import com.lap.entity.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kovantonlenko on 7/14/2016.
 */
public class TransformerProductGroup {

    public static ProductGroupDto transformProductGroupToProductGroupDTO(ProductGroup productGroup) {
        ProductGroupDto productGroupDto = new ProductGroupDto();
        productGroupDto.setId(productGroup.getId());
        productGroupDto.setShortName(productGroup.getShortName());
        productGroupDto.setDescription(productGroup.getDescription());
        return productGroupDto;
    }

    public static List<ProductGroupDto> transformListProductGroupToProductGroupDTO(List<ProductGroup> productGroups) {
        List<ProductGroupDto> productGroupDtos = new LinkedList<>();
        for (ProductGroup productGroup : productGroups) {
            ProductGroupDto productGroupDto = transformProductGroupToProductGroupDTO(productGroup);
            productGroupDtos.add(productGroupDto);
        }
        return productGroupDtos;
    }
}
