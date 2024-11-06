package com.dykim.mall.service;

import com.dykim.mall.dto.PageRequestDTO;
import com.dykim.mall.dto.PageResponseDTO;
import com.dykim.mall.dto.ProductDTO;
import com.dykim.mall.entity.Product;
import com.dykim.mall.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO) {
        Pageable pageable = PageRequest.of(pageRequestDTO.getPage() - 1, pageRequestDTO.getSize());
        Page<Product> result = productRepository.selectList(pageable);

        List<ProductDTO> dtoList = result.stream().map(product -> {
            ProductDTO dto = ProductDTO.builder()
                    .pno(product.getPno())
                    .pname(product.getPname())
                    .price(product.getPrice())
                    .delFlag(product.isDelFlag())
                    .build();

            if (!product.getImageList().isEmpty()) {
                dto.setUploadFileNames(List.of(product.getImageList().get(0).getFileName()));
            }

            return dto;
        }).collect(Collectors.toList());

        return PageResponseDTO.<ProductDTO>withAll()
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .totalCount(result.getTotalElements())
                .build();
    }

    @Override
    public Long register(ProductDTO productDTO) {
        return 0L;
    }

    @Override
    public ProductDTO get(Long pno) {
        Optional<Product> result = productRepository.selectOne(pno);
        Product product = result.orElseThrow();

        ProductDTO productDTO = entityToDTO(product);

        return productDTO;
    }

    @Override
    public void modify(ProductDTO productDTO) {

    }

    @Override
    public void remove(Long pno) {

    }
}
