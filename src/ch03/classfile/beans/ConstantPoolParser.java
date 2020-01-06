package ch03.classfile.beans;

import ch03.classfile.ClassReader;
import ch03.classfile.beans.impl.*;

/**
 * 常量池解析类
 */
public class ConstantPoolParser {

    /**
     * Java虚拟机规范一共定义了14种常量
     */
    final static int CONSTANT_Class = 7;
    final static int CONSTANT_Fileref = 9;
    final static int CONSTANT_Methodref = 10;
    final static int CONSTANT_InterfaceMethodref = 11;
    final static int CONSTANT_String = 8;
    final static int CONSTANT_Integer = 3;
    final static int CONSTANT_Float = 4;
    final static int CONSTANT_Long = 5;
    final static int CONSTANT_Double = 6;
    final static int CONSTANT_NameAndType = 12;
    final static int CONSTANT_Utf8 = 1;
    final static int CONSTANT_MethodHandle = 15;
    final static int CONSTANT_MethodType = 16;
    final static int CONSTANT_InvokeDynamic = 18;


    // 奇怪的地方：将ConstantPool定义为ConstantInfo数组
    // ConstantPool[] constantInfo;

    // 按照索引解析常量池
    public ConstantInfo[] readConstantPool(ClassReader reader) {
        long cpCount = (int) reader.readUint16();
        System.out.println("constantPoolsize " + cpCount);

        ConstantInfo[] cp = new ConstantInfo[(int) cpCount];

        // 常量池的索引从1开始，并且比常量池大小小1
        for (int i = 1; i < cpCount; i++) {
            System.out.println();
            // 读取一个常量块，不过为什么需要cp呢？
            cp[i] = readConstantInfo(reader, cp);
            System.out.println("index:" + i);
            // 正在修改，ConstantPool对象没有type属性？
            // 计算下一次的索引
            if (ConstantLongInfo.class.equals(cp[i].getClass())) {
                i++;
            }

            /**
             * 常量池内容测试
             */
            System.out.println(cp[i].getClass().getSimpleName());
            switch (cp[i].getClass().getSimpleName()) {
                case "ConstantIntegerInfo":
                    ConstantIntegerInfo c = (ConstantIntegerInfo) cp[i];
                    System.out.println("ConstantIntegerInfo " + c.val);
                case "ConstantUTF8Info":
                    ConstantUTF8Info c1 = (ConstantUTF8Info) cp[i];
                    System.out.println("ConstantUTF8Info " + c1.string);
                case "ConstantClassInfo":
                    ConstantClassInfo c2 = (ConstantClassInfo) cp[i];
                    System.out.println("ConstantClassInfo" + c2.name());
                default:

            }
        }
        return cp;
    }

    // ConstantInfo相当于里面的每一个常量
    public ConstantInfo readConstantInfo(ClassReader reader, ConstantInfo[] cp) {
        // 先读一个字节，看看是什么类型
        int tag = (int) reader.readUint8();
        // 根据tag创建类型
        ConstantInfo c = newConstantInfo(tag, cp);
        // 调用这个对象自己的read方法读数据
        c.readInfo(reader);
        return c;
    }

    /**
     * 按照索引查找常量
     *
     * @param cp
     * @param index
     * @return
     */
    public ConstantInfo getConstantInfo(ConstantInfo[] cp, int index) {
        if (index >= 1 && index < cp.length) {
            return cp[index];
        } else {
            new ArrayIndexOutOfBoundsException("Invallid constant pool index!");
            return null;
        }
    }

    public ConstantInfo newConstantInfo(int tag, ConstantInfo[] cp) {
        System.out.println("tag；" + tag);
        switch (tag) {
            case CONSTANT_Integer:
                return new ConstantIntegerInfo();
            case CONSTANT_Float:
                return new ConstantFloatInfo();
            case CONSTANT_Long:
                return new ConstantLongInfo();
            case CONSTANT_Utf8:
                return new ConstantUTF8Info();
            case CONSTANT_String:
                return new ConstantStringInfo(this);
            case CONSTANT_Class:
                return new ConstantClassInfo(this);
            case CONSTANT_NameAndType:
                return new ConstantNameAndTypeInfo();
            case CONSTANT_Methodref:
                return new ConstantMethodrefInfo(this);
            case CONSTANT_Fileref:
                return new ConstantFieldrefInfo(this);
            case CONSTANT_InterfaceMethodref:
                return new ConstantInterfacemethodrefInfo(this);
            default:
                System.err.println("java.lang.ClassFormatError: constant pool tag");
                break;
        }
        return null;
    }

    // getNameAndType方法从常量池查找字段或方法的名字和描述符，代码如下：
    public String getNameAndType(ConstantInfo[] cp, int index) {
        ConstantNameAndTypeInfo ntInfo = (ConstantNameAndTypeInfo) getConstantInfo(cp, index);
//        String name = getUtf8(cp,ntInfo.nameIndex);
//        String type = getUtf8(cp,ntInfo.descriptorIndex);
        return null;
    }

    public String getClassName(ConstantInfo[] cp, int index) {
        ConstantInfo constantInfo = getConstantInfo(cp, index);
//        return getUtf8(constantInfo.nameIndex);
        return null;
    }

    // getUtf-8方法从常量池查找UTF-8字符串
    public String getUtf8(ConstantInfo[] cp, int index) {
        ConstantInfo utf8Info = getConstantInfo(cp, index);
        // 结果应该有问题
        return utf8Info.toString();
    }
}
