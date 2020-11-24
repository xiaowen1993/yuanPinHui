package com.grpc;

/**
 * @author Agu
 */
public class GrpcParameter {



    //目标服务器Ip地址
    public static final  String ipAddress = "106.13.188.227";

    //目标服务器端口号
    public  static  final  int port = 8545;

    //当前版本号与最新版本号的缓冲值(只有当最新版本号大于当前版本号的这个值的时候才会处理，相当于5s延迟 ...)
    public  static  final long buffer = 5;

    public  static  final  long defaultTime = 500;

}
