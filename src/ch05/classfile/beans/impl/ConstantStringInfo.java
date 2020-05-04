package ch05.classfile.beans.impl;

import ch05.classfile.ClassReader;
import ch05.classfile.beans.ConstantInfo;
import ch05.classfile.beans.ConstantPoolParser;

public class ConstantStringInfo extends ConstantInfo {
    public int tag;
    public int string_index;
    public  ConstantInfo[] cp;
    // 需要继续查找索引的需要用到
    ConstantPoolParser cpp;

    public ConstantStringInfo(ConstantPoolParser cpp) {
        this.cpp = cpp;
    }

    @Override
    /**
     *  可以看到CONSTANT_String_info本身并不存在字符串数据，值存了常量池索引，
     *  这个索引指向一个CONSTANT——Utf——info常量，在目录下创建cp_string_go文件，在其中定义
     *  ConstantStringInfo结构体，代码如下
     */
    public void readInfo(ClassReader reader) {
        this.string_index = (int) reader.readUint16();
    }

    // 按索引从常量池中查找字符串，利用ConstantPoolParser中的方法
    public String string() {
        return cpp.getUtf8(string_index);
    }
}
