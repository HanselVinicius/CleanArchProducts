package com.vh.cleanarchproducts.dataprovider.repository;

import com.vh.cleanarchproducts.dataprovider.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, String> {

    Optional<ProductEntity> findProductByIdAndIsActiveTrue(String id);

    Page<ProductEntity> findAllByIsActiveTrue(Pageable pageable);



}
