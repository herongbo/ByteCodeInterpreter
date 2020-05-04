package ch05.classfile.beans.impl;

import ch05.classfile.ClassReader;
import ch05.classfile.beans.AttributeInfo;
import ch05.classfile.beans.AttributeInfoParser;
import ch05.classfile.beans.ConstantInfo;

public class CodeAttribute extends AttributeInfo {
    public int attributeNameIndex;
    public int attributeLength;
    public ConstantInfo[] cp;
    public int maxStack;
    public int maxLocals;
    public byte[] code;
    public ExceptionTableEntry[] exceptionTable;
    public AttributeInfo[] attributes;

    public CodeAttribute(ConstantInfo[] cp){
        this.cp = cp;
    }

    class ExceptionTableEntry{
        public int startPc;
        public int endPc;
        public int handlerPc;
        public int catchType;
    }

    @Override
    public void readInfo(ClassReader reader){
        this.maxStack = (int)reader.readUint16();
        this.maxLocals = (int)reader.readUint16();
        int codeLength = (int)reader.readUnit32();
        this.code = reader.readBytes(codeLength);
        this.exceptionTable = readExceptionTable(reader);
        this.attributes = new AttributeInfoParser().readAttributes(reader,cp);
    }

    public ExceptionTableEntry[] readExceptionTable(ClassReader reader){
        int exceptionTableLength = (int)reader.readUint16();
        exceptionTable = new ExceptionTableEntry[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            exceptionTable[i] = new ExceptionTableEntry();
            exceptionTable[i].startPc = (int)reader.readUint16();
            exceptionTable[i].endPc = (int)reader.readUint16();
            exceptionTable[i].handlerPc = (int)reader.readUint16();
            exceptionTable[i].catchType = (int)reader.readUint16();
        }
        return exceptionTable;
    }
}
