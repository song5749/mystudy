package com.tmall.tmcs.netty;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/12/11.
 *  Netty 服务端代码
 */
public class HelloServer {
    public static void main(String[] args) {
        //SERVER 启动
        ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(

                Executors.newCachedThreadPool(),

                Executors.newCachedThreadPool()));
        // 设置一个处理客户端消息和各种消息事件的类(Handler)
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new HelloServerHandler());
            }
        });
        bootstrap.bind(new InetSocketAddress(8000));

    }

    /**
     * 当有客户端绑定到服务端时触发，打印hello word
     */
    private static class HelloServerHandler extends SimpleChannelHandler{
        @Override
        public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
            System.out.printf("hello word.I am server");
        }
    }

}
