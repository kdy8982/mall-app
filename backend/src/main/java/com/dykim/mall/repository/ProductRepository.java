package com.dykim.mall.repository;

import com.dykim.mall.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @EntityGraph(attributePaths = "imageList")
    @Query("select p, pi " +
            "from Product p " +
            "left join p.imageList pi " +
            "where p.pno = :pno")
        // @Query("select p " +
        //         "from Product p " +
        //         "where p.pno = :pno")
    Optional<Product> selectOne(@Param("pno") Long pno);

    @EntityGraph(attributePaths = "imageList")
    @Query("select p " +
            "from Product p " +
            "left join p.imageList pi " +
            "where pi.ord = 0 " +
            "and p.delFlag = false"
    )
    Page<Product> selectList(Pageable pageable);
}
