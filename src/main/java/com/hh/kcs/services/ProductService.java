package com.hh.kcs.services;

import com.hh.kcs.dto.ProductDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService  implements IProductService{
    private List<ProductDTO> productDTOList=new ArrayList<>();


    @PostConstruct
    public void initialize(){
        productDTOList.add(ProductDTO.builder().id("1").name("Potato").description("Indian Potato").build());
        productDTOList.add(ProductDTO.builder().id("2").name("Tomato").description("Indian Tomato").build());
    }

    public ProductDTO addProduct(ProductDTO productDTO){
        productDTOList.add(productDTO);
        return productDTO;
    }

    public List<ProductDTO> getProductDTOList() {
        return productDTOList;
    }
}
