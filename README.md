# mybatis-plus代码生成器使用说明
## 添加依赖
mybatis-plus生成器和freemarker模板引擎
```xml
<!--mybatis-plus代码生成器-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.4.1</version>
    <scope>provided</scope>
</dependency>
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.31</version>
    <scope>provided</scope>
</dependency>
<!--mybatis-plus代码生成器-->
```
## 复制java类
`MybatisPlusGenerator.java`类复制到项目

## 复制template文件夹
将`template`文件夹复制到目标项目`resources`目录下

## 添加配置项
代码最前面配置区按需填写，后面代码可以折叠

## 运行java类