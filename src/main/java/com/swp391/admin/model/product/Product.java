package com.swp391.admin.model.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.swp391.admin.model.bird_sale.Bird_Sale;
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

    @OneToMany(mappedBy = "bird")
    @JsonManagedReference
    private List<Bird_Sale> bird_sales;
}
