package com.example.network;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class CodeGenerator {

    @Test
    void generate() {
        FastAutoGenerator
                // 数据源配置
                .create("jdbc:mysql://localhost:3306/network", "root", "dxshhmh")
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("eitan") // 设置作者
                            .outputDir(System.getProperty("user.dir") + "/src/main/java") // 指定输出目录
                            .commentDate("yyyy-MM-dd")   //注释日期
                            .disableOpenDir();   //禁止打开输出目录，默认:true
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.example") // 设置父包名
                            .moduleName("network") // 设置父包模块名
                            .entity("entity") // pojo 实体类包名,其它包名同理
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper1")); // 设置mapperXml生成路径
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("device_connections", "network_devices") // 设置需要生成的表名

                            // entity 策略配置
                            .entityBuilder().enableLombok().logicDeleteColumnName("deleted") //逻辑删除字段名
                            .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
                            .addTableFills(new Column("create_time", FieldFill.INSERT), new Column("modify_time", FieldFill.INSERT_UPDATE))   //添加表字段填充，"create_time"字段自动填充为插入时间，"modify_time"字段自动填充为插入修改时间
                            .enableTableFieldAnnotation()       // 开启生成实体时生成字段注解

                            // mapper 策略配置
                            .mapperBuilder().superClass(BaseMapper.class)   //设置父类
                            .formatMapperFileName("%sMapper")   //格式化 mapper 文件名称
                            .enableMapperAnnotation()       //开启 @Mapper 注解
                            .formatXmlFileName("%sXml") //格式化 Xml 文件名称 如 UserXml

                            // service 策略配置
                            .serviceBuilder().formatServiceFileName("%sService") // 如:UserService
                            .formatServiceImplFileName("%sServiceImpl") // 如:UserServiceImpl

                            // controller 策略配置
                            .controllerBuilder().formatFileName("%sController") // 如 UserController
                            .enableRestStyle();  //开启生成 @RestController 控制器

                })
                // 模板配置
                // .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                // 执行
                .execute();
    }

}
