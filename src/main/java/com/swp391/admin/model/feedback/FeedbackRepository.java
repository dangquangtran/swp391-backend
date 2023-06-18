package com.swp391.admin.model.feedback;

import com.swp391.admin.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    List<Feedback> getFeedbacksByProduct(Product product);
}
