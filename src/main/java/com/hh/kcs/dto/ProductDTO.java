package com.hh.kcs.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema
public class ProductDTO {
    @NotBlank
    private String id;
    @NotBlank
    @Size(min = 0, max = 20)
    private String name;
    @NotBlank
    @Size(min = 0, max = 100)
    private String description;
}
