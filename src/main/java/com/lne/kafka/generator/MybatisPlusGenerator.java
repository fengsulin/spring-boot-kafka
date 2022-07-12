package com.lne.kafka.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://10.8.18.115:30336/operation_platform?useSSL=false"
                , "root"
                , "Rzz$K*LMLoQY")
                .globalConfig(builder -> {
                    builder.author("fengsulin") // 设置作者
                            .outputDir("D:\\Projects\\ServerProjects\\spring-boot-kafka\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.lne.kafka") // 设置父包名
                            .moduleName("dao") // 设置父包模块名
                            .entity("entity")
                            .service("service")
                            .service("service.impl")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\Projects\\ServerProjects\\spring-boot-kafka\\src\\main\\resources\\mappers")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(getTables("all")) // 设置需要生成的表名(all)
                            ; // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
