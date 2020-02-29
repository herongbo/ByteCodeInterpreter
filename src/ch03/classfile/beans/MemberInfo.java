package ch03.classfile.beans;

// 同时用于解析Field 和 Method
public class MemberInfo {
    public ConstantInfo[] cp;
    public int accessFlags;
    public int nameIndex;
    public int desceiptorIndex;
    public AttributeInfo[] attributes;
}
