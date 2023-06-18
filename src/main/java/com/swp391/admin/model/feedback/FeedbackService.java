package com.swp391.admin.model.feedback;

import com.swp391.admin.model.product.Product;
import com.swp391.admin.model.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final ProductService productService;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository, ProductService productService) {
        this.feedbackRepository = feedbackRepository;
        this.productService = productService;
    }

    public List<Feedback> getListFeedback() {
        return feedbackRepository.findAll();
    }

    public void createFeedback(Feedback feedback, int productId) {
        feedback.setProduct(productService.getProductById(productId));
        feedbackRepository.save(feedback);
    }

    public List<Feedback> getFeedbackByProductId(int productId) {
        Product product = productService.getProductById(productId);
        return feedbackRepository.getFeedbacksByProduct(product);
    }


}
