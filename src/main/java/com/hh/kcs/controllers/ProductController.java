package com.hh.kcs.controllers;

import com.hh.kcs.dto.ProductDTO;
import com.hh.kcs.services.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Product Management", description = "Product Management")
@RestController
@RequestMapping("/hh")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Operation(summary = "Get list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found list of products",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))})})
    @GetMapping(path = "/products")
    public @ResponseBody ResponseEntity<List<ProductDTO>> listOfProduct() {
        List<ProductDTO> productList = productService.getProductDTOList();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @Operation(summary = "Create product entity")
    @PostMapping(path = "/products")
    public @ResponseBody ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }
}
