/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.demo.service;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2018-7-25")
public class AddService {

  public interface Iface {

    public int addTwoNumbers(int para1, int para2) throws TException;

  }

  public interface AsyncIface {

    public void addTwoNumbers(int para1, int para2, AsyncMethodCallback resultHandler) throws TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public int addTwoNumbers(int para1, int para2) throws TException
    {
      send_addTwoNumbers(para1, para2);
      return recv_addTwoNumbers();
    }

    public void send_addTwoNumbers(int para1, int para2) throws TException
    {
      addTwoNumbers_args args = new addTwoNumbers_args();
      args.setPara1(para1);
      args.setPara2(para2);
      sendBase("addTwoNumbers", args);
    }

    public int recv_addTwoNumbers() throws TException
    {
      addTwoNumbers_result result = new addTwoNumbers_result();
      receiveBase(result, "addTwoNumbers");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "addTwoNumbers failed: unknown result");
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void addTwoNumbers(int para1, int para2, AsyncMethodCallback resultHandler) throws TException {
      checkReady();
      addTwoNumbers_call method_call = new addTwoNumbers_call(para1, para2, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class addTwoNumbers_call extends org.apache.thrift.async.TAsyncMethodCall {
      private int para1;
      private int para2;
      public addTwoNumbers_call(int para1, int para2, AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.para1 = para1;
        this.para2 = para2;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("addTwoNumbers", org.apache.thrift.protocol.TMessageType.CALL, 0));
        addTwoNumbers_args args = new addTwoNumbers_args();
        args.setPara1(para1);
        args.setPara2(para2);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public int getResult() throws TException {
        if (getState() != State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_addTwoNumbers();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("addTwoNumbers", new addTwoNumbers());
      return processMap;
    }

    public static class addTwoNumbers<I extends Iface> extends org.apache.thrift.ProcessFunction<I, addTwoNumbers_args> {
      public addTwoNumbers() {
        super("addTwoNumbers");
      }

      public addTwoNumbers_args getEmptyArgsInstance() {
        return new addTwoNumbers_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public addTwoNumbers_result getResult(I iface, addTwoNumbers_args args) throws TException {
        addTwoNumbers_result result = new addTwoNumbers_result();
        result.success = iface.addTwoNumbers(args.para1, args.para2);
        result.setSuccessIsSet(true);
        return result;
      }
    }

  }

  public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncProcessor.class.getName());
    public AsyncProcessor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
    }

    protected AsyncProcessor(I iface, Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends AsyncIface> Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase,?>> getProcessMap(Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      processMap.put("addTwoNumbers", new addTwoNumbers());
      return processMap;
    }

    public static class addTwoNumbers<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, addTwoNumbers_args, Integer> {
      public addTwoNumbers() {
        super("addTwoNumbers");
      }

      public addTwoNumbers_args getEmptyArgsInstance() {
        return new addTwoNumbers_args();
      }

      public AsyncMethodCallback<Integer> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new AsyncMethodCallback<Integer>() { 
          public void onComplete(Integer o) {
            addTwoNumbers_result result = new addTwoNumbers_result();
            result.success = o;
            result.setSuccessIsSet(true);
            try {
              fcall.sendResponse(fb,result, org.apache.thrift.protocol.TMessageType.REPLY,seqid);
              return;
            } catch (Exception e) {
              LOGGER.error("Exception writing to internal frame buffer", e);
            }
            fb.close();
          }
          public void onError(Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TBase msg;
            addTwoNumbers_result result = new addTwoNumbers_result();
            {
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TBase)new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb,msg,msgType,seqid);
              return;
            } catch (Exception ex) {
              LOGGER.error("Exception writing to internal frame buffer", ex);
            }
            fb.close();
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(I iface, addTwoNumbers_args args, AsyncMethodCallback<Integer> resultHandler) throws TException {
        iface.addTwoNumbers(args.para1, args.para2,resultHandler);
      }
    }

  }

  public static class addTwoNumbers_args implements org.apache.thrift.TBase<addTwoNumbers_args, addTwoNumbers_args._Fields>, java.io.Serializable, Cloneable, Comparable<addTwoNumbers_args>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("addTwoNumbers_args");

    private static final org.apache.thrift.protocol.TField PARA1_FIELD_DESC = new org.apache.thrift.protocol.TField("para1", org.apache.thrift.protocol.TType.I32, (short)1);
    private static final org.apache.thrift.protocol.TField PARA2_FIELD_DESC = new org.apache.thrift.protocol.TField("para2", org.apache.thrift.protocol.TType.I32, (short)2);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new addTwoNumbers_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new addTwoNumbers_argsTupleSchemeFactory());
    }

