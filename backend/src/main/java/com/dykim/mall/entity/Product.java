package com.dykim.mall.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_product")
@Log4j2
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    @Setter
    private String pname;

    @Setter
    private int price;

    @Setter
    private boolean delFlag;

    @ElementCollection
    @Builder.Default
    private List<ProductImage> imageList = new ArrayList<>();

    public void clearList() {
        this.imageList.clear();
    }

}
