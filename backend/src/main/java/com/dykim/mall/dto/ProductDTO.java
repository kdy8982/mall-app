package com.dykim.mall.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class ProductDTO {
    private Long pno;
    private String pname;
    private int price;
    private boolean delFlag;
    @Builder.Default
    private List<String> uploadFileNames = new ArrayList<>();
    @Builder.Default
    private List<MultipartFile> files = new ArrayList<>();
}
