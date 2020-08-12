package base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RpcRequest extends BaseRpcBean {
    private static final long serialVersionUID = 1L;
    private long createMillisTime; //创建请求时间
    private String className; //类名称，全包路径
    private String methodName; //执⾏⽅法名
    private Class<?>[] parameterTypes; //⽅法中的参数类型
    private Object[] parameters; //执⾏⽅法传⼊的参数
}