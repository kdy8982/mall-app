package com.dykim.mall.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ProductImage {
    private String fileName;

    @Setter
    private int ord;
}
