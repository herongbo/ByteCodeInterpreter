package ch02.classfileentry.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DirEntiry implements Entry {
    /**
     * DirEntity需要保存一个基本的路径
     */
    String absDir;

    /**
     * 构造函数，检查路径是否合法，可能会产生FileNotFound异常
     *
     * @param path
     */
    public DirEntiry(String path) {
        System.out.println("setpath: "+path);
        File file = new File(path);
        if (!file.exists()) {
            new FileNotFoundException();
        }
        absDir = file.getAbsolutePath();
    }

    /**
     * 读取Class文件的内容到byte[]数组中
     *
     * @param className
     * @return
     */
    @Override
    public byte[] readClass(String className) {
        String filePath = absDir + File.separator + className;
        byte[] data = new byte[0];
        try {
            data = new FileInputStream(filePath+".class").readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 输出文件夹的绝对路径
     * @return
     */
    @Override
    public String toString() {
        return absDir;
    }
}
