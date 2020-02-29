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
    public ConstantInfo[] cp;

    // 奇怪的地方：将ConstantPool定义为ConstantInfo数组
    // ConstantPool[] constantInfo;

    // 按照索引解析常量池
    public ConstantInfo[] readConstantPool(ClassReader reader) {
        long cpCount = (int) reader.readUint16();
        System.out.println("Constant_pool");
        System.out.println("constant_pool_count: " + cpCount);

        cp = new ConstantInfo[(int) cpCount];

        // 常量池的索引从1开始，并且比常量池大小小1
        for (int i = 1; i < cpCount; i++) {
            System.out.println("#"+i);
            // 读取一个常量块，不过为什么需要cp呢？
            cp[i] = readConstantInfo(reader, cp);
            if(cp[i] == null){
                System.out.println("error! this is null");
            }
            System.out.println(cp[i].getClass().getSimpleName());
            // 正在修改，ConstantPool对象没有type属性？
            // 计算下一次的索引
            if (ConstantLongInfo.class.equals(cp[i].getClass())) {
                i++;
            }else if (ConstantDoubleInfo.class.equals(cp[i].getClass())) {
                i++;
            }

            /**
             * 常量池内容测试
             */
        }

        for (int i = 1; i < cpCount; i++) {
            if(cp[i] == null){
                continue;
            }

            System.out.print("#" + i);
            switch (cp[i].getClass().getSimpleName()) {
                case "ConstantIntegerInfo":
                    ConstantIntegerInfo c = (ConstantIntegerInfo) cp[i];
                    System.out.println("(Integer):" + c.val);
                    break;
                case "ConstantUTF8Info":
                    ConstantUTF8Info c1 = (ConstantUTF8Info) cp[i];
                    System.out.println("(Utf8):" + c1.string);
                    break;
                case "ConstantClassInfo":
                    ConstantClassInfo c2 = (ConstantClassInfo) cp[i];
                    System.out.println("(class):" + c2.name());
                    break;
                case "ConstantNameAndTypeInfo":
                    ConstantNameAndTypeInfo c3 = (ConstantNameAndTypeInfo) cp[i];
                    System.out.println("(NameAndType):" + ((ConstantUTF8Info)cp[c3.name_index]).string);
                    System.out.println("\tname_index:" + c3.name_index);
                    System.out.println("\tdescriptor_index:" + c3.descriotorIndex);
                    break;
                case "ConstantMethodrefInfo":
                    ConstantMethodrefInfo c4 = (ConstantMethodrefInfo) cp[i];
                    int name_index = ((ConstantNameAndTypeInfo)cp[c4.name_and_type_index]).name_index;
                    System.out.println("(Methodref):" + ((ConstantUTF8Info)cp[name_index]).string);

                    System.out.println("\tname_and_type_index:" + c4.name_and_type_index);
                    System.out.println("\tclass_index" + c4.class_index);
                    break;
                case "ConstantFieldrefInfo":
                    ConstantFieldrefInfo c5 = (ConstantFieldrefInfo) cp[i];
                    int name_index1 = ((ConstantNameAndTypeInfo)cp[c5.name_and_type_index]).name_index;
                    System.out.println("(Fieldref):" + ((ConstantUTF8Info)cp[name_index1]).string);
                    System.out.println("\tname_and_typeindex:" + c5.name_and_type_index);
                    System.out.println("\tclass_index" + c5.class_index);
                    break;
                case "ConstantInterfacemethodrefInfo":
                    ConstantInterfacemethodrefInfo c6 = (ConstantInterfacemethodrefInfo) cp[i];
                    int name_index2 = ((ConstantNameAndTypeInfo)cp[c6.name_and_type_index]).name_index;
                    System.out.println("(Interfaceref):" + ((ConstantUTF8Info)cp[name_index2]).string);
                    System.out.println("\tname_and_type_index" + c6.name_and_type_index);
                    System.out.println("\tclass_index:" + c6.class_index);
                    break;
                case "ConstantDoubleInfo":
                    ConstantDoubleInfo c7 = (ConstantDoubleInfo) cp[i];
                    System.out.println("(Double):" + c7.val);
                    break;
                case "ConstantStringInfo":
                    ConstantStringInfo c8 = (ConstantStringInfo) cp[i];
                    System.out.println("(String):" + c8.string());
                    break;
                case "ConstantFloatInfo":
                    ConstantFloatInfo c9 = (ConstantFloatInfo) cp[i];
                    System.out.println("(Float):" + c9.val);
                    break;
                case "ConstantLongInfo":
                    ConstantLongInfo c10 = (ConstantLongInfo) cp[i];
                    System.out.println("(Long):" + c10.val);
                    break;
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
        System.out.println(c==null);
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
            System.err.println(index);
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
            case CONSTANT_Double:
                return new ConstantDoubleInfo();
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
            case CONSTANT_MethodType:
                return new ConstantMethodTypeInfo();
            case CONSTANT_MethodHandle:
                return new ConstantMethodHandleInfo();
            case CONSTANT_InvokeDynamic:
                return new ConstantInvokeDynamicInfo();
            default:
                System.err.println("java.lang.ClassFormatError: constant pool tag");
                break;
        }
        return null;
    }

    // getNameAndType方法从常量池查找字段或方法的名字和描述符，代码如下：
    public String getNameAndType(int index) {
        ConstantNameAndTypeInfo ntInfo = (ConstantNameAndTypeInfo) getConstantInfo(cp, index);
//        String name = getUtf8(cp,ntInfo.nameIndex);
//        String type = getUtf8(cp,ntInfo.descriptorIndex);
        return null;
    }

    public String getClassName(int index) {
        ConstantInfo constantInfo = getConstantInfo(cp, index);
//        return getUtf8(constantInfo.nameIndex);
        return null;
    }

    // getUtf-8方法从常量池查找UTF-8字符串
    public String getUtf8(int index) {
        ConstantUTF8Info utf8Info = (ConstantUTF8Info) getConstantInfo(cp, index);
        // 结果应该有问题
        return utf8Info.string;
    }
}