    public int para1; // required
    public int para2; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      PARA1((short)1, "para1"),
      PARA2((short)2, "para2");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // PARA1
            return PARA1;
          case 2: // PARA2
            return PARA2;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    private static final int __PARA1_ISSET_ID = 0;
    private static final int __PARA2_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.PARA1, new org.apache.thrift.meta_data.FieldMetaData("para1", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
      tmpMap.put(_Fields.PARA2, new org.apache.thrift.meta_data.FieldMetaData("para2", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(addTwoNumbers_args.class, metaDataMap);
    }

    public addTwoNumbers_args() {
    }

    public addTwoNumbers_args(
      int para1,
      int para2)
    {
      this();
      this.para1 = para1;
      setPara1IsSet(true);
      this.para2 = para2;
      setPara2IsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public addTwoNumbers_args(addTwoNumbers_args other) {
      __isset_bitfield = other.__isset_bitfield;
      this.para1 = other.para1;
      this.para2 = other.para2;
    }

    public addTwoNumbers_args deepCopy() {
      return new addTwoNumbers_args(this);
    }

    @Override
    public void clear() {
      setPara1IsSet(false);
      this.para1 = 0;
      setPara2IsSet(false);
      this.para2 = 0;
    }

    public int getPara1() {
      return this.para1;
    }

    public addTwoNumbers_args setPara1(int para1) {
      this.para1 = para1;
      setPara1IsSet(true);
      return this;
    }

    public void unsetPara1() {
      __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PARA1_ISSET_ID);
    }

    /** Returns true if field para1 is set (has been assigned a value) and false otherwise */
    public boolean isSetPara1() {
      return EncodingUtils.testBit(__isset_bitfield, __PARA1_ISSET_ID);
    }

    public void setPara1IsSet(boolean value) {
      __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PARA1_ISSET_ID, value);
    }

    public int getPara2() {
      return this.para2;
    }

    public addTwoNumbers_args setPara2(int para2) {
      this.para2 = para2;
      setPara2IsSet(true);
      return this;
    }

    public void unsetPara2() {
      __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PARA2_ISSET_ID);
    }

    /** Returns true if field para2 is set (has been assigned a value) and false otherwise */
    public boolean isSetPara2() {
      return EncodingUtils.testBit(__isset_bitfield, __PARA2_ISSET_ID);
    }

    public void setPara2IsSet(boolean value) {
      __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PARA2_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case PARA1:
        if (value == null) {
          unsetPara1();
        } else {
          setPara1((Integer)value);
        }
        break;

      case PARA2:
        if (value == null) {
          unsetPara2();
        } else {
          setPara2((Integer)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case PARA1:
        return Integer.valueOf(getPara1());

      case PARA2:
        return Integer.valueOf(getPara2());

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case PARA1:
        return isSetPara1();
      case PARA2:
        return isSetPara2();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof addTwoNumbers_args)
        return this.equals((addTwoNumbers_args)that);
      return false;
    }

    public boolean equals(addTwoNumbers_args that) {
      if (that == null)
        return false;

      boolean this_present_para1 = true;
      boolean that_present_para1 = true;
      if (this_present_para1 || that_present_para1) {
        if (!(this_present_para1 && that_present_para1))
          return false;
        if (this.para1 != that.para1)
          return false;
      }

      boolean this_present_para2 = true;
      boolean that_present_para2 = true;
      if (this_present_para2 || that_present_para2) {
        if (!(this_present_para2 && that_present_para2))
          return false;
        if (this.para2 != that.para2)
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_para1 = true;
      list.add(present_para1);
      if (present_para1)
        list.add(para1);

      boolean present_para2 = true;
      list.add(present_para2);
      if (present_para2)
        list.add(para2);

      return list.hashCode();
    }

    @Override
    public int compareTo(addTwoNumbers_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetPara1()).compareTo(other.isSetPara1());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetPara1()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.para1, other.para1);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetPara2()).compareTo(other.isSetPara2());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetPara2()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.para2, other.para2);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("addTwoNumbers_args(");
      boolean first = true;

      sb.append("para1:");
      sb.append(this.para1);
      first = false;
      if (!first) sb.append(", ");
      sb.append("para2:");
      sb.append(this.para2);
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        __isset_bitfield = 0;
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class addTwoNumbers_argsStandardSchemeFactory implements SchemeFactory {
      public addTwoNumbers_argsStandardScheme getScheme() {
        return new addTwoNumbers_argsStandardScheme();
      }
    }

