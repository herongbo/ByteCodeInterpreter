package ch04.classpath.beans;

import ch04.classpath.ReadClass;

import java.util.ArrayList;
import java.util.List;

public class CompositeEntry implements Entry {
    String absDir;
    String pathListSeparator = ";"; //类名分隔符

    // 里面存储的是所有要搜索的路径，保存成Entry的实体
    List<Entry> compositeEntry = new ArrayList<>();

    /**
     * 把一个路径按照 / 拆分，保存成一个list 的 Entry
     * 把路径列表按分隔符分成小路径 然后把每个小路径都转换成具体的Entry实体
     *
     * @param pathList
     */
    public CompositeEntry(String pathList) {
        absDir = pathList;
        //循环处理每一个需要的类名
        for (String string : pathList.split(pathListSeparator)) {
            Entry entry = ReadClass.newEntry(string);
            compositeEntry.add(entry);
        }
    }

    /**
     * 依次调用每一个子路径的readClass方法，如果成功读到class数据，返回数据即可，如果手机到错误信息，则继续，如果遍历完所有的子路径还没有找到class文件，则返回错误
     * <p>
     * 在所有的路径下寻找class文件
     *
     * @param className
     * @return
     */
    @Override
    public byte[] readClass(String className) {
        // 尝试在所有的路径下都找这个文件
        for (Entry entry : compositeEntry) {
            if (entry.readClass(className) != null) {
                return entry.readClass(className);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "";
        for (Entry entry : compositeEntry) {
            str += entry.toString() + pathListSeparator;
        }
        return str;
    }
}
