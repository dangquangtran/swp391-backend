package com.swp391.admin.model.sale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.swp391.admin.model.product_sale.Product_Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
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
    private Integer sale_percent;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expiredDate;
    @OneToMany(mappedBy = "sale")
    @JsonManagedReference
    @JsonIgnore
    private List<Product_Sale> product_sales;
}
