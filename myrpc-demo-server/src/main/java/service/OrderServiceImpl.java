package service;

import pojo.Order;
import pojo.Product;

import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order submitOrder(String userId, List<Product> products) {
        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setProductCount(products.size());
        order.setUserId(userId);
        order.setTotalPrice( products.stream().mapToLong(Product::getPrice).sum());
        return order;
    }
}