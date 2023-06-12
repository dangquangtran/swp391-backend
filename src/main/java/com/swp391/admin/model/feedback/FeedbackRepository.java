package com.swp391.admin.model.feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    public List<Feedback> getFeedbacksByProduct_Id(int productId);
}
