package ch04.classpath;

import ch04.classpath.beans.*;
import ch04.utils.Log;

/**
 * 寻找class文件
 * newEntry函数根据参数创建不同类型的Entiry实例
 * Entry接口有四个实现，分别是DirEntry，ZipEntry，CompositeEntry和WildcardEntry
 */
public class ReadClass {
    // 分配多个路径的分隔符
    public static final String pathListSparator = ";";

    public static Entry newEntry(String path) {

        System.out.println("create entry from path......  " + path);

        // 包含分隔符，需要逐个解析
        if (path.endsWith(pathListSparator)) {
            Log.log("create");
            return new CompositeEntry(path);
        }

        // 以*结尾的通配符路径，遍历并根据后缀选出jar文件，需要跳过子目录
        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }

        // jar包或zip格式的类
        if (path.endsWith(".jar") || path.endsWith(".JAR")
                || path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        }

        // 目录形式的类路径
        return new DirEntiry(path);
    }
}
