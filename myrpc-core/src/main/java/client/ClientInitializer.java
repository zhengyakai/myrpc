package client;

import base.RpcResponse;
import codec.MyDecoder;
import codec.MyEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new MyDecoder(RpcResponse.class))
                .addLast(new MyEncoder())
                .addLast(new ClientHandler());
    }
}