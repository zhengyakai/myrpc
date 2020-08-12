package server;

import base.RpcRequest;
import codec.MyDecoder;
import codec.MyEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new MyDecoder(RpcRequest.class)) //解码器，需要解码的对象 是RpcRequest
                .addLast(new MyEncoder()) //编码器，⽤于数据的响应
                .addLast(new ServerHandler()); //⾃定义逻辑
    }
}