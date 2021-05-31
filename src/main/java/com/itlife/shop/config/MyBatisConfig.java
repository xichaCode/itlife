package com.itlife.shop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: itlife
 * @description: 配置需要动态生成mapper的接口路径
 * @author: He.Jian-hj
 * @create: 2021-05-25 00:05
 **/
@Configuration
@MapperScan("com.itlife.shop.mgb.mapper")
public class MyBatisConfig {

}
