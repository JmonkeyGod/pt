package com.ai.oidd.pt;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-03-28
 */
@SpringBootApplication
@MapperScan("com.ai.oidd.pt.mapper")
@EnableSwagger2Doc
public class PtBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(PtBootstrap.class, args);
    }
}
