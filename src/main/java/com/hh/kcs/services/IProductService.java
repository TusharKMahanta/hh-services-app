package com.hh.kcs.services;

import com.hh.kcs.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    ProductDTO addProduct(ProductDTO productDTO);
    List<ProductDTO> getProductDTOList();
}
