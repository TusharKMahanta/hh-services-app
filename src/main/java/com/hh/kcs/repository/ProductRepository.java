package com.hh.kcs.repository;

import com.hh.kcs.models.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository  extends MongoRepository<ProductModel,String> {
}
