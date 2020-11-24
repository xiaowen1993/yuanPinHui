package message;

import com.yph.util.CodingUtil;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.io.InputStream;

/**
 * @author Agu
 */
public class Test {

    private  ManagedChannel channel;
    private  GreeterGrpc.GreeterBlockingStub blockingStub;

    public Test() {
        channel = ManagedChannelBuilder.forAddress("106.13.188.227",8545)
                .usePlaintext()
                .build();

        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public static void main(String[] args) throws Exception {
      getMaxBlockNumber();
    }


    public  void createAddr(){
        Message.req_create_addr req_create_addr = Message.req_create_addr.newBuilder().build();
        Test test = new Test();
        Message.resp_create_addr addr = test.blockingStub.createAddr(req_create_addr);
//        blockingStub.sendToken()
        System.out.println(CodingUtil.Base64Util.decoder(addr.getAddress()) +"私钥"+CodingUtil.Base64Util.decoder(addr.getPrivkey()));

    }

    public static   void getMaxBlockNumber(){

        Test test = new Test();
        Message.req_max_block_number req_block_by_hash = Message.req_max_block_number.newBuilder().build();
        Message.resp_max_block_number maxBlockNumber = test.blockingStub.getMaxBlockNumber(req_block_by_hash);
        System.out.println("最大值"+maxBlockNumber.getMaxNumber());
        getBlockByNum(maxBlockNumber.getMaxNumber());
    }


    public static  void  getBlockByNum(long height){
        Test test = new Test();
        Message.req_block_by_number req_block_by_hash = Message.req_block_by_number.newBuilder().setHeight(height).build();
        Message.resp_block maxBlockNumber = test.blockingStub.getBlockByNum(req_block_by_hash);
        for (Message.Tx tx : maxBlockNumber.getTxsList()) {
            System.out.println("from:"+tx.getFrom()+"to"+tx.getTo()+"money"+tx.getAmount()+"script"+tx.getScript());
            for (String s : tx.getScript().split(" ")) {
                System.out.println(s);
            }
        }
    }

}
