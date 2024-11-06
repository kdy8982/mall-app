package com.dykim.mall.service;

import com.dykim.mall.dto.PageRequestDTO;
import com.dykim.mall.dto.PageResponseDTO;
import com.dykim.mall.dto.ProductDTO;
import com.dykim.mall.entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public interface ProductService {
    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);

    Long register(ProductDTO productDTO);

    ProductDTO get(Long pno);

    void modify(ProductDTO productDTO);

    void remove(Long pno);

    default public ProductDTO entityToDTO(Product product) {

        ProductDTO dto = ProductDTO.builder()
                .pno(product.getPno())
                .pname(product.getPname())
                .price(product.getPrice())
                .delFlag(product.isDelFlag())
                .build();

        if (!product.getImageList().isEmpty()) {
            List<String> fileNameList = product.getImageList().stream().map(productImage -> {
                return productImage.getFileName();
            }).collect(Collectors.toList());

            dto.setUploadFileNames(fileNameList);
        }

        return dto;
    }
}