    private static class addTwoNumbers_argsStandardScheme extends StandardScheme<addTwoNumbers_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, addTwoNumbers_args struct) throws TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // PARA1
              if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                struct.para1 = iprot.readI32();
                struct.setPara1IsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // PARA2
              if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                struct.para2 = iprot.readI32();
                struct.setPara2IsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, addTwoNumbers_args struct) throws TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        oprot.writeFieldBegin(PARA1_FIELD_DESC);
        oprot.writeI32(struct.para1);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(PARA2_FIELD_DESC);
        oprot.writeI32(struct.para2);
        oprot.writeFieldEnd();
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class addTwoNumbers_argsTupleSchemeFactory implements SchemeFactory {
      public addTwoNumbers_argsTupleScheme getScheme() {
        return new addTwoNumbers_argsTupleScheme();
      }
    }

    private static class addTwoNumbers_argsTupleScheme extends TupleScheme<addTwoNumbers_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, addTwoNumbers_args struct) throws TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetPara1()) {
          optionals.set(0);
        }
        if (struct.isSetPara2()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetPara1()) {
          oprot.writeI32(struct.para1);
        }
        if (struct.isSetPara2()) {
          oprot.writeI32(struct.para2);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, addTwoNumbers_args struct) throws TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.para1 = iprot.readI32();
          struct.setPara1IsSet(true);
        }
        if (incoming.get(1)) {
          struct.para2 = iprot.readI32();
          struct.setPara2IsSet(true);
        }
      }
    }

  }

  public static class addTwoNumbers_result implements org.apache.thrift.TBase<addTwoNumbers_result, addTwoNumbers_result._Fields>, java.io.Serializable, Cloneable, Comparable<addTwoNumbers_result>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("addTwoNumbers_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.I32, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new addTwoNumbers_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new addTwoNumbers_resultTupleSchemeFactory());
    }

    public int success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    private static final int __SUCCESS_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(addTwoNumbers_result.class, metaDataMap);
    }

    public addTwoNumbers_result() {
    }

    public addTwoNumbers_result(
      int success)
    {
      this();
      this.success = success;
      setSuccessIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public addTwoNumbers_result(addTwoNumbers_result other) {
      __isset_bitfield = other.__isset_bitfield;
      this.success = other.success;
    }

    public addTwoNumbers_result deepCopy() {
      return new addTwoNumbers_result(this);
    }

    @Override
    public void clear() {
      setSuccessIsSet(false);
      this.success = 0;
    }

    public int getSuccess() {
      return this.success;
    }

    public addTwoNumbers_result setSuccess(int success) {
      this.success = success;
      setSuccessIsSet(true);
      return this;
    }

    public void unsetSuccess() {
      __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SUCCESS_ISSET_ID);
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return EncodingUtils.testBit(__isset_bitfield, __SUCCESS_ISSET_ID);
    }

    public void setSuccessIsSet(boolean value) {
      __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SUCCESS_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((Integer)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return Integer.valueOf(getSuccess());

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof addTwoNumbers_result)
        return this.equals((addTwoNumbers_result)that);
      return false;
    }

    public boolean equals(addTwoNumbers_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true;
      boolean that_present_success = true;
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (this.success != that.success)
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_success = true;
      list.add(present_success);
      if (present_success)
        list.add(success);

      return list.hashCode();
    }

    @Override
    public int compareTo(addTwoNumbers_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("addTwoNumbers_result(");
      boolean first = true;

      sb.append("success:");
      sb.append(this.success);
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        __isset_bitfield = 0;
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class addTwoNumbers_resultStandardSchemeFactory implements SchemeFactory {
      public addTwoNumbers_resultStandardScheme getScheme() {
        return new addTwoNumbers_resultStandardScheme();
      }
    }

    private static class addTwoNumbers_resultStandardScheme extends StandardScheme<addTwoNumbers_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, addTwoNumbers_result struct) throws TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                struct.success = iprot.readI32();
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, addTwoNumbers_result struct) throws TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.isSetSuccess()) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          oprot.writeI32(struct.success);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class addTwoNumbers_resultTupleSchemeFactory implements SchemeFactory {
      public addTwoNumbers_resultTupleScheme getScheme() {
        return new addTwoNumbers_resultTupleScheme();
      }
    }

    private static class addTwoNumbers_resultTupleScheme extends TupleScheme<addTwoNumbers_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, addTwoNumbers_result struct) throws TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          oprot.writeI32(struct.success);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, addTwoNumbers_result struct) throws TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = iprot.readI32();
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

}
