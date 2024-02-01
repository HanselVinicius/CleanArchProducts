package com.vh.cleanarchproducts.dataprovider.repository;

import com.vh.cleanarchproducts.dataprovider.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, String> {
}
