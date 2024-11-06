package com.dykim.mall.service;

import com.dykim.mall.dto.PageRequestDTO;
import com.dykim.mall.dto.PageResponseDTO;
import com.dykim.mall.dto.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class ProductServiceImplTest {

    @Autowired
    ProductService productService;


    @Test
    public void testGet() {
        log.info(productService.get(2L));
    }


    @Test
    public void testGetList() {
        PageResponseDTO<ProductDTO> pageResponseDTO = productService.getList(new PageRequestDTO());

        log.info(pageResponseDTO);

    }

}