package com.devil.network.tcp.aio.client;
import java.io.IOException;
import java.util.concurrent.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
public class AioConnectHandler implements CompletionHandler{
 private Integer content = 0;
 public AioConnectHandler(Integer value){
  this.content = value;
 }
 
    public void completed(Void attachment,AsynchronousSocketChannel connector) { 
        try {  
         connector.write(ByteBuffer.wrap(String.valueOf(content).getBytes())).get();
         startRead(connector); 
        } catch (ExecutionException e) { 
            e.printStackTrace(); 
        } catch (InterruptedException ep) { 
            ep.printStackTrace(); 
        } 
    } 
 
    public void failed(Throwable exc, AsynchronousSocketChannel attachment) { 
        exc.printStackTrace(); 
    } 
 
    public void startRead(AsynchronousSocketChannel socket) { 
        ByteBuffer clientBuffer = ByteBuffer.allocate(1024); 
        socket.read(clientBuffer, clientBuffer, new AioReadHandler(socket)); 
        try { 
            
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }

    /**
     * 
     * {@inheritDoc}
     * @author Administrator
     * @version 1.0.0
     */
    @Override
    public void completed(Object result, Object attachment) {
        // TODO Auto-generated method stub
        
    }

    /**
     * 
     * {@inheritDoc}
     * @author Administrator
     * @version 1.0.0
     */
    @Override
    public void failed(Throwable exc, Object attachment) {
        // TODO Auto-generated method stub
        
    }
}