package com.example.demo.Entity;

import com.jayway.jsonpath.internal.function.numeric.Min;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.jetbrains.annotations.NotNull;

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
    private String id;

    /** name */
    @NotNull
    private String name;

    /** price */
    @NotNull
    private BigDecimal price;

    /** stock */
    @NotNull
    private Integer stock;

    /** description */
    private String description;

    /** picture */
    private String photo;





    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;

    public Product() {

    }
}
