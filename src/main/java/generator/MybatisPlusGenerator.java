package generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * mybatis-plus代码生成器
 *
 * @author lichen
 * @since 2020-09-14 15:21
 */
public class MybatisPlusGenerator {

    /**---------------------------配置区-----------------------------**/

    /**
     * 作者
     */
    private static String author = "lichen24";

    /**
     * 父级包名称
     */
    private static String parentName = "com.ecredit.ecreditcustomer";

    /**
     * 模块名称(非必填)
     */
    private static String moduleName = "";

    /**
     * 父级实体类
     */
    private static String superEntityClass = "com.ecredit.ecreditcustomer.entity.BaseEntity";

    /**
     * 父级实体列
     */
    private static String[] superEntityColumns = {"create_time","update_time"};

    /**
     * 主键策略
     */
    private static IdType idType = IdType.ASSIGN_ID;

    /**
     * 是否使用restcontroller注解
     */
    private static boolean restController = true;

    /**
     * jdbc url地址
     */
    private static String jdbcMysqlUrl = "jdbc:mysql://10.103.250.77:3306/db_ecredit_dev?useSSL=false&useUnicode=true&characterEncoding=utf-8";

    /**
     * 驱动名称
     * 旧版 com.mysql.jdbc.Driver，新版 com.mysql.cj.jdbc.Driver
     */
    private static String jdbcDriverName = "com.mysql.jdbc.Driver";

    /**
     * 用户名
     */
    private static String jdbcUsername = "root";

    /**
     * 密码
     */
    private static String jdbcPassword = "Lxjrtest123!@#";

    /**---------------------------配置区-----------------------------**/


    //region 逻辑代码

    /**
     * 表名
     */
    private static String[] tableNames = null;

    /**
     * 表前缀
     */
    private static String tablePrefix = "";


    public static void main(String[] args) {
        String tableName = scanner("表名，多个英文逗号分割");
        tablePrefix = scanner("表前缀(无前缀直接回车)");
        checkInput(tableName);
        autoGenerator();
    }

    /**
     * 检查输入项
     */
    private static void checkInput(String tableName) {
        if (StringUtils.isBlank(tableName)) {
            throw new MybatisPlusException("表名不能为空");
        }
        tableNames = tableName.split(",");
    }

    /**
     * 自动生成代码
     */
    private static void autoGenerator() {
        AutoGenerator generator = new AutoGenerator();
        //全局配置
        generator.setGlobalConfig(getGlobalConfig());
        //数据源配置
        generator.setDataSource(getDataSourceConfig());
        //包配置
        generator.setPackageInfo(getPackageConfig());
        //表配置
        generator.setStrategy(getStrategyConfig(tableNames, tablePrefix));
        //其他注入配置
        generator.setCfg(getInjectionConfig(generator.getPackageInfo()));
        //模板配置
        generator.setTemplate(getTemplateConfig());
        //设置模板引擎（默认）
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

    /**
     * 获取注入配置
     *
     * @return
     * @param packageInfo
     */
    private static InjectionConfig getInjectionConfig(PackageConfig packageInfo) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                //初始化注入map
                Map map = new HashMap();
                map.put("dateTime", getDateTime());
                setMap(map);
            }
        };
        //自定义是否创建文件（Entity默认覆盖，其余文件通过配置控制）
        injectionConfig.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                //如果是Entity则直接返回true表示写文件
                if (fileType == FileType.ENTITY) {
                    return true;
                }
                //否则先判断文件是否存在
                File file = new File(filePath);
                boolean exist = file.exists();
                if (!exist) {
                    file.getParentFile().mkdirs();
                }
                //文件不存在或者全局配置的fileOverride为true才写文件
                return !exist || configBuilder.getGlobalConfig().isFileOverride();
            }
        });
        //自定义模板输出
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        String xmlTemplatePath = "/templates/mapper.xml.ftl";
        fileOutConfigList.add(new FileOutConfig(xmlTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String projectPath = getProjectPath();
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + packageInfo.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);

        return injectionConfig;
    }

    private static String getDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDate.format(formatter);
    }


    /**
     * 获取表配置
     * @param tableNames
     * @param tablePrefix
     * @return
     */
    private static StrategyConfig getStrategyConfig(String[] tableNames, String tablePrefix) {
        return new StrategyConfig()
                //表名策略
                .setNaming(NamingStrategy.underline_to_camel)
                //列名策略
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //表前缀
                .setTablePrefix(tablePrefix)
                //包含哪些表
                .setInclude(tableNames)
                //父级entity全类名
                .setSuperEntityClass(superEntityClass)
                // 父级entity包含的列，通过逗号分隔
                .setSuperEntityColumns(superEntityColumns)
                //是否生成restController
                .setRestControllerStyle(restController)
                //controller名称类名横杆
                .setControllerMappingHyphenStyle(true)
                //实体表字段
                .setEntityTableFieldAnnotationEnable(true)
                //实体Lombok注解
                .setEntityLombokModel(true)
                //实体链式调用
                .setChainModel(true);
    }

    /**
     * 获取包配置
     * @return
     */
    private static PackageConfig getPackageConfig() {
        return new PackageConfig()
                //父级包名称
                .setParent(parentName)
                //模块名称
                .setModuleName(moduleName)
                //service包名称
                .setService("service")
                //service实现类包名称
                .setServiceImpl("service.impl")
                //controller包名称
                .setController("controller")
                //entity包名称
                .setEntity("entity")
                //mapper包名称
                .setMapper("mapper");
    }

    /**
     * 获取数据源配置
     *
     * @return
     */
    private static DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                //jdbc地址
                .setUrl(jdbcMysqlUrl)
                //驱动名称
                .setDriverName(jdbcDriverName)
                //用户名
                .setUsername(jdbcUsername)
                //密码
                .setPassword(jdbcPassword)
                ;
    }

    /**
     * 获取全局配置
     *
     * @return
     */
    private static GlobalConfig getGlobalConfig() {
        return new GlobalConfig()
                //输出目录
                .setOutputDir(getFilePath())
                //作者
                .setAuthor(author)
                //mapper名称
                .setMapperName("%sMapper")
                //xml名称
                .setXmlName("%sMapper")
                //service名称
                .setServiceName("%sService")
                //service实现类名称
                .setServiceImplName("%sServiceImpl")
                //controller名称
                .setControllerName("%sController")
                //是否打开文件夹
                .setOpen(false)
                //id策略
                .setIdType(idType)
                //swagger设置
                .setSwagger2(true)
                ;
    }

    /**
     * 获取文件输出目录
     *
     * @return
     */
    private static String getFilePath() {
        String filePath = "";
        String projectPath = "";
        projectPath = getProjectPath();
        filePath = projectPath + File.separator + moduleName + File.separator + "src/main/java/";
        return filePath;
    }

    /**
     * 获取项目路径
     *
     * @return
     */
    private static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    /**
     * 获取模板配置
     *
     * @return
     */
    private static TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                //controller 控制器模板
                .setController("templates/controller.java")
                //Service 类模板
                .setService("templates/service.java")
                //Service impl 实现类模板
                .setServiceImpl("templates/serviceImpl.java")
                //Java 实体类模板
                .setEntity("templates/entity.java")
                //mapper 模板
                .setMapper("templates/mapper.java")
                //mapper xml 模板，通过自定义模板生成
                .setXml(null);
    }

    /**
     * 输入输出
     * @param tip
     * @return
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("请输入 " + tip + " : ");
        System.out.println(sb.toString());
        String input = scanner.nextLine();
        if (StringUtils.isNotBlank(input)) {
            return input;
        }
        return "";
    }
    //endregion
}
