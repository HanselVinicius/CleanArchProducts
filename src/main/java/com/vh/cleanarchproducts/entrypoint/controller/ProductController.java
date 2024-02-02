package com.vh.cleanarchproducts.entrypoint.controller;

import com.vh.cleanarchproducts.core.usecase.product.FindProductByIdUseCase;
import com.vh.cleanarchproducts.core.usecase.product.InsertProductUseCase;
import com.vh.cleanarchproducts.core.usecase.product.UpdateProductUseCase;
import com.vh.cleanarchproducts.entrypoint.controller.mapper.ProductMapper;
import com.vh.cleanarchproducts.entrypoint.controller.mapper.ProductUpdateRequest;
import com.vh.cleanarchproducts.entrypoint.controller.transfer.request.ProductInsertRequest;
import com.vh.cleanarchproducts.entrypoint.controller.transfer.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/products")
public class ProductController {


    @Autowired
    private FindProductByIdUseCase findProductByIdUseCase;

    @Autowired
    private InsertProductUseCase insertProductUseCase;

    @Autowired
    private UpdateProductUseCase updateProductUseCase;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    @Operation(summary = "Pega um produto pelo id")
    public ResponseEntity getProductById(@PathVariable String id) {
        var productResponse = productMapper.toProductResponse(findProductByIdUseCase.findProductById(id));
        return ResponseEntity.ok().body(productResponse);
    }

    @PostMapping
    @Operation(summary = "Insere um produto")
    public ResponseEntity insertProduct(@RequestBody @Valid ProductInsertRequest productRequest) {
        var createdProduct = insertProductUseCase.insertProduct(productMapper.productInsertRequestToProduct(productRequest));
        return ResponseEntity.ok(this.productMapper.toProductResponse(createdProduct));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um produto")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody @Valid ProductUpdateRequest productRequest) {
        var productToUpdate = productMapper.productUpdateRequestToProduct(productRequest);
        ProductResponse productResponse = productMapper.toProductResponse(updateProductUseCase.updateProduct(id,productToUpdate));
        return ResponseEntity.ok(productResponse);
    }




}
