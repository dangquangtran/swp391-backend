package com.swp391.admin.model.sale;

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
public class Sale {
    @Id
    @SequenceGenerator(
            name = "sale_sequence",
            sequenceName = "sale_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sale_sequence"
    )

    private Integer id;
    private String name;
    private String describe;
    private int sale_percent;
    @OneToMany(mappedBy = "sale")
    @JsonManagedReference
    private List<Bird_Sale> bird_sales;
}
