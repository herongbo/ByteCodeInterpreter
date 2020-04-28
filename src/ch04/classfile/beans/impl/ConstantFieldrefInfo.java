package ch04.classfile.beans.impl;

import ch04.classfile.ClassReader;
import ch04.classfile.beans.ConstantInfo;
import ch04.classfile.beans.ConstantPoolParser;

public class ConstantFieldrefInfo extends ConstantInfo {
    public int tag;
    public int class_index;
    public int name_and_type_index;
    ConstantPoolParser cpp;

    public ConstantFieldrefInfo(ConstantPoolParser cpp) {
        this.cpp = cpp;
    }

    @Override
    /**
     *  ？将long类型转换double类型
     */
    public void readInfo(ClassReader reader) {
        this.class_index = (int) reader.readUint16();
        this.name_and_type_index = (int) reader.readUint16();
    }

    /**
     * class_index 和 name_and_type_index都是常量池索引，分别指向CONSTANT_Class_info
     * 和CONSTANT_NameAndType_info常量，先定义一个同意的结构体ConstantMemberrefInfo来表示
     * 这3种常量
     */
    public String ClassName() {
        return cpp.getNameAndType(name_and_type_index);
    }
}
