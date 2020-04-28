package ch04.classfile.beans.impl;

import ch04.classfile.ClassReader;
import ch04.classfile.beans.ConstantInfo;
import ch04.classfile.beans.ConstantPoolParser;

public class ConstantClassInfo extends ConstantInfo {
    public int tag;
    public int name_index;
    public ConstantPoolParser cpp;

    public ConstantClassInfo(ConstantPoolParser cpp) {
        this.cpp = cpp;
    }

    @Override
    /**
     *  readInfo先读取一个uint32数据，然后把它转型成int32类型
     */
    public void readInfo(ClassReader reader) {
        this.name_index = (int) reader.readUint16();
    }

    public String name() {
        return cpp.getUtf8(name_index);
    }
}

