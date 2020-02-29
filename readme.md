## 参考《自己动手写JAVA虚拟机》

### 用Java实现的JAVA解释器

### ch01命令行工具：
通过命令行加载class、设置Jre、Classpath、help
### ch02查找class文件
从zip、jar、路径中加载指定class文件
### ch03解析class文件
解析class文件
```aidl
String[] cmdArgs = {"java", "-cp", "C:\\Users\\JDUSER\\Documents\\coding\\mycode\\workspace\\xf\\bin\\xf", "Test"};
```
![demo](/img/demo.png)

```java
    更改Main.java启动程序
```