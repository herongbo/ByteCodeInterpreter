package ch05.classfile;

import ch05.classfile.beans.*;
import ch05.classfile.beans.impl.ConstantClassInfo;
import ch05.classfile.beans.impl.ConstantUTF8Info;

import java.util.Arrays;

public class ClassFile {

    public long magic; //uint32
    public long minorVersin;//uint 16
    public long majorVersion;//uint 16
    public ConstantInfo[] constantPool;
    public long accessFlags;
    public long thisClass;//uint 16
    public long superClass;// uint 16
    public long[] interfaces;//[]uint 16
    public MemberInfo[] methods;
    public MemberInfo[] fields;

    // 把byte[]解析成ClassFile结构体
    public ClassFile parse(byte[] classData) {
        ClassFile classFile = new ClassFile();
        ClassReader classReader = new ClassReader(classData);
        classFile.read(classReader);
        System.out.println(classFile.methods==null);
        return classFile;
    }

    public void read(ClassReader reader) {
        this.readAndCheckMagic(reader); //魔数
        this.readAndCheckVersion(reader); //minor_version major_version
        this.constantPool = new ConstantPoolParser().readConstantPool(reader);

        // 类访问标志，第六章完善
        this.accessFlags = reader.readUint16();
            System.out.println("access_flag:" + accessFlags);
        this.thisClass = reader.readUint16();
        ConstantClassInfo classInfo = (ConstantClassInfo)constantPool[(int)thisClass];
            System.out.println("this_class:#"+ thisClass + classInfo.name());
        this.superClass = reader.readUint16();
        ConstantClassInfo superInfo = (ConstantClassInfo)constantPool[(int)superClass];
            System.out.println("super_class:#"+ superClass + superInfo.name());
        int interfacesCount = (int)reader.readUint16();
            System.out.println("interfaces_count:"+interfacesCount);

        System.out.println("interfaces");
        //interface没有解析
        MemberInfo[] fields = new MemberInfoParser().readMembers(reader,constantPool);
        this.fields = fields;
        System.out.println("field_count:"+ fields.length);
        for (int i = 0; i < fields.length; i++) {
            System.out.println("#" + (i+1));
            System.out.println("\taccess_flag:" + fields[i].accessFlags);
            System.out.println("\tname_index:" + fields[i].nameIndex);
            System.out.println("\tdescriptor_index:" + fields[i].desceiptorIndex);
            System.out.println("\tattributes_count:" + fields[i].attributes.length);
            System.out.println("\tattributes:" + fields[i].attributes);
        }

        MemberInfo[] methods = new MemberInfoParser().readMembers(reader,constantPool);
        this.methods = methods;
        System.out.println("method_count:"+ methods.length);
        for (int i = 0; i < methods.length; i++) {
            System.out.println("#" + i);
            System.out.println("\taccess_flag:" + methods[i].accessFlags);
            System.out.println("\tname_index:" + methods[i].nameIndex);
            System.out.println("\tdescriptor_index:" + methods[i].desceiptorIndex);
            System.out.println("\tattributes_count:" + methods[i].attributes.length);
            System.out.println("\tattributes:");
        }

        AttributeInfo[] attributeInfos = new AttributeInfoParser().readAttributes(reader,constantPool);
        System.out.println("attributes_count:"+ attributeInfos.length);
        System.out.println("attributes");
        for (int i = 0; i < attributeInfos.length; i++) {
            System.out.println("#" + i);
            System.out.println(attributeInfos[i]);
        }
        System.out.println(this.methods==null);
    }

    // 2 检查魔数
    public void readAndCheckMagic(ClassReader classReader) {
        this.magic = classReader.readUnit32();
        System.out.println("magic:0x" + Long.toHexString(magic));
        if (this.magic != 0xCAFEBABEL) {
            new ClassFormatError();
        }
    }


    // 2 检查主次版本号
    public void readAndCheckVersion(ClassReader classReader) {
        this.minorVersin = classReader.readUint16();
        this.majorVersion = classReader.readUint16();
        System.out.println("minor_version" + minorVersin);
        System.out.println("major_version" + majorVersion);
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
