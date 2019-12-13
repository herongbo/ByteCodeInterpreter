## 本章节实现Java命令行工具
### Java命令有如下4种形式；
```aidl
java [-options] class [args]
java [-options] -jar jarfile [args]
javaw [-options] class [args]
javaw [-options] -jar jarfile [args]
```
可以向java命令传递三组参数：选项、主类名（或者JAR文件名）和main（）方法参数。选项与减号（-）开头，通常，第一个非选项参数给出主类的完全限定名。但是如果用于提供了一个-jar选项，则第一个非选项参数表示JAR文件名，java命令必须从这个JAR文件中寻找主类

选项可分为两类：标准选项和非标准选项。标准选项不计较稳定，不会被轻易变动，非标准选项一-X开头，很厚可能会在未来的版本中变化。非标砖选项中共有一部分是高级选项，以-XX开头，下面列出了java命令常用的选项及用途。
| 选项               | 用途                   |
| ------------------ | ---------------------- |
| -verson            | 输出版本信息，然后退出 |
| -?/-help           | 输出帮助信息，然后退出 |
| -cp/-classpath     | 指定用户类路径         |
| -Dproperty = value | 设置Java系统属性       |
| -Xms<size>         | 设置初始堆空间大小     |
| -Xmx<siez>         | 设置最大堆空间大小     |
| -Xss<size>         | 设置线程栈空间大小     |

运行示例：java -cp fo/bar MyApp arg1 arg2

