package server;

import base.RpcRequest;
import base.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import util.ClassUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author by yakai.zheng
 * @Description
 * @Date 2020/8/11 14:29
 */
@Slf4j
public class ServerHandler extends SimpleChannelInboundHandler<RpcRequest> {

    private static final Map<Class<?>, Object> OBJECT_MAP = new ConcurrentHashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequest request) throws Exception {
        RpcResponse rpcResponse = new RpcResponse();
        rpcResponse.setRequestId(request.getRequestId());
        log.info("开始处理消息：requestId = " + request.getRequestId());
        try {
            Class<?> clazz = Class.forName(request.getClassName());
            if(!OBJECT_MAP.containsKey(clazz)){
                //获取接⼝的实现类，这⾥为了演示demo,只获取第⼀个实现类，忽略其他实现类
                List<Class> allClassByInterface = ClassUtil.getAllClassByInterface(clazz);
                for (Class<?> c : allClassByInterface) {
                //将对象缓存起来，提升效率
                    OBJECT_MAP.put(clazz, c.newInstance());
                    break;
                }
            }
            //通过反射找到⽅法执⾏
            Method method = clazz.getMethod(request.getMethodName(), request.getParameterTypes());
            method.setAccessible(true);
            Object result = method.invoke(OBJECT_MAP.get(clazz), request.getParameters());
            rpcResponse.setResult(result);
        } catch (Exception e) {
            log.error("处理失败... requestId = " + request.getRequestId(), e);
            //出错
            rpcResponse.setErrorMsg("error");
        }
        ctx.writeAndFlush(rpcResponse);

    }
}
