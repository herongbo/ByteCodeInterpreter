package ch03.classfile;

import ch03.classfile.beans.ConstantInfo;
import ch03.classfile.beans.ConstantPool;
import ch03.classfile.beans.ConstantPoolParser;

import java.util.Arrays;

public class ClassFile {

    long magic; //uint32
    long minorVersin;//uint 16
    long majorVersion;//uint 16
    ConstantInfo[] constantPool;
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
        this.constantPool = new ConstantPoolParser().readConstantPool(reader);

        // 类访问标志
        this.accessFlags = reader.readUint16();
        System.out.println(Long.toString(this.accessFlags, 16));
//        this.thisClass = reader.readUint16();
//        this.superClass = reader.readUint16();
//        this.interfaces = reader.readUint16s();
//        this.fields = readMembers(reader,self.constantPool)
//        this.methods = readMembers(reader,self.constantPool)
//        this.attributes = readAttributes(reader,self.constantPool)
    }

    // 2 检查魔数
    public void readAndCheckMagic(ClassReader classReader) {
        this.magic = classReader.readUnit32();
        System.out.println(magic);
        System.out.println(magic == 0xCAFEBABEL);
        if (this.magic != 0xCAFEBABEL) {
            new ClassFormatError();
        }
    }


    // 2 检查主次版本号
    public void readAndCheckVersion(ClassReader classReader) {
        this.minorVersin = classReader.readUint16();
        this.majorVersion = classReader.readUint16();
        // 检查版本号 主版本号 和 次版本号
        if (this.majorVersion != 0 || this.majorVersion < 56) {
            new UnsupportedClassVersionError();
        }
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

    public ConstantInfo[] getConstantPool() {
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
