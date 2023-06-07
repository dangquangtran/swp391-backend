package com.swp391.admin.model.product_sale;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swp391.admin.model.product.Product;
import com.swp391.admin.model.sale.Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product_Sale {
    @Id
    @SequenceGenerator(
            name = "product_sale_sequence",
            sequenceName = "product_sale_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sale_sequence"
    )
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    @JsonIgnore
    private Product product;
    @ManyToOne
    @JoinColumn(name = "sale_id")
    @JsonBackReference
    @JsonIgnore
    private Sale sale;
}
