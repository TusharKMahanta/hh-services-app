package com.hh.kcs.services;

import com.hh.kcs.dto.ProductDTO;
import com.hh.kcs.models.ProductModel;
import com.hh.kcs.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
  final private List<ProductDTO> productDTOList = new ArrayList<>();
  @Autowired
  private ProductRepository productRepository;

  @PostConstruct
  public void initialize() {
    productDTOList.add(ProductDTO.builder().id("1").name("Potato").description("Indian Potato").build());
    productDTOList.add(ProductDTO.builder().id("2").name("Tomato").description("Indian Tomato").build());
  }

  public ProductDTO addProduct(ProductDTO productDTO) {
    productRepository.save(prepareProductModel(productDTO));
    productDTOList.add(productDTO);
    return productDTO;
  }

  private ProductModel prepareProductModel(ProductDTO productDTO) {
    return ProductModel.builder()
      .id(productDTO.getId())
      .name(productDTO.getName())
      .type(productDTO.getType())
      .description(productDTO.getDescription())
      .build();
  }

  public List<ProductDTO> getProductDTOList() {
    return productDTOList;
  }
}
