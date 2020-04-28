package ch04.classfile.beans.impl;

import ch04.classfile.ClassReader;
import ch04.classfile.beans.AttributeInfo;

public class ExceptionsAttribute extends AttributeInfo {
    int attributeNameIndex;
    int attributeLength;
    int numberOfExceptions;
    int[] exceptionIndexTable;

    @Override
    public void readInfo(ClassReader reader){
        this.exceptionIndexTable = reader.readUint16s();
    }

    public int[] ExceptionIndexTable(){
        return this.exceptionIndexTable;
    }
}
