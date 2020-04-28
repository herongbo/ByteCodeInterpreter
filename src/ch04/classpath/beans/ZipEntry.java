package ch04.classpath.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipInputStream;

public class ZipEntry implements Entry {

    public String absDir;

    public ZipEntry(String path) {
        File file = new File(path);
        if (!file.exists()) {
            new FileNotFoundException();
        }
        absDir = file.getAbsolutePath();
        System.out.println("absdir......" + absDir);
    }

    /**
     * 返回指定的文件即可！
     *
     * @param className
     * @return
     * @throws IOException
     */
    @Override
    public byte[] readClass(String className) {
        String filePath = absDir;
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(filePath));
            java.util.zip.ZipEntry fentry = null;
            while ((fentry = zis.getNextEntry()) != null) {
                if (fentry.getName().equals(className + ".class")) {
                    System.out.println("find class in " + filePath);
                    return zis.readAllBytes();
                }
            }
        } catch (IOException e) {

        }
        return null;
    }

    @Override
    public String toString() {
        return absDir;
    }
}
