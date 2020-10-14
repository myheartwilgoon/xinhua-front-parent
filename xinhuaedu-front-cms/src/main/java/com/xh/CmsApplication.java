package com.xh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: xinhua-framework-parent
 * @description:
 * @author: wys
 * @create: 2020-10-05 17:38
 */
@SpringBootApplication
@MapperScan("com.xh.cms.mapper")
public class CmsApplication {
    	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}
}
