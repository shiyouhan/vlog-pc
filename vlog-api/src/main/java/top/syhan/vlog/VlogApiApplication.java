package top.syhan.vlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author apple
 */
@SpringBootApplication
@MapperScan("top.syhan.vlog.mapper")
public class VlogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VlogApiApplication.class, args);
    }

}
