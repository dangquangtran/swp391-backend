package com.swp391.admin.model.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.swp391.admin.model.order_product.Order_Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Integer id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate orderDate;
    private String deliveryMethod;
    private Integer totalPrice;
    private String status;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Order_Product> order_products;
}
