package ch04.classfile.beans.impl;

import ch04.classfile.ClassReader;
import ch04.classfile.beans.AttributeInfo;

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
