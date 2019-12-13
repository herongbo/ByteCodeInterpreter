package ch03.classfile.beans;

public class ConstantInfo {
    int tag;
    int[] info;
    public ConstantInfo(int tag, ConstantPool cp){
        this.tag = tag;
    }
}

