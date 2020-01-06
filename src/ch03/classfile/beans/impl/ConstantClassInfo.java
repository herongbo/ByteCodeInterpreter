package ch03.classfile.beans.impl;

import ch03.classfile.ClassReader;
import ch03.classfile.beans.ConstantInfo;
import ch03.classfile.beans.ConstantPoolParser;

public class ConstantClassInfo extends ConstantInfo {
    public int tag;
    public int name_index;
    public ConstantInfo[] cp;
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
        return cpp.getUtf8(cp,name_index);
    }
}

