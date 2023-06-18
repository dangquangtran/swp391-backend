package com.swp391.admin.model.order_product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swp391.admin.model.order.Order;
import com.swp391.admin.model.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Order_Product {
    @Id
    @SequenceGenerator(
            name = "order_product_sequence",
            sequenceName = "order_product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_product_sequence"
    )
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    @JsonIgnore
    private Order order;


    private Integer quantity;

}
