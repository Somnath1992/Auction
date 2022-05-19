package com.fse.product.query.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fse.product.common.dto.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="TBL_ProductMaster")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private String shortDescription;
    private String description;
    private String category;
    private BigDecimal startingPrice;
    private Timestamp bidEndDate;
}