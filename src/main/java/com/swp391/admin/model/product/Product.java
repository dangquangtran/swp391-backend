package com.swp391.admin.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.swp391.admin.model.feedback.Feedback;
import com.swp391.admin.model.product_sale.Product_Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )

    private Integer id;
    private String name;
    private String describe;
    private Integer price;
    private Integer quantity;
    private String type;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Product_Sale> product_sales;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Feedback> product_feedback;
}
