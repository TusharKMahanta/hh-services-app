package com.hh.kcs.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Sharded;

@Document("products")
@Data
@Builder
@Sharded(shardKey = { "type" })
public class ProductModel {
  @Id
  private String id;
  private String name;
  private String type;
  private String description;
}
