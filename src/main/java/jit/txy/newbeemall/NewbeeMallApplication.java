package jit.txy.newbeemall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("jit.txy.newbeemall.dao")
@SpringBootApplication
public class NewbeeMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewbeeMallApplication.class, args);
    }

}
