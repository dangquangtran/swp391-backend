package com.swp391.admin.model.order_product;

import com.swp391.admin.model.order.Order;
import com.swp391.admin.model.order.OrderService;
import com.swp391.admin.model.product.Product;
import com.swp391.admin.model.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Order_ProductService {
    private final Order_ProductRepository order_productRepository;
    private final ProductService productService;

    private final OrderService orderService;

    @Autowired
    public Order_ProductService(Order_ProductRepository order_productRepository, ProductService productService,
                                OrderService orderService) {
        this.order_productRepository = order_productRepository;
        this.productService = productService;
        this.orderService = orderService;
    }


    public List<Order_Product> getListOrderProduct() {
        return order_productRepository.findAll();
    }

    public void createOrderProduct(Order_Product orderProduct, int productId, int orderid) {
        Product product = productService.getProductById(productId);
        Order order = orderService.getOrderById(orderid);
        orderProduct.setProduct(product);
        order.setTotalPrice(order.getTotalPrice() + orderProduct.getQuantity() * product.getPrice());
        orderProduct.setOrder(order);
        order_productRepository.save(orderProduct);
    }
}
