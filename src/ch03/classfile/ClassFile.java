package ch03.classfile;

import ch03.classfile.beans.ConstantInfo;
import ch03.classfile.beans.ConstantPool;

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

    // 把byte[]解析成ClassFile结构体
    public ClassFile parse(byte[] classData) {
        ClassFile classFile = new ClassFile();
        ClassReader classReader = new ClassReader(classData);
        classFile.read(classReader);
        return classFile;
    }

    public void read(ClassReader reader) {
        this.readAndCheckMagic(reader); //魔数
        this.readAndCheckVersion(reader); //minor_version major_version
        this.constantPool = readConstantPool(reader);
//        this.accessFlags = reader.readUint16();
//        this.thisClass = reader.readUint16();
//        this.superClass = reader.readUint16();
//        this.interfaces = reader.readUint16s();
//        this.fields = readMembers(reader,self.constantPool)
//        this.methods = readMembers(reader,self.constantPool)
//        this.attributes = readAttributes(reader,self.constantPool)
    }

    // 魔数
    public void readAndCheckMagic(ClassReader classReader) {
        this.magic = classReader.readUnit32();
        System.out.println(magic);
        System.out.println(magic == 0xCAFEBABEL);
        if (this.magic != 0xCAFEBABEL) {
            new ClassFormatError();
        }
    }

    public void readAndCheckVersion(ClassReader classReader) {
        this.minorVersin = classReader.readUint16();
        this.majorVersion = classReader.readUint16();
        // 检查版本号 主版本号 和 次版本号
        if (this.majorVersion != 0 || this.majorVersion < 56) {
            new UnsupportedClassVersionError();
        }
    }

    public ConstantPool readConstantPool(ClassReader reader) {
        long cpCount = (int) reader.readUint16();
        System.out.println("constantPool " + cpCount);
        ConstantPool[] cp = new ConstantPool[(int) cpCount];
        for (int i = 1; i < cpCount; i++) {
//            cp[i] = readConstantInfo(reader,cp);
        }
        // 跳过常量池
        reader.readBytes((int)cpCount);
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

    public long getMagic() {
        return magic;
    }

    public long getMinorVersin() {
        return minorVersin;
    }

    public long getMajorVersion() {
        return majorVersion;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public long getAccessFlags() {
        return accessFlags;
    }

    public long getThisClass() {
        return thisClass;
    }

    public long getSuperClass() {
        return superClass;
    }

    public long[] getInterfaces() {
        return interfaces;
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
