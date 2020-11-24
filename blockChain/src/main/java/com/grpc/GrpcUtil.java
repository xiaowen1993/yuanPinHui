package com.grpc;

import com.yph.entity.ScriptEntity;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Agu
 */
@Component
public class GrpcUtil {

    private ManagedChannel channel;
    private  GreeterGrpc.GreeterBlockingStub blockingStub;
    
    @Autowired
    GrpcUtil grpcUtil;
    
    public GrpcUtil() {
        channel = ManagedChannelBuilder.forAddress(GrpcParameter.ipAddress,GrpcParameter.port)
                .usePlaintext()
                .build();
//        try {
//            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }


    //给用户创建地址
    public   Message.resp_create_addr createAddr(){
        Message.req_create_addr req_create_addr = Message.req_create_addr.newBuilder().build();

        isShutDown();
        Message.resp_create_addr addr = grpcUtil.blockingStub.createAddr(req_create_addr);
//        blockingStub.sendToken()
//        System.out.println(CodingUtil.Base64Util.decoder(addr.getAddress()) +"私钥"+CodingUtil.Base64Util.decoder(addr.getPrivkey()));
        return addr;
    }

    //获取当前最大区块号
    public    long getMaxBlockNumber(){

       
        Message.req_max_block_number req_block_by_hash = Message.req_max_block_number.newBuilder().build();
        isShutDown();
        Message.resp_max_block_number maxBlockNumber = grpcUtil.blockingStub.getMaxBlockNumber(req_block_by_hash);
        System.out.println("最大值"+maxBlockNumber.getMaxNumber());
        return  maxBlockNumber.getMaxNumber();
    }


    public void  isShutDown(){
        if (channel.isShutdown()) {
            System.out.println("down！！！！！");
            channel = ManagedChannelBuilder.forAddress(GrpcParameter.ipAddress,GrpcParameter.port)
                    .usePlaintext()
                    .build();
        }
    }

    //获取区块号相关信息
    public    Message.resp_block  getBlockByNum(long height){
        Message.req_block_by_number req_block_by_hash = Message.req_block_by_number.newBuilder().setHeight(height).build();
        isShutDown();
        Message.resp_block maxBlockNumber = grpcUtil.blockingStub.getBlockByNum(req_block_by_hash);
       return maxBlockNumber;
    }





    public ManagedChannel getChannel() {
        return channel;
    }

    public void setChannel(ManagedChannel channel) {
        this.channel = channel;
    }

    public GreeterGrpc.GreeterBlockingStub getBlockingStub() {
        return blockingStub;
    }

    public void setBlockingStub(GreeterGrpc.GreeterBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }
}
