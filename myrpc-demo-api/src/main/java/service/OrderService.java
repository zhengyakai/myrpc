package service;

import pojo.Order;
import pojo.Product;

import java.util.List;

/**
 * @author by yakai.zheng
 * @Description
 * @Date 2020/8/11 15:22
 */
public interface OrderService {
    Order submitOrder(String userId, List<Product> products);
}
