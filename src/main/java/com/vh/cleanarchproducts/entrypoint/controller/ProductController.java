package com.vh.cleanarchproducts.entrypoint.controller;

import com.vh.cleanarchproducts.core.usecase.product.*;
import com.vh.cleanarchproducts.entrypoint.controller.mapper.ProductMapper;
import com.vh.cleanarchproducts.entrypoint.controller.mapper.ProductUpdateRequest;
import com.vh.cleanarchproducts.entrypoint.controller.transfer.request.ProductInsertRequest;
import com.vh.cleanarchproducts.entrypoint.controller.transfer.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private DeleteProductByIdUseCase deleteProductByIdUseCase;

    @Autowired
    private GetAllProductPaginatedUseCase getAllPaginatedUseCase;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    @Operation(summary = "Pega um produto pelo id")
    public ResponseEntity getProductById(@PathVariable String id) {
        var productResponse = productMapper.toProductResponse(findProductByIdUseCase.findProductById(id));
        return ResponseEntity.ok().body(productResponse);
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Insere um produto")
    public ResponseEntity insertProduct(@RequestBody @Valid ProductInsertRequest productRequest) {
        var createdProduct = insertProductUseCase.insertProduct(productMapper.productInsertRequestToProduct(productRequest));
        return ResponseEntity.ok(this.productMapper.toProductResponse(createdProduct));
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Atualiza um produto")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody @Valid ProductUpdateRequest productRequest) {
        var productToUpdate = productMapper.productUpdateRequestToProduct(productRequest);
        ProductResponse productResponse = productMapper.toProductResponse(updateProductUseCase.updateProduct(id,productToUpdate));
        return ResponseEntity.ok(productResponse);
    }

    //delete
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um produto")
    public ResponseEntity deleteProduct(@PathVariable String id){
        this.deleteProductByIdUseCase.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }



    //getAll paginated
    @GetMapping()
    @Operation(summary = "Pega todos os produtos")
    public ResponseEntity getAllProducts(@PageableDefault Pageable pageable){
        var products = this.getAllPaginatedUseCase.getAllPaginated(pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok().body(this.productMapper.toProductResponseList(products));
    }


}
