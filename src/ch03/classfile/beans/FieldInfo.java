package ch03.classfile.beans;

/**
 * 字段结构的定义
 */
public class FieldInfo {
    long acessFlags;
    long nameIndex;
    long descriptorIndex;
    long attributesCount;
//    AttributeInfo attributeInfo = new AttributeInfo[attributesCount];
}
