package com.hh.kcs.controllers;

import com.hh.kcs.dto.ProductDTO;
import com.hh.kcs.dto.StoreProductStockDTO;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Warehouse Management", description = "Warehouse Management")
@RestController
@RequestMapping("/hh/stores/{storeId}")
public class StoreController {
    @Autowired
    private IProductService productService;
    @Operation(summary = "Get list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found list of products",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))})})
    @GetMapping(path = "/products")
    public @ResponseBody ResponseEntity<List<ProductDTO>> listOfProduct(@PathVariable("storeId") String storeId) {
        List<ProductDTO> productList = productService.getProductDTOList();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @Operation(summary = "Create product entity")
    @PostMapping(path = "/products")
    public @ResponseBody ResponseEntity<ProductDTO> addProduct(@PathVariable("storeId") String storeId, @RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }
    @Operation(summary = "Get Product Stock details")
    @GetMapping(path = "/products/{productId}/stock")
    public @ResponseBody ResponseEntity<StoreProductStockDTO> productStockDetails(@PathVariable("storeId") String storeId,@PathVariable("productId") String productId) {
        StoreProductStockDTO storeProductStockDTO=new StoreProductStockDTO();
        return new ResponseEntity<>(storeProductStockDTO, HttpStatus.OK);
    }
}
