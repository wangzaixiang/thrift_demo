/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package shared;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SharedService {

  public interface Iface {

    public SharedStruct getStruct(int key) throws org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void getStruct(int key, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.getStruct_call> resultHandler) throws org.apache.thrift.TException;

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

    public SharedStruct getStruct(int key) throws org.apache.thrift.TException
    {
      send_getStruct(key);
      return recv_getStruct();
    }

    public void send_getStruct(int key) throws org.apache.thrift.TException
    {
      getStruct_args args = new getStruct_args();
      args.setKey(key);
      sendBase("getStruct", args);
    }

    public SharedStruct recv_getStruct() throws org.apache.thrift.TException
    {
      getStruct_result result = new getStruct_result();
      receiveBase(result, "getStruct");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "getStruct failed: unknown result");
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

    public void getStruct(int key, org.apache.thrift.async.AsyncMethodCallback<getStruct_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      getStruct_call method_call = new getStruct_call(key, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class getStruct_call extends org.apache.thrift.async.TAsyncMethodCall {
      private int key;
      public getStruct_call(int key, org.apache.thrift.async.AsyncMethodCallback<getStruct_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.key = key;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("getStruct", org.apache.thrift.protocol.TMessageType.CALL, 0));
        getStruct_args args = new getStruct_args();
        args.setKey(key);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public SharedStruct getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_getStruct();
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
      processMap.put("getStruct", new getStruct());
      return processMap;
    }

    public static class getStruct<I extends Iface> extends org.apache.thrift.ProcessFunction<I, getStruct_args> {
      public getStruct() {
        super("getStruct");
      }

      public getStruct_args getEmptyArgsInstance() {
        return new getStruct_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public getStruct_result getResult(I iface, getStruct_args args) throws org.apache.thrift.TException {
        getStruct_result result = new getStruct_result();
        result.success = iface.getStruct(args.key);
        return result;
      }
    }

  }

  public static class getStruct_args implements org.apache.thrift.TBase<getStruct_args, getStruct_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getStruct_args");

    private static final org.apache.thrift.protocol.TField KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("key", org.apache.thrift.protocol.TType.I32, (short)1);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new getStruct_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new getStruct_argsTupleSchemeFactory());
    }

    public int key; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      KEY((short)1, "key");

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
          case 1: // KEY
            return KEY;
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
    private static final int __KEY_ISSET_ID = 0;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.KEY, new org.apache.thrift.meta_data.FieldMetaData("key", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getStruct_args.class, metaDataMap);
    }

    public getStruct_args() {
    }

    public getStruct_args(
      int key)
    {
      this();
      this.key = key;
      setKeyIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getStruct_args(getStruct_args other) {
      __isset_bitfield = other.__isset_bitfield;
      this.key = other.key;
    }

    public getStruct_args deepCopy() {
      return new getStruct_args(this);
    }

    @Override
    public void clear() {
      setKeyIsSet(false);
      this.key = 0;
    }

    public int getKey() {
      return this.key;
    }

    public getStruct_args setKey(int key) {
      this.key = key;
      setKeyIsSet(true);
      return this;
    }

    public void unsetKey() {
      __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __KEY_ISSET_ID);
    }

    /** Returns true if field key is set (has been assigned a value) and false otherwise */
    public boolean isSetKey() {
      return EncodingUtils.testBit(__isset_bitfield, __KEY_ISSET_ID);
    }

    public void setKeyIsSet(boolean value) {
      __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __KEY_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case KEY:
        if (value == null) {
          unsetKey();
        } else {
          setKey((Integer)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case KEY:
        return Integer.valueOf(getKey());

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case KEY:
        return isSetKey();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof getStruct_args)
        return this.equals((getStruct_args)that);
      return false;
    }

    public boolean equals(getStruct_args that) {
      if (that == null)
        return false;

      boolean this_present_key = true;
      boolean that_present_key = true;
      if (this_present_key || that_present_key) {
        if (!(this_present_key && that_present_key))
          return false;
        if (this.key != that.key)
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(getStruct_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      getStruct_args typedOther = (getStruct_args)other;

      lastComparison = Boolean.valueOf(isSetKey()).compareTo(typedOther.isSetKey());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetKey()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.key, typedOther.key);
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
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getStruct_args(");
      boolean first = true;

      sb.append("key:");
      sb.append(this.key);
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

    private static class getStruct_argsStandardSchemeFactory implements SchemeFactory {
      public getStruct_argsStandardScheme getScheme() {
        return new getStruct_argsStandardScheme();
      }
    }

    private static class getStruct_argsStandardScheme extends StandardScheme<getStruct_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, getStruct_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // KEY
              if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                struct.key = iprot.readI32();
                struct.setKeyIsSet(true);
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

      public void write(org.apache.thrift.protocol.TProtocol oprot, getStruct_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        oprot.writeFieldBegin(KEY_FIELD_DESC);
        oprot.writeI32(struct.key);
        oprot.writeFieldEnd();
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class getStruct_argsTupleSchemeFactory implements SchemeFactory {
      public getStruct_argsTupleScheme getScheme() {
        return new getStruct_argsTupleScheme();
      }
    }

    private static class getStruct_argsTupleScheme extends TupleScheme<getStruct_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, getStruct_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetKey()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetKey()) {
          oprot.writeI32(struct.key);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, getStruct_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.key = iprot.readI32();
          struct.setKeyIsSet(true);
        }
      }
    }

  }

  public static class getStruct_result implements org.apache.thrift.TBase<getStruct_result, getStruct_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getStruct_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRUCT, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new getStruct_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new getStruct_resultTupleSchemeFactory());
    }

    public SharedStruct success; // required

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
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SharedStruct.class)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getStruct_result.class, metaDataMap);
    }

    public getStruct_result() {
    }

    public getStruct_result(
      SharedStruct success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getStruct_result(getStruct_result other) {
      if (other.isSetSuccess()) {
        this.success = new SharedStruct(other.success);
      }
    }

    public getStruct_result deepCopy() {
      return new getStruct_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
    }

    public SharedStruct getSuccess() {
      return this.success;
    }

    public getStruct_result setSuccess(SharedStruct success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((SharedStruct)value);
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
      if (that instanceof getStruct_result)
        return this.equals((getStruct_result)that);
      return false;
    }

    public boolean equals(getStruct_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(getStruct_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      getStruct_result typedOther = (getStruct_result)other;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, typedOther.success);
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
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getStruct_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
      if (success != null) {
        success.validate();
      }
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
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class getStruct_resultStandardSchemeFactory implements SchemeFactory {
      public getStruct_resultStandardScheme getScheme() {
        return new getStruct_resultStandardScheme();
      }
    }

    private static class getStruct_resultStandardScheme extends StandardScheme<getStruct_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, getStruct_result struct) throws org.apache.thrift.TException {
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
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.success = new SharedStruct();
                struct.success.read(iprot);
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

      public void write(org.apache.thrift.protocol.TProtocol oprot, getStruct_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          struct.success.write(oprot);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class getStruct_resultTupleSchemeFactory implements SchemeFactory {
      public getStruct_resultTupleScheme getScheme() {
        return new getStruct_resultTupleScheme();
      }
    }

    private static class getStruct_resultTupleScheme extends TupleScheme<getStruct_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, getStruct_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          struct.success.write(oprot);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, getStruct_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = new SharedStruct();
          struct.success.read(iprot);
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

}
