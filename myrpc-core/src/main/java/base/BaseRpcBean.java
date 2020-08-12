package base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public abstract class BaseRpcBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String requestId; //请求id

}