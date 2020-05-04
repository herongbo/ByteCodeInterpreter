package ch05.classfile.beans.impl;

import ch05.classfile.ClassReader;
import ch05.classfile.beans.AttributeInfo;

public class UnparsedAttribute extends AttributeInfo {

    String attrName;
    int attrLen;

    public UnparsedAttribute(String attrName,int attrLen){
        this.attrLen = attrLen;
        this.attrName = attrName;
        System.err.println("un parsed Attribute");
    }

    @Override
    public void readInfo(ClassReader reader) {
        reader.readBytes(attrLen);
    }
}
