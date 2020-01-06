package ch03.classfile.beans;

import ch03.classfile.ClassReader;

// 解析常量池
public class ConstantPool {





    public ConstantPool getConstantInfo(int index, ConstantPool[] cp) {
        return cp[index];
    }


    public ConstantPool getConstantInfo() {
        return null;
    }

    public String getNameAndType() {
        return null;
    }

    public String getClassName(int index) {
        return null;
    }

    public String getUtf8(int index) {
        return null;
    }

}
