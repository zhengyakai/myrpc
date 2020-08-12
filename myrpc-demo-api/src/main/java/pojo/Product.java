package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author by yakai.zheng
 * @Description 商品
 * @Date 2020/8/11 15:22
 */
@Getter
@Setter
@ToString
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    // 商品id
    private String productId;

    private String title;

    // 商品价格
    private Long price;
}
