package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Cart {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
//    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true,
            mappedBy = "cart")
    private Set<ProductInOrder> products = new HashSet<>();


    /*
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true,
            mappedBy = "cart")
    private Set<Product> products = new HashSet<>();



    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", products=" + products +
                '}';
    }

     */

    public Cart(User user) {
        this.user  = user;
    }
}
