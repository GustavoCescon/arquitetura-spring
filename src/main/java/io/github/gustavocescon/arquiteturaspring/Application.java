package io.github.gustavocescon.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		SpringApplicationBuilder builder =
				new SpringApplicationBuilder(Application.class);
		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("producao", "homologacao");

		//builder.lazyInitialization(true);

		builder.run(args);


		//contexto da aplicação ja iniciada
		ApplicationContext  applicationContext = builder.context();
		//var produtoRepository = applicationContext.getBean("produtoRepository");


		ConfigurableEnvironment environment = (ConfigurableEnvironment) applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");

		System.out.println(applicationName);

		ExemploValue exemplo = applicationContext.getBean(ExemploValue.class);
		exemplo.imprimirVariavel();

		AppProperties properties = applicationContext.getBean(AppProperties.class);
		System.out.println(properties.getValor1());
	}

}
