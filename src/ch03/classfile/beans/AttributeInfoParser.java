package ch03.classfile.beans;

import ch03.classfile.ClassReader;
import ch03.classfile.beans.impl.*;

public class AttributeInfoParser {

    public  AttributeInfo[] readAttributes(ClassReader reader, ConstantInfo[] cp){
        int attributesCount = (int)reader.readUint16();
        AttributeInfo[] attributes = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            attributes[i] = readAttribute(reader,cp);
        }
        return attributes;
    }

    // 读取单个属性
    public  AttributeInfo readAttribute(ClassReader reader,ConstantInfo[] cp){
        int attrNameIndex = (int)reader.readUint16();

        String attrName = ((ConstantUTF8Info)cp[attrNameIndex]).string;
        System.out.println("AttrName"+attrName);
        int attrLen = (int)reader.readUnit32();
        AttributeInfo attrInfo = newAttributeInfo(attrName,attrLen,cp);
        attrInfo.readInfo(reader);
        return attrInfo;
    }

    public AttributeInfo newAttributeInfo(String attrName,int attrLen,ConstantInfo[] cp){
        switch (attrName){
            case "Code": return new CodeAttribute(cp);
            case "ConstantValue": return new ConstantValueAttribute();
            case "Deprecated": return new DeprecatedAttribute();
            case "Exceptions": return new ExceptionsAttribute();
            case "LineNumberTable": return new LineNumberTableAttribute();
            case "LocalVariableTable": return new LocalVariableTableAttribute();
            case "SourceFile": return new SourceFileAttribute(cp);
            case "Synthetic": return new SyntheticAttribute();
            case "StackMapTable": return new StackMapTableAttribute(attrLen);
            default: return new UnparsedAttribute(attrName,attrLen);
        }
    }

}
