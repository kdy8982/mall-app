package com.dykim.mall.controller;

import com.dykim.mall.dto.PageRequestDTO;
import com.dykim.mall.dto.PageResponseDTO;
import com.dykim.mall.dto.ProductDTO;
import com.dykim.mall.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product/")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("list")
    public PageResponseDTO<ProductDTO> list(PageRequestDTO pageRequestDTO) {
        PageResponseDTO<ProductDTO> pageResponseDTO = productService.getList(pageRequestDTO);
        return pageResponseDTO;

    }

    @GetMapping("{pno}")
    public ProductDTO read(@PathVariable("pno") Long pno) {
        return productService.get(pno);
    }
}
