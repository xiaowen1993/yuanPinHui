package com.grpc;

import message.Message;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.0)",
    comments = "Source: message.proto")
public final class GreeterGrpc {

  private GreeterGrpc() {}

  public static final String SERVICE_NAME = "message.Greeter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Message.req_block_by_number,
      Message.resp_block> getGetBlockByNumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlockByNum",
      requestType = Message.req_block_by_number.class,
      responseType = Message.resp_block.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_block_by_number,
      Message.resp_block> getGetBlockByNumMethod() {
    io.grpc.MethodDescriptor<Message.req_block_by_number, Message.resp_block> getGetBlockByNumMethod;
    if ((getGetBlockByNumMethod = GreeterGrpc.getGetBlockByNumMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGetBlockByNumMethod = GreeterGrpc.getGetBlockByNumMethod) == null) {
          GreeterGrpc.getGetBlockByNumMethod = getGetBlockByNumMethod =
              io.grpc.MethodDescriptor.<Message.req_block_by_number, Message.resp_block>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBlockByNum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_block_by_number.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.resp_block.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GetBlockByNum"))
              .build();
        }
      }
    }
    return getGetBlockByNumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Message.req_block_by_hash,
      Message.resp_block> getGetBlockByHashMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlockByHash",
      requestType = Message.req_block_by_hash.class,
      responseType = Message.resp_block.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_block_by_hash,
      Message.resp_block> getGetBlockByHashMethod() {
    io.grpc.MethodDescriptor<Message.req_block_by_hash, Message.resp_block> getGetBlockByHashMethod;
    if ((getGetBlockByHashMethod = GreeterGrpc.getGetBlockByHashMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGetBlockByHashMethod = GreeterGrpc.getGetBlockByHashMethod) == null) {
          GreeterGrpc.getGetBlockByHashMethod = getGetBlockByHashMethod =
              io.grpc.MethodDescriptor.<Message.req_block_by_hash, Message.resp_block>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBlockByHash"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_block_by_hash.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.resp_block.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GetBlockByHash"))
              .build();
        }
      }
    }
    return getGetBlockByHashMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Message.req_balance,
      Message.res_balance> getGetBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBalance",
      requestType = Message.req_balance.class,
      responseType = Message.res_balance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_balance,
      Message.res_balance> getGetBalanceMethod() {
    io.grpc.MethodDescriptor<Message.req_balance, Message.res_balance> getGetBalanceMethod;
    if ((getGetBalanceMethod = GreeterGrpc.getGetBalanceMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGetBalanceMethod = GreeterGrpc.getGetBalanceMethod) == null) {
          GreeterGrpc.getGetBalanceMethod = getGetBalanceMethod =
              io.grpc.MethodDescriptor.<Message.req_balance, Message.res_balance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_balance.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.res_balance.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GetBalance"))
              .build();
        }
      }
    }
    return getGetBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Message.req_tx,
      Message.respose_txs> getGetTxsByAddrMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTxsByAddr",
      requestType = Message.req_tx.class,
      responseType = Message.respose_txs.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_tx,
      Message.respose_txs> getGetTxsByAddrMethod() {
    io.grpc.MethodDescriptor<Message.req_tx, Message.respose_txs> getGetTxsByAddrMethod;
    if ((getGetTxsByAddrMethod = GreeterGrpc.getGetTxsByAddrMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGetTxsByAddrMethod = GreeterGrpc.getGetTxsByAddrMethod) == null) {
          GreeterGrpc.getGetTxsByAddrMethod = getGetTxsByAddrMethod =
              io.grpc.MethodDescriptor.<Message.req_tx, Message.respose_txs>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTxsByAddr"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_tx.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.respose_txs.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GetTxsByAddr"))
              .build();
        }
      }
    }
    return getGetTxsByAddrMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Message.req_tx_by_hash,
      Message.Tx> getGetTxByHashMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTxByHash",
      requestType = Message.req_tx_by_hash.class,
      responseType = Message.Tx.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_tx_by_hash,
      Message.Tx> getGetTxByHashMethod() {
    io.grpc.MethodDescriptor<Message.req_tx_by_hash, Message.Tx> getGetTxByHashMethod;
    if ((getGetTxByHashMethod = GreeterGrpc.getGetTxByHashMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGetTxByHashMethod = GreeterGrpc.getGetTxByHashMethod) == null) {
          GreeterGrpc.getGetTxByHashMethod = getGetTxByHashMethod =
              io.grpc.MethodDescriptor.<Message.req_tx_by_hash, Message.Tx>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTxByHash"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_tx_by_hash.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.Tx.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GetTxByHash"))
              .build();
        }
      }
    }
    return getGetTxByHashMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Message.req_transaction,
      Message.res_transaction> getSendTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendTransaction",
      requestType = Message.req_transaction.class,
      responseType = Message.res_transaction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_transaction,
      Message.res_transaction> getSendTransactionMethod() {
    io.grpc.MethodDescriptor<Message.req_transaction, Message.res_transaction> getSendTransactionMethod;
    if ((getSendTransactionMethod = GreeterGrpc.getSendTransactionMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSendTransactionMethod = GreeterGrpc.getSendTransactionMethod) == null) {
          GreeterGrpc.getSendTransactionMethod = getSendTransactionMethod =
              io.grpc.MethodDescriptor.<Message.req_transaction, Message.res_transaction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_transaction.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.res_transaction.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SendTransaction"))
              .build();
        }
      }
    }
    return getSendTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Message.req_nonce,
      Message.respose_nonce> getGetAddressNonceAtMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAddressNonceAt",
      requestType = Message.req_nonce.class,
      responseType = Message.respose_nonce.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_nonce,
      Message.respose_nonce> getGetAddressNonceAtMethod() {
    io.grpc.MethodDescriptor<Message.req_nonce, Message.respose_nonce> getGetAddressNonceAtMethod;
    if ((getGetAddressNonceAtMethod = GreeterGrpc.getGetAddressNonceAtMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGetAddressNonceAtMethod = GreeterGrpc.getGetAddressNonceAtMethod) == null) {
          GreeterGrpc.getGetAddressNonceAtMethod = getGetAddressNonceAtMethod =
              io.grpc.MethodDescriptor.<Message.req_nonce, Message.respose_nonce>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAddressNonceAt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_nonce.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.respose_nonce.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GetAddressNonceAt"))
              .build();
        }
      }
    }
    return getGetAddressNonceAtMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Message.req_create_addr,
      Message.resp_create_addr> getCreateAddrMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAddr",
      requestType = Message.req_create_addr.class,
      responseType = Message.resp_create_addr.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_create_addr,
      Message.resp_create_addr> getCreateAddrMethod() {
    io.grpc.MethodDescriptor<Message.req_create_addr, Message.resp_create_addr> getCreateAddrMethod;
    if ((getCreateAddrMethod = GreeterGrpc.getCreateAddrMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getCreateAddrMethod = GreeterGrpc.getCreateAddrMethod) == null) {
          GreeterGrpc.getCreateAddrMethod = getCreateAddrMethod =
              io.grpc.MethodDescriptor.<Message.req_create_addr, Message.resp_create_addr>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAddr"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_create_addr.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.resp_create_addr.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("CreateAddr"))
              .build();
        }
      }
    }
    return getCreateAddrMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Message.req_max_block_number,
      Message.resp_max_block_number> getGetMaxBlockNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMaxBlockNumber",
      requestType = Message.req_max_block_number.class,
      responseType = Message.resp_max_block_number.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_max_block_number,
      Message.resp_max_block_number> getGetMaxBlockNumberMethod() {
    io.grpc.MethodDescriptor<Message.req_max_block_number, Message.resp_max_block_number> getGetMaxBlockNumberMethod;
    if ((getGetMaxBlockNumberMethod = GreeterGrpc.getGetMaxBlockNumberMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGetMaxBlockNumberMethod = GreeterGrpc.getGetMaxBlockNumberMethod) == null) {
          GreeterGrpc.getGetMaxBlockNumberMethod = getGetMaxBlockNumberMethod =
              io.grpc.MethodDescriptor.<Message.req_max_block_number, Message.resp_max_block_number>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMaxBlockNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_max_block_number.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.resp_max_block_number.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GetMaxBlockNumber"))
              .build();
        }
      }
    }
    return getGetMaxBlockNumberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Message.req_addr_by_priv,
      Message.resp_addr_by_priv> getGetAddrByPrivMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAddrByPriv",
      requestType = Message.req_addr_by_priv.class,
      responseType = Message.resp_addr_by_priv.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_addr_by_priv,
      Message.resp_addr_by_priv> getGetAddrByPrivMethod() {
    io.grpc.MethodDescriptor<Message.req_addr_by_priv, Message.resp_addr_by_priv> getGetAddrByPrivMethod;
    if ((getGetAddrByPrivMethod = GreeterGrpc.getGetAddrByPrivMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGetAddrByPrivMethod = GreeterGrpc.getGetAddrByPrivMethod) == null) {
          GreeterGrpc.getGetAddrByPrivMethod = getGetAddrByPrivMethod =
              io.grpc.MethodDescriptor.<Message.req_addr_by_priv, Message.resp_addr_by_priv>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAddrByPriv"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_addr_by_priv.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.resp_addr_by_priv.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GetAddrByPriv"))
              .build();
        }
      }
    }
    return getGetAddrByPrivMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Message.req_token_transaction,
      Message.resp_token_transaction> getSendTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendToken",
      requestType = Message.req_token_transaction.class,
      responseType = Message.resp_token_transaction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_token_transaction,
      Message.resp_token_transaction> getSendTokenMethod() {
    io.grpc.MethodDescriptor<Message.req_token_transaction, Message.resp_token_transaction> getSendTokenMethod;
    if ((getSendTokenMethod = GreeterGrpc.getSendTokenMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSendTokenMethod = GreeterGrpc.getSendTokenMethod) == null) {
          GreeterGrpc.getSendTokenMethod = getSendTokenMethod =
              io.grpc.MethodDescriptor.<Message.req_token_transaction, Message.resp_token_transaction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_token_transaction.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.resp_token_transaction.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SendToken"))
              .build();
        }
      }
    }
    return getSendTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Message.req_token_balance,
      Message.resp_token_balance> getGetBalanceTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBalanceToken",
      requestType = Message.req_token_balance.class,
      responseType = Message.resp_token_balance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Message.req_token_balance,
      Message.resp_token_balance> getGetBalanceTokenMethod() {
    io.grpc.MethodDescriptor<Message.req_token_balance, Message.resp_token_balance> getGetBalanceTokenMethod;
    if ((getGetBalanceTokenMethod = GreeterGrpc.getGetBalanceTokenMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGetBalanceTokenMethod = GreeterGrpc.getGetBalanceTokenMethod) == null) {
          GreeterGrpc.getGetBalanceTokenMethod = getGetBalanceTokenMethod =
              io.grpc.MethodDescriptor.<Message.req_token_balance, Message.resp_token_balance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBalanceToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.req_token_balance.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Message.resp_token_balance.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GetBalanceToken"))
              .build();
        }
      }
    }
    return getGetBalanceTokenMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreeterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterStub>() {
        @Override
        public GreeterStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterStub(channel, callOptions);
        }
      };
    return GreeterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterBlockingStub>() {
        @Override
        public GreeterBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterBlockingStub(channel, callOptions);
        }
      };
    return GreeterBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterFutureStub>() {
        @Override
        public GreeterFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterFutureStub(channel, callOptions);
        }
      };
    return GreeterFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GreeterImplBase implements io.grpc.BindableService {

    /**
     */
    public void getBlockByNum(Message.req_block_by_number request,
                              io.grpc.stub.StreamObserver<Message.resp_block> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBlockByNumMethod(), responseObserver);
    }

    /**
     */
    public void getBlockByHash(Message.req_block_by_hash request,
                               io.grpc.stub.StreamObserver<Message.resp_block> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBlockByHashMethod(), responseObserver);
    }

    /**
     */
    public void getBalance(Message.req_balance request,
                           io.grpc.stub.StreamObserver<Message.res_balance> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBalanceMethod(), responseObserver);
    }

    /**
     */
    public void getTxsByAddr(Message.req_tx request,
                             io.grpc.stub.StreamObserver<Message.respose_txs> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTxsByAddrMethod(), responseObserver);
    }

    /**
     */
    public void getTxByHash(Message.req_tx_by_hash request,
                            io.grpc.stub.StreamObserver<Message.Tx> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTxByHashMethod(), responseObserver);
    }

    /**
     */
    public void sendTransaction(Message.req_transaction request,
                                io.grpc.stub.StreamObserver<Message.res_transaction> responseObserver) {
      asyncUnimplementedUnaryCall(getSendTransactionMethod(), responseObserver);
    }

    /**
     */
    public void getAddressNonceAt(Message.req_nonce request,
                                  io.grpc.stub.StreamObserver<Message.respose_nonce> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAddressNonceAtMethod(), responseObserver);
    }

    /**
     */
    public void createAddr(Message.req_create_addr request,
                           io.grpc.stub.StreamObserver<Message.resp_create_addr> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateAddrMethod(), responseObserver);
    }

    /**
     */
    public void getMaxBlockNumber(Message.req_max_block_number request,
                                  io.grpc.stub.StreamObserver<Message.resp_max_block_number> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMaxBlockNumberMethod(), responseObserver);
    }

    /**
     */
    public void getAddrByPriv(Message.req_addr_by_priv request,
                              io.grpc.stub.StreamObserver<Message.resp_addr_by_priv> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAddrByPrivMethod(), responseObserver);
    }

    /**
     */
    public void sendToken(Message.req_token_transaction request,
                          io.grpc.stub.StreamObserver<Message.resp_token_transaction> responseObserver) {
      asyncUnimplementedUnaryCall(getSendTokenMethod(), responseObserver);
    }

    /**
     */
    public void getBalanceToken(Message.req_token_balance request,
                                io.grpc.stub.StreamObserver<Message.resp_token_balance> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBalanceTokenMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetBlockByNumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_block_by_number,
                Message.resp_block>(
                  this, METHODID_GET_BLOCK_BY_NUM)))
          .addMethod(
            getGetBlockByHashMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_block_by_hash,
                Message.resp_block>(
                  this, METHODID_GET_BLOCK_BY_HASH)))
          .addMethod(
            getGetBalanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_balance,
                Message.res_balance>(
                  this, METHODID_GET_BALANCE)))
          .addMethod(
            getGetTxsByAddrMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_tx,
                Message.respose_txs>(
                  this, METHODID_GET_TXS_BY_ADDR)))
          .addMethod(
            getGetTxByHashMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_tx_by_hash,
                Message.Tx>(
                  this, METHODID_GET_TX_BY_HASH)))
          .addMethod(
            getSendTransactionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_transaction,
                Message.res_transaction>(
                  this, METHODID_SEND_TRANSACTION)))
          .addMethod(
            getGetAddressNonceAtMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_nonce,
                Message.respose_nonce>(
                  this, METHODID_GET_ADDRESS_NONCE_AT)))
          .addMethod(
            getCreateAddrMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_create_addr,
                Message.resp_create_addr>(
                  this, METHODID_CREATE_ADDR)))
          .addMethod(
            getGetMaxBlockNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_max_block_number,
                Message.resp_max_block_number>(
                  this, METHODID_GET_MAX_BLOCK_NUMBER)))
          .addMethod(
            getGetAddrByPrivMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_addr_by_priv,
                Message.resp_addr_by_priv>(
                  this, METHODID_GET_ADDR_BY_PRIV)))
          .addMethod(
            getSendTokenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_token_transaction,
                Message.resp_token_transaction>(
                  this, METHODID_SEND_TOKEN)))
          .addMethod(
            getGetBalanceTokenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Message.req_token_balance,
                Message.resp_token_balance>(
                  this, METHODID_GET_BALANCE_TOKEN)))
          .build();
    }
  }

  /**
   */
  public static final class GreeterStub extends io.grpc.stub.AbstractAsyncStub<GreeterStub> {
    private GreeterStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GreeterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterStub(channel, callOptions);
    }

    /**
     */
    public void getBlockByNum(Message.req_block_by_number request,
                              io.grpc.stub.StreamObserver<Message.resp_block> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBlockByNumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBlockByHash(Message.req_block_by_hash request,
                               io.grpc.stub.StreamObserver<Message.resp_block> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBlockByHashMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBalance(Message.req_balance request,
                           io.grpc.stub.StreamObserver<Message.res_balance> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTxsByAddr(Message.req_tx request,
                             io.grpc.stub.StreamObserver<Message.respose_txs> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTxsByAddrMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTxByHash(Message.req_tx_by_hash request,
                            io.grpc.stub.StreamObserver<Message.Tx> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTxByHashMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendTransaction(Message.req_transaction request,
                                io.grpc.stub.StreamObserver<Message.res_transaction> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAddressNonceAt(Message.req_nonce request,
                                  io.grpc.stub.StreamObserver<Message.respose_nonce> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAddressNonceAtMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createAddr(Message.req_create_addr request,
                           io.grpc.stub.StreamObserver<Message.resp_create_addr> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateAddrMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMaxBlockNumber(Message.req_max_block_number request,
                                  io.grpc.stub.StreamObserver<Message.resp_max_block_number> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMaxBlockNumberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAddrByPriv(Message.req_addr_by_priv request,
                              io.grpc.stub.StreamObserver<Message.resp_addr_by_priv> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAddrByPrivMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendToken(Message.req_token_transaction request,
                          io.grpc.stub.StreamObserver<Message.resp_token_transaction> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBalanceToken(Message.req_token_balance request,
                                io.grpc.stub.StreamObserver<Message.resp_token_balance> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBalanceTokenMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GreeterBlockingStub extends io.grpc.stub.AbstractBlockingStub<GreeterBlockingStub> {
    private GreeterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GreeterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterBlockingStub(channel, callOptions);
    }

    /**
     */
    public Message.resp_block getBlockByNum(Message.req_block_by_number request) {
      return blockingUnaryCall(
          getChannel(), getGetBlockByNumMethod(), getCallOptions(), request);
    }

    /**
     */
    public Message.resp_block getBlockByHash(Message.req_block_by_hash request) {
      return blockingUnaryCall(
          getChannel(), getGetBlockByHashMethod(), getCallOptions(), request);
    }

    /**
     */
    public Message.res_balance getBalance(Message.req_balance request) {
      return blockingUnaryCall(
          getChannel(), getGetBalanceMethod(), getCallOptions(), request);
    }

    /**
     */
    public Message.respose_txs getTxsByAddr(Message.req_tx request) {
      return blockingUnaryCall(
          getChannel(), getGetTxsByAddrMethod(), getCallOptions(), request);
    }

    /**
     */
    public Message.Tx getTxByHash(Message.req_tx_by_hash request) {
      return blockingUnaryCall(
          getChannel(), getGetTxByHashMethod(), getCallOptions(), request);
    }

    /**
     */
    public Message.res_transaction sendTransaction(Message.req_transaction request) {
      return blockingUnaryCall(
          getChannel(), getSendTransactionMethod(), getCallOptions(), request);
    }

    /**
     */
    public Message.respose_nonce getAddressNonceAt(Message.req_nonce request) {
      return blockingUnaryCall(
          getChannel(), getGetAddressNonceAtMethod(), getCallOptions(), request);
    }

    /**
     */
    public Message.resp_create_addr createAddr(Message.req_create_addr request) {
      return blockingUnaryCall(
          getChannel(), getCreateAddrMethod(), getCallOptions(), request);
    }

    /**
     */
    public Message.resp_max_block_number getMaxBlockNumber(Message.req_max_block_number request) {
      return blockingUnaryCall(
          getChannel(), getGetMaxBlockNumberMethod(), getCallOptions(), request);
    }

    /**
     */
    public Message.resp_addr_by_priv getAddrByPriv(Message.req_addr_by_priv request) {
      return blockingUnaryCall(
          getChannel(), getGetAddrByPrivMethod(), getCallOptions(), request);
    }

    /**
     */
    public Message.resp_token_transaction sendToken(Message.req_token_transaction request) {
      return blockingUnaryCall(
          getChannel(), getSendTokenMethod(), getCallOptions(), request);
    }

    /**
     */
    public Message.resp_token_balance getBalanceToken(Message.req_token_balance request) {
      return blockingUnaryCall(
          getChannel(), getGetBalanceTokenMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GreeterFutureStub extends io.grpc.stub.AbstractFutureStub<GreeterFutureStub> {
    private GreeterFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected GreeterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.resp_block> getBlockByNum(
        Message.req_block_by_number request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBlockByNumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.resp_block> getBlockByHash(
        Message.req_block_by_hash request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBlockByHashMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.res_balance> getBalance(
        Message.req_balance request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBalanceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.respose_txs> getTxsByAddr(
        Message.req_tx request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTxsByAddrMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.Tx> getTxByHash(
        Message.req_tx_by_hash request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTxByHashMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.res_transaction> sendTransaction(
        Message.req_transaction request) {
      return futureUnaryCall(
          getChannel().newCall(getSendTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.respose_nonce> getAddressNonceAt(
        Message.req_nonce request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAddressNonceAtMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.resp_create_addr> createAddr(
        Message.req_create_addr request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateAddrMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.resp_max_block_number> getMaxBlockNumber(
        Message.req_max_block_number request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMaxBlockNumberMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.resp_addr_by_priv> getAddrByPriv(
        Message.req_addr_by_priv request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAddrByPrivMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.resp_token_transaction> sendToken(
        Message.req_token_transaction request) {
      return futureUnaryCall(
          getChannel().newCall(getSendTokenMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Message.resp_token_balance> getBalanceToken(
        Message.req_token_balance request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBalanceTokenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BLOCK_BY_NUM = 0;
  private static final int METHODID_GET_BLOCK_BY_HASH = 1;
  private static final int METHODID_GET_BALANCE = 2;
  private static final int METHODID_GET_TXS_BY_ADDR = 3;
  private static final int METHODID_GET_TX_BY_HASH = 4;
  private static final int METHODID_SEND_TRANSACTION = 5;
  private static final int METHODID_GET_ADDRESS_NONCE_AT = 6;
  private static final int METHODID_CREATE_ADDR = 7;
  private static final int METHODID_GET_MAX_BLOCK_NUMBER = 8;
  private static final int METHODID_GET_ADDR_BY_PRIV = 9;
  private static final int METHODID_SEND_TOKEN = 10;
  private static final int METHODID_GET_BALANCE_TOKEN = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreeterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreeterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BLOCK_BY_NUM:
          serviceImpl.getBlockByNum((Message.req_block_by_number) request,
              (io.grpc.stub.StreamObserver<Message.resp_block>) responseObserver);
          break;
        case METHODID_GET_BLOCK_BY_HASH:
          serviceImpl.getBlockByHash((Message.req_block_by_hash) request,
              (io.grpc.stub.StreamObserver<Message.resp_block>) responseObserver);
          break;
        case METHODID_GET_BALANCE:
          serviceImpl.getBalance((Message.req_balance) request,
              (io.grpc.stub.StreamObserver<Message.res_balance>) responseObserver);
          break;
        case METHODID_GET_TXS_BY_ADDR:
          serviceImpl.getTxsByAddr((Message.req_tx) request,
              (io.grpc.stub.StreamObserver<Message.respose_txs>) responseObserver);
          break;
        case METHODID_GET_TX_BY_HASH:
          serviceImpl.getTxByHash((Message.req_tx_by_hash) request,
              (io.grpc.stub.StreamObserver<Message.Tx>) responseObserver);
          break;
        case METHODID_SEND_TRANSACTION:
          serviceImpl.sendTransaction((Message.req_transaction) request,
              (io.grpc.stub.StreamObserver<Message.res_transaction>) responseObserver);
          break;
        case METHODID_GET_ADDRESS_NONCE_AT:
          serviceImpl.getAddressNonceAt((Message.req_nonce) request,
              (io.grpc.stub.StreamObserver<Message.respose_nonce>) responseObserver);
          break;
        case METHODID_CREATE_ADDR:
          serviceImpl.createAddr((Message.req_create_addr) request,
              (io.grpc.stub.StreamObserver<Message.resp_create_addr>) responseObserver);
          break;
        case METHODID_GET_MAX_BLOCK_NUMBER:
          serviceImpl.getMaxBlockNumber((Message.req_max_block_number) request,
              (io.grpc.stub.StreamObserver<Message.resp_max_block_number>) responseObserver);
          break;
        case METHODID_GET_ADDR_BY_PRIV:
          serviceImpl.getAddrByPriv((Message.req_addr_by_priv) request,
              (io.grpc.stub.StreamObserver<Message.resp_addr_by_priv>) responseObserver);
          break;
        case METHODID_SEND_TOKEN:
          serviceImpl.sendToken((Message.req_token_transaction) request,
              (io.grpc.stub.StreamObserver<Message.resp_token_transaction>) responseObserver);
          break;
        case METHODID_GET_BALANCE_TOKEN:
          serviceImpl.getBalanceToken((Message.req_token_balance) request,
              (io.grpc.stub.StreamObserver<Message.resp_token_balance>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreeterBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Message.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter");
    }
  }

  private static final class GreeterFileDescriptorSupplier
      extends GreeterBaseDescriptorSupplier {
    GreeterFileDescriptorSupplier() {}
  }

  private static final class GreeterMethodDescriptorSupplier
      extends GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreeterMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GreeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreeterFileDescriptorSupplier())
              .addMethod(getGetBlockByNumMethod())
              .addMethod(getGetBlockByHashMethod())
              .addMethod(getGetBalanceMethod())
              .addMethod(getGetTxsByAddrMethod())
              .addMethod(getGetTxByHashMethod())
              .addMethod(getSendTransactionMethod())
              .addMethod(getGetAddressNonceAtMethod())
              .addMethod(getCreateAddrMethod())
              .addMethod(getGetMaxBlockNumberMethod())
              .addMethod(getGetAddrByPrivMethod())
              .addMethod(getSendTokenMethod())
              .addMethod(getGetBalanceTokenMethod())
              .build();
        }
      }
    }
    return result;
  }
}
