package ch03.classfile.beans.impl;

import ch03.classfile.ClassReader;
import ch03.classfile.beans.ConstantInfo;
import ch03.classfile.beans.ConstantPoolParser;

/**
 * 给出字段或方法的名称和描述符
 * CONSTANT_Class_Info和CONSTANAT_NameAndType_info加在一起可以唯一确定一个字段
 * 或者方法，其结构如下
 */

/**
 * 字段或方法名由name_index给出，字段或方法的描述符由name_index给出
 */
public class ConstantNameAndTypeInfo extends ConstantInfo {
    public int tag;
    public int name_index;
    public int descriotorIndex;

    @Override
    /**
     *  readInfo先读取一个uint32数据，然后把它转型成int32类型
     */
    public void readInfo(ClassReader reader) {
        this.name_index = (int) reader.readUint16();
        this.descriotorIndex = (int) reader.readUint16();
    }
}

