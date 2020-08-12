package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author by yakai.zheng
 * @Description
 * @Date 2020/8/11 15:32
 */
@Getter
@Setter
@ToString
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderId;

    private String userId;

    private int productCount;

    private Long totalPrice;

}
