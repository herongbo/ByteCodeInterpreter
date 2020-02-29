package ch03_old.entry;

import ch03.utils.Log;

import java.util.Arrays;

public class ClassFile {
    static {
        int CONSTANT_Class = 7;
        int CONSTANT_Fileref = 9;
        int CONSTANT_Methodref = 10;
        int CONSTANT_InterfaceMethodref = 11;
        int CONSTANT_String = 8;
        int CONSTANT_Integer = 3;
        int CONSTANT_Float = 4;
        int CONSTANT_Long = 5;
        int CONSTANT_Double = 6;
        int CONSTANT_NameAndType = 12;
        int CONSTANT_Utf8 = 1;
        int CONSTANT_MethodHandle = 15;
        int CONSTANT_MethodType = 16;
        int CONSTANT_InvokeDynamic = 18;
    }

    long magic; //uint32
    long minorVersin;//uint 16
    long majorVersion;//uint 16

    ConstantPool constantPool;
    long accessFlags;
    long thisClass;//uint 16
    long superClass;// uint 16
    long[] interfaces;//[]uint 16
    //    MemberInfo[] fields;
    //    MemberInfo[] methods;
    //    AttributeInfo[] attributes;

    public void parse(byte[] classData) {
//        ClassFile classFile = new ClassFile();
        ClassReader classReader = new ClassReader(classData);
        this.read(classReader);
        return;
    }

    public void read(ClassReader reader) {
        this.readAndCheckMagic(reader); //魔数
        this.readAndCheckVersion(reader); //minor_version major_version
        this.constantPool = readConstantPool(reader); // 读取常量池
        this.accessFlags = reader.readUint16();
            System.out.println("accessFlag"+accessFlags);
        this.thisClass = reader.readUint16();
            System.out.println("thisClass"+thisClass);
        this.superClass = reader.readUint16();
            System.out.println("superClass"+superClass);
        int interfacesCount = (int)reader.readUint16();
            System.out.println("interfacesCount"+interfacesCount);

        System.exit(0);
//        this.interfaces = reader.readUint16s();
//        this.fields
//        this.methods
//        this.att
    }

    public void readAndCheckMagic(ClassReader classReader) {
        this.magic = classReader.readUnit32();
        if (this.magic != 0xCAFEBABEL) {
            new ClassFormatError();
            return;
        }
        Log.log("MagicNumberPass");
    }

    public void readAndCheckVersion(ClassReader classReader) {
        this.minorVersin = classReader.readUint16();
        this.majorVersion = classReader.readUint16();
        Log.log(Long.toString(this.minorVersin));
        Log.log(Long.toString(this.majorVersion));
    }

    public ConstantPool readConstantPool(ClassReader reader) {
        long cpCount = (int) reader.readUint16();
        System.out.println("constantPool " + cpCount);
        ConstantPool[] cp = new ConstantPool[(int) cpCount];
        for (int i = 1; i < cpCount; i++) {
//            cp[i] = readConstantInfo(reader,cp);
        }
        return null;
    }

    public ConstantPool readConstantInfo(ClassReader cr, ConstantPool cp) {
        int tag = (int) cr.readUint8();
        ConstantInfo c = new ConstantInfo(tag, cp);
//        cp.readInfo(reader);
        return null;
    }

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

    @Override
    public String toString() {
        return "ClassFile{" +
                "magic=" + magic +
                ", minorVersin=" + minorVersin +
                ", majorVersion=" + majorVersion +
                ", accessFlags=" + accessFlags +
                ", thisClass=" + thisClass +
                ", superClass=" + superClass +
                ", interfaces=" + Arrays.toString(interfaces) +
                '}';
    }
}
