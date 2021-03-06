/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.demo.service;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-07-24")
public class AddService {

  public interface Iface {

    public int addNumbers(int para1, int para2) throws org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void addNumbers(int para1, int para2, org.apache.thrift.async.AsyncMethodCallback<Integer> resultHandler) throws org.apache.thrift.TException;

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

    public int addNumbers(int para1, int para2) throws org.apache.thrift.TException
    {
      send_addNumbers(para1, para2);
      return recv_addNumbers();
    }

    public void send_addNumbers(int para1, int para2) throws org.apache.thrift.TException
    {
      addNumbers_args args = new addNumbers_args();
      args.setPara1(para1);
      args.setPara2(para2);
      sendBase("addNumbers", args);
    }

    public int recv_addNumbers() throws org.apache.thrift.TException
    {
      addNumbers_result result = new addNumbers_result();
      receiveBase(result, "addNumbers");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "addNumbers failed: unknown result");
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

    public void addNumbers(int para1, int para2, org.apache.thrift.async.AsyncMethodCallback<Integer> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      addNumbers_call method_call = new addNumbers_call(para1, para2, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class addNumbers_call extends org.apache.thrift.async.TAsyncMethodCall<Integer> {
      private int para1;
      private int para2;
      public addNumbers_call(int para1, int para2, org.apache.thrift.async.AsyncMethodCallback<Integer> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.para1 = para1;
        this.para2 = para2;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("addNumbers", org.apache.thrift.protocol.TMessageType.CALL, 0));
        addNumbers_args args = new addNumbers_args();
        args.setPara1(para1);
        args.setPara2(para2);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public Integer getResult() throws org.apache.thrift.TException {
        if (getState() != State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_addNumbers();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final org.slf4j.Logger _LOGGER = org.slf4j.LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new java.util.HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, java.util.Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> java.util.Map<String,  org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> getProcessMap(java.util.Map<String, org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("addNumbers", new addNumbers());
      return processMap;
    }

    public static class addNumbers<I extends Iface> extends org.apache.thrift.ProcessFunction<I, addNumbers_args> {
      public addNumbers() {
        super("addNumbers");
      }

      public addNumbers_args getEmptyArgsInstance() {
        return new addNumbers_args();
      }

      protected boolean isOneway() {
        return false;
      }

      @Override
      protected boolean handleRuntimeExceptions() {
        return false;
      }

      public addNumbers_result getResult(I iface, addNumbers_args args) throws org.apache.thrift.TException {
        addNumbers_result result = new addNumbers_result();
        result.success = iface.addNumbers(args.para1, args.para2);
        result.setSuccessIsSet(true);
        return result;
      }
    }

  }

  public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
    private static final org.slf4j.Logger _LOGGER = org.slf4j.LoggerFactory.getLogger(AsyncProcessor.class.getName());
    public AsyncProcessor(I iface) {
      super(iface, getProcessMap(new java.util.HashMap<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
    }

    protected AsyncProcessor(I iface, java.util.Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends AsyncIface> java.util.Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase,?>> getProcessMap(java.util.Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      processMap.put("addNumbers", new addNumbers());
      return processMap;
    }

    public static class addNumbers<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, addNumbers_args, Integer> {
      public addNumbers() {
        super("addNumbers");
      }

      public addNumbers_args getEmptyArgsInstance() {
        return new addNumbers_args();
      }

      public org.apache.thrift.async.AsyncMethodCallback<Integer> getResultHandler(final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb, final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new org.apache.thrift.async.AsyncMethodCallback<Integer>() {
          public void onComplete(Integer o) {
            addNumbers_result result = new addNumbers_result();
            result.success = o;
            result.setSuccessIsSet(true);
            try {
              fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY,seqid);
            } catch (org.apache.thrift.transport.TTransportException e) {
              _LOGGER.error("TTransportException writing to internal frame buffer", e);
              fb.close();
            } catch (Exception e) {
              _LOGGER.error("Exception writing to internal frame buffer", e);
              onError(e);
            }
          }
          public void onError(Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TSerializable msg;
            addNumbers_result result = new addNumbers_result();
            if (e instanceof org.apache.thrift.transport.TTransportException) {
              _LOGGER.error("TTransportException inside handler", e);
              fb.close();
              return;
            } else if (e instanceof org.apache.thrift.TApplicationException) {
              _LOGGER.error("TApplicationException inside handler", e);
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TApplicationException)e;
            } else {
              _LOGGER.error("Exception inside handler", e);
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb,msg,msgType,seqid);
            } catch (Exception ex) {
              _LOGGER.error("Exception writing to internal frame buffer", ex);
              fb.close();
            }
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(I iface, addNumbers_args args, org.apache.thrift.async.AsyncMethodCallback<Integer> resultHandler) throws org.apache.thrift.TException {
        iface.addNumbers(args.para1, args.para2,resultHandler);
      }
    }

  }

  public static class addNumbers_args implements org.apache.thrift.TBase<addNumbers_args, addNumbers_args._Fields>, java.io.Serializable, Cloneable, Comparable<addNumbers_args>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("addNumbers_args");

    private static final org.apache.thrift.protocol.TField PARA1_FIELD_DESC = new org.apache.thrift.protocol.TField("para1", org.apache.thrift.protocol.TType.I32, (short)1);
    private static final org.apache.thrift.protocol.TField PARA2_FIELD_DESC = new org.apache.thrift.protocol.TField("para2", org.apache.thrift.protocol.TType.I32, (short)2);

    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new addNumbers_argsStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new addNumbers_argsTupleSchemeFactory();

    public int para1; // required
    public int para2; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      PARA1((short)1, "para1"),
      PARA2((short)2, "para2");

      private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

      static {
        for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
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
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.PARA1, new org.apache.thrift.meta_data.FieldMetaData("para1", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
      tmpMap.put(_Fields.PARA2, new org.apache.thrift.meta_data.FieldMetaData("para2", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
      metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(addNumbers_args.class, metaDataMap);
    }

    public addNumbers_args() {
    }

    public addNumbers_args(
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
    public addNumbers_args(addNumbers_args other) {
      __isset_bitfield = other.__isset_bitfield;
      this.para1 = other.para1;
      this.para2 = other.para2;
    }

    public addNumbers_args deepCopy() {
      return new addNumbers_args(this);
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

    public addNumbers_args setPara1(int para1) {
      this.para1 = para1;
      setPara1IsSet(true);
      return this;
    }

    public void unsetPara1() {
      __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PARA1_ISSET_ID);
    }

    /** Returns true if field para1 is set (has been assigned a value) and false otherwise */
    public boolean isSetPara1() {
      return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PARA1_ISSET_ID);
    }

    public void setPara1IsSet(boolean value) {
      __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PARA1_ISSET_ID, value);
    }

    public int getPara2() {
      return this.para2;
    }

    public addNumbers_args setPara2(int para2) {
      this.para2 = para2;
      setPara2IsSet(true);
      return this;
    }

    public void unsetPara2() {
      __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PARA2_ISSET_ID);
    }

    /** Returns true if field para2 is set (has been assigned a value) and false otherwise */
    public boolean isSetPara2() {
      return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PARA2_ISSET_ID);
    }

    public void setPara2IsSet(boolean value) {
      __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PARA2_ISSET_ID, value);
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
        return getPara1();

      case PARA2:
        return getPara2();

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
      if (that instanceof addNumbers_args)
        return this.equals((addNumbers_args)that);
      return false;
    }

    public boolean equals(addNumbers_args that) {
      if (that == null)
        return false;
      if (this == that)
        return true;

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
      int hashCode = 1;

      hashCode = hashCode * 8191 + para1;

      hashCode = hashCode * 8191 + para2;

      return hashCode;
    }

    @Override
    public int compareTo(addNumbers_args other) {
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

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      scheme(iprot).read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      scheme(oprot).write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("addNumbers_args(");
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

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        __isset_bitfield = 0;
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class addNumbers_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
      public addNumbers_argsStandardScheme getScheme() {
        return new addNumbers_argsStandardScheme();
      }
    }

    private static class addNumbers_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<addNumbers_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, addNumbers_args struct) throws org.apache.thrift.TException {
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

      public void write(org.apache.thrift.protocol.TProtocol oprot, addNumbers_args struct) throws org.apache.thrift.TException {
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

    private static class addNumbers_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
      public addNumbers_argsTupleScheme getScheme() {
        return new addNumbers_argsTupleScheme();
      }
    }

    private static class addNumbers_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<addNumbers_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, addNumbers_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        java.util.BitSet optionals = new java.util.BitSet();
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
      public void read(org.apache.thrift.protocol.TProtocol prot, addNumbers_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        java.util.BitSet incoming = iprot.readBitSet(2);
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

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
      return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
  }

  public static class addNumbers_result implements org.apache.thrift.TBase<addNumbers_result, addNumbers_result._Fields>, java.io.Serializable, Cloneable, Comparable<addNumbers_result>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("addNumbers_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.I32, (short)0);

    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new addNumbers_resultStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new addNumbers_resultTupleSchemeFactory();

    public int success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

      static {
        for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
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
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
      metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(addNumbers_result.class, metaDataMap);
    }

    public addNumbers_result() {
    }

    public addNumbers_result(
      int success)
    {
      this();
      this.success = success;
      setSuccessIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public addNumbers_result(addNumbers_result other) {
      __isset_bitfield = other.__isset_bitfield;
      this.success = other.success;
    }

    public addNumbers_result deepCopy() {
      return new addNumbers_result(this);
    }

    @Override
    public void clear() {
      setSuccessIsSet(false);
      this.success = 0;
    }

    public int getSuccess() {
      return this.success;
    }

    public addNumbers_result setSuccess(int success) {
      this.success = success;
      setSuccessIsSet(true);
      return this;
    }

    public void unsetSuccess() {
      __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SUCCESS_ISSET_ID);
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SUCCESS_ISSET_ID);
    }

    public void setSuccessIsSet(boolean value) {
      __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SUCCESS_ISSET_ID, value);
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
        return getSuccess();

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
      if (that instanceof addNumbers_result)
        return this.equals((addNumbers_result)that);
      return false;
    }

    public boolean equals(addNumbers_result that) {
      if (that == null)
        return false;
      if (this == that)
        return true;

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
      int hashCode = 1;

      hashCode = hashCode * 8191 + success;

      return hashCode;
    }

    @Override
    public int compareTo(addNumbers_result other) {
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

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      scheme(iprot).read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      scheme(oprot).write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("addNumbers_result(");
      boolean first = true;

      sb.append("success:");
      sb.append(this.success);
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        __isset_bitfield = 0;
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class addNumbers_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
      public addNumbers_resultStandardScheme getScheme() {
        return new addNumbers_resultStandardScheme();
      }
    }

    private static class addNumbers_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<addNumbers_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, addNumbers_result struct) throws org.apache.thrift.TException {
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

      public void write(org.apache.thrift.protocol.TProtocol oprot, addNumbers_result struct) throws org.apache.thrift.TException {
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

    private static class addNumbers_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
      public addNumbers_resultTupleScheme getScheme() {
        return new addNumbers_resultTupleScheme();
      }
    }

    private static class addNumbers_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<addNumbers_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, addNumbers_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        java.util.BitSet optionals = new java.util.BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          oprot.writeI32(struct.success);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, addNumbers_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        java.util.BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = iprot.readI32();
          struct.setSuccessIsSet(true);
        }
      }
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
      return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
  }

}
