package base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RpcResponse extends BaseRpcBean{
    private static final long serialVersionUID = 1L;
    private String errorMsg; //错误消息
    private Object result; //结果数据
}