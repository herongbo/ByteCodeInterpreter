package ch05.classfile.beans;

import ch05.classfile.ClassReader;
import ch05.classfile.beans.impl.ConstantUTF8Info;

import java.lang.reflect.Member;

// 同时用于Method 和Field 字段解析
public class MemberInfoParser {

    // 初始化并读取内容
    public MemberInfo[] readMembers(ClassReader reader,ConstantInfo[] cp){
        int memberCount = (int)reader.readUint16();
//        System.out.println("memberCount "+memberCount);
        MemberInfo[] memberInfos = new MemberInfo[memberCount];
        for (int i = 0; i < memberCount; i++) {
            memberInfos[i] = readMember(reader,cp);
        }

        return memberInfos;
    }

    public MemberInfo readMember(ClassReader reader,ConstantInfo[] cp){
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.cp = cp;
        memberInfo.accessFlags = (int) reader.readUint16();
        memberInfo.nameIndex = (int) reader.readUint16();
//        System.out.println("name_index "+((ConstantUTF8Info)cp[memberInfo.nameIndex]).string);
        memberInfo.desceiptorIndex = (int) reader.readUint16();
//        System.out.println("descriptor_index "+((ConstantUTF8Info)cp[memberInfo.desceiptorIndex]).string);
        memberInfo.attributes = new AttributeInfoParser().readAttributes(reader,cp);
        return memberInfo;
    }

    public String name(MemberInfo info){
        return ((ConstantUTF8Info)info.cp[info.nameIndex]).string;
    }

    public String descriptor(MemberInfo info){
        return ((ConstantUTF8Info)info.cp[info.desceiptorIndex]).string;
    }
}
