import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.sun.javafx.PlatformUtil;
import util.PropertiesUtil;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * mybatis-plus代码生成器
 * @author lichen
 * @since 2020-09-14 15:21
 */
public class MybatisPlusGenerator {

    public static final String welcome = "##欢迎使用mybatis-plus代码生成器##\n" +
            "【jar模式】使用前请配置同级目录下config.properties文件\n" +
            "【project模式】使用前请配置同级目录下config.properties文件\n" +
            "生成器默认采用覆盖策略，建议生成目录在项目工程外部，防止已有逻辑被覆盖！\n" +
            "##-----------------------------------------##";

    public static void main(String[] args) {
        System.out.println(welcome);
        String moduleName = scanner("模块名");
        String[] tableName = scanner("表名，多个英文逗号分割").split(",");
        String tablePrefix = scanner("表前缀(无前缀输入#)").replaceAll("#", "");
        autoGenerator(moduleName, tableName, tablePrefix);
    }

    private static void loadConfig() {
    }

    public static void autoGenerator(String moduleName, String[] tableName, String tablePrefix) {
        new AutoGenerator()
                .setGlobalConfig(getGlobalConfig())
                .setDataSource(getDataSourceConfig())
                .setPackageInfo(getPackageConfig(moduleName))
                .setStrategy(getStrategyConfig(tableName, tablePrefix))
                .setCfg(getInjectionConfig(moduleName))
                .setTemplate(getTemplateConfig())
                .execute();
    }

    private static String getDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDate.format(formatter);
    }

    private static InjectionConfig getInjectionConfig(final String moduleName) {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map map = new HashMap();
                map.put("dateTime", getDateTime());
                setMap(map);
                final String projectPath = System.getProperty("user.dir");
                List<FileOutConfig> fileOutConfigList = new ArrayList<FileOutConfig>();
                // 自定义配置会被优先输出
                // fileOutConfigList.add(new FileOutConfig("/templates/mapper.xml.vm") {
                //     @Override
                //     public String outputFile(TableInfo tableInfo) {
                //         // 自定义输出文件名，如果entity设置了前后缀，此次注意xml的名称也会跟着发生变化
                //         return projectPath + "/src/main/resources/mapper/" +
                //                 moduleName + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                //     }
                // });
                setFileOutConfigList(fileOutConfigList);
            }
        };
    }


    private static StrategyConfig getStrategyConfig(String[] tableName, String tablePrefix) {
        return new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableName)
                .setRestControllerStyle(Boolean.valueOf(PropertiesUtil.get("rest_controller_style")))
                .setControllerMappingHyphenStyle(true)
                .setEntityTableFieldAnnotationEnable(true)
                .setTablePrefix(tablePrefix)
                .setEntityLombokModel(true)
                .setChainModel(true);
    }

    private static PackageConfig getPackageConfig(String moduleName) {
        return new PackageConfig()
                .setParent(PropertiesUtil.get("parent_name"))
                .setModuleName(moduleName)
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller")
                .setEntity("entity")
                .setMapper("mapper");
    }

    private static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                .setUrl(PropertiesUtil.get("jdbc_mysql_url"))
                .setDriverName(PropertiesUtil.get("jdbc_driver_name"))
                .setUsername(PropertiesUtil.get("jdbc_username"))
                .setPassword(PropertiesUtil.get("jdbc_password"));
    }

    private static GlobalConfig getGlobalConfig() {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + File.separator + PropertiesUtil.get("modular_name") + File.separator + PropertiesUtil.get("src_main_java");
        return new GlobalConfig()
                .setOutputDir(filePath)
                .setDateType(DateType.TIME_PACK)
                .setIdType(IdType.AUTO)
                .setAuthor(PropertiesUtil.get("author"))
                .setBaseColumnList(false)
                .setSwagger2(false)
                .setEnableCache(false)
                .setBaseResultMap(false)
                .setOpen(true);
    }

    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                .setController("templates/controller.java")
                .setService("templates/service.java")
                .setServiceImpl("templates/serviceImpl.java")
                .setEntity("templates/entity.java")
                .setMapper("templates/mapper.java")
                .setXml(null);
    }

    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("请输入 " + tip + " : ");
        System.out.println(sb.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的 " + tip + "！");
    }
}
