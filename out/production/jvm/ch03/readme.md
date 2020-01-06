## 第二章 搜索class文件

Java虚拟机按照搜索的先后顺序，类路径可以分为一下3个部分
- 启动类路径(bootstrap classpath)
- 拓展类路径(extension claspath)
- 用户类路径(user classpath)

启动类默认对应jre\lib目录，Java标准库(大部分在rt.jar里)位于该路径。拓展类，以及第三方类库为位于用户类路径可以通过-Xbootclasspath选项修改启动类令

用户类路径的默认值是当前目录，也就是'.'。可以设置CLASSPATH环境变量来修改用户类路径，但是这样做不够灵活，所以不推荐使用。更好的办法是该java命令传递-classpath
(简写为-cp)选项，-classpath/-cp选项的优先级更高，可以覆盖CLASSPATH环境变量设置

```
-classpath/-cp选项既可以指定目录，也可以指定JAR文件或者ZIP文件，如下
java -cp path\to\classes ...
java -cp path\to\lib.jar ...
java -cp path\tp\lib.zip ..
还可以同时指定多个目录或文件，用分隔符分开即可
windows下
java -cp path\to\classes;lib\a.jar;lib\c.zip
```