package com.example.demo.Entity;

import com.jayway.jsonpath.internal.function.numeric.Min;
import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "products")
public class Product implements Serializable {
    @Id
    private String productId;

    /** name */
    @NotNull
    private String name;


    @ColumnDefault("0")
    private Integer productStatus;
    /** price */
    @NotNull
    private BigDecimal price;

    /** stock */
    @NotNull
    private Integer stock;

    /** description */
    private String description;

    /** picture */
    @Type(type="text")
    private String photo;





    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;

    public Product() {

    }
}
