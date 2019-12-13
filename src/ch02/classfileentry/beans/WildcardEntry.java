package ch02.classfileentry.beans;

import ch02.classfileentry.ReadClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WildcardEntry implements Entry {

    String absDir;
    String baseDir;
    List<Entry> compositeEntry = new ArrayList<>();

    public WildcardEntry(String path){
        //首先把路径末尾的星号去掉，得到BaseDir，然后遍历baseDir创建ZipEntry
        baseDir = path.substring(0,path.length()-1);
        File file = new File(baseDir);
        if(!file.exists()){
            new FileNotFoundException();
        }
        walkFn(baseDir);
    }

    public void walkFn(String baseDir){
        File file = new File(baseDir);
        // 在（函数中），根据后缀名选出JAR文件，并且？跳过子目录，通配符类路径不能帝国匹配子母线下的jar文件？
        for(File f:file.listFiles()){
            //全都是文件，不用考虑文件夹
            if(f.getName().endsWith(".jar")||f.getName().endsWith(".JAR")){
                Entry jarEntry = ReadClass.newEntry(f.getAbsolutePath());
                compositeEntry.add(jarEntry);
            }
        }
    }

    @Override
    public byte[] readClass(String className) {
        for(Entry jarEntry:compositeEntry){
            if(jarEntry.readClass(className)!=null){
                return jarEntry.readClass(className);
            }
        }
        return null;
    }
}
