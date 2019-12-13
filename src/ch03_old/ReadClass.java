package ch03_old;

import ch03_old.entry.*;

import java.io.File;

/**
 * 寻找class文件
 * newEntry函数根据参数创建不同类型的Entiry实例
 * Entry接口有四个实现，分别是DirEntry，ZipEntry，CompositeEntry和WildcardEntry
 */
public class ReadClass {
    // 分配多个路径的分隔符
    public static final String pathListSparator = File.pathSeparator;

    public static Entry newEntry(String path) {
        System.out.println("path......  " + path);
        if (path.endsWith(pathListSparator)) {
            return new CompositeEntry(path);
        }
        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }
        if (path.endsWith(".jar") || path.endsWith(".JAR")
                || path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        }
        return new DirEntiry(path);
    }
}
