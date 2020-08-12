import client.BeanFactory;
import client.NettyClient;
import pojo.Order;
import pojo.Product;
import service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        NettyClient nettyClient = new NettyClient();
        nettyClient.start("127.0.0.1", 5566);
        BeanFactory beanFactory = new BeanFactory(nettyClient);
        OrderService orderService = beanFactory.getBean(OrderService.class);
        List<Product> itemList = new ArrayList<>();
        Product item = new Product();
        item.setProductId("p001");
        item.setTitle("钢笔");
        item.setPrice(100L);
        itemList.add(item);


        item = new Product();
        item.setProductId("p002");
        item.setTitle("文具盒");
        item.setPrice(50L);
        itemList.add(item);
//        for (int i = 0; i < 10; i++) {
            Order order = orderService.submitOrder("user123", itemList);
            System.out.println("返回数据：" + order);
//        }
        nettyClient.close();
    }
}