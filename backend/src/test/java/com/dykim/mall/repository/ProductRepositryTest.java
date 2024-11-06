package com.dykim.mall.repository;

import com.dykim.mall.entity.Product;
import com.dykim.mall.entity.ProductImage;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepositry;

    @Test
    public void testSave() {
        for (int i = 1; i <= 20; i++) {
            Product product = Product.builder()
                    .pname("상품명_" + i)
                    .price(1000)
                    .imageList(
                            List.of(
                                    ProductImage.builder().fileName("img_" + i).build()
                            )
                    )
                    .build();

            productRepositry.save(product);
        }
    }

    @Test
    public void testFindById() {
        Optional<Product> result = productRepositry.findById(2L);
        Product product = result.orElseThrow();
        log.info(product);
    }

    @Test
    public void testSelectOne() {
        Optional<Product> result = productRepositry.selectOne(2L);
        Product product = result.orElseThrow();

        log.info(product);
    }

    @Test
    public void testSelectList() {
        PageRequest pageRequest = PageRequest.of(1, 10);
        Page<Product> list = productRepositry.selectList(pageRequest);

        Product product = list.getContent().get(0);
        log.info(product);
    }

}