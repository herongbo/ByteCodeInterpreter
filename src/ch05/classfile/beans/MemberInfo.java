package ch05.classfile.beans;

import ch05.classfile.beans.impl.CodeAttribute;
import ch05.classfile.beans.impl.ConstantUTF8Info;

// 同时用于解析Field 和 Method
public class MemberInfo {
    public ConstantInfo[] cp;
    public int accessFlags;
    public int nameIndex;
    public int desceiptorIndex;
    public AttributeInfo[] attributes;

    public String Name(){
        return ((ConstantUTF8Info)cp[nameIndex]).string;
    }

    public String Descriptor(){
        return  ((ConstantUTF8Info)cp[desceiptorIndex]).string;
    }
    /**
     * 对于Method字段
     * 找到Code字段
     * ?这个方法目前只能返回第一个方法（构造方法）
     * @return
     */
    public CodeAttribute codeAttribute(){
        for (AttributeInfo attrInfo : attributes) {
            System.out.println("attribute type "+attrInfo.getClass().getSimpleName());
            switch (attrInfo.getClass().getSimpleName()){
                case "CodeAttribute":
                    return (CodeAttribute)attrInfo;
            }
        }
        System.err.println("code attribute error");
        return null;
    }
}
