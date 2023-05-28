package com.swp391.admin.model.bird_sale;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Bird_Sale {
    @Id
    @SequenceGenerator(
            name = "bird_sale_sequence",
            sequenceName = "bird_sale_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bird_sale_sequence"
    )
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "bird_id")
    @JsonBackReference
    private Product bird;
    @ManyToOne
    @JoinColumn(name = "sale_id")
    @JsonBackReference
    private Sale sale;
}
