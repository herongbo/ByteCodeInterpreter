package ch03.classfile.beans.impl;

import ch03.classfile.ClassReader;
import ch03.classfile.beans.AttributeInfo;

public class DeprecatedAttribute extends AttributeInfo {
//    int attributeNameIndex;
//    int attributeLength;
//    int info;

    /**
     * 由于不包含任何数据，所有attribute_length的值必须是0，Deprecated属性用于指出类、接口、字段或方法已经不建议使用
     * 编译器的工具可以根据Deprecateed属性输出警告信息，J2SE5.0之前可以使用javaDoc提供的标签给类、类、接口、字段或犯法变价Deprecated属性
     * @param reader
     */
    @Override
    public void readInfo(ClassReader reader){
        // read nothing
    }
}
