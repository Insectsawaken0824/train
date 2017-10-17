package train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot会自动扫描@SpringBootApplication所在类的同级包以及下级包里的Bean
 * @SpringBootApplication 组合了@EnableAutoConfiguration让spring boot根据类路径中的jar包依赖为
 * 当前项目进行自动配置
 */
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})关闭特定的自动配置
@SpringBootApplication//是spring boot项目的核心注解,主要目的是开启自动配置.
public class TrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainApplication.class, args);
	}
}
