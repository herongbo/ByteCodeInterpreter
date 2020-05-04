package ch04.classfile.beans.impl;

import ch04.classfile.ClassReader;
import ch04.classfile.beans.AttributeInfo;
import ch04.classfile.beans.AttributeInfoParser;
import ch04.classfile.beans.ConstantInfo;

public class CodeAttribute extends AttributeInfo {
    int attributeNameIndex;
    int attributeLength;
    ConstantInfo[] cp;
    int maxStack;
    int maxLocals;
    byte[] code;
    ExceptionTableEntry[] exceptionTable;
    AttributeInfo[] attributes;

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
        //code直接读成byte
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
