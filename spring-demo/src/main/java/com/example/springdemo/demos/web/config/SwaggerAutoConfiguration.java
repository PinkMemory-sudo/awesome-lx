package com.example.springdemo.demos.web.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.LinkedList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerAutoConfiguration implements BeanFactoryAware {

    private BeanFactory beanFactory;
    @Bean
    @ConditionalOnMissingBean
    public List<Docket> createRestApi(){
        ConfigurableBeanFactory configurableBeanFactory =
                (ConfigurableBeanFactory) beanFactory;
        List<Docket> docketList = new LinkedList<>();


            Docket docket = new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .groupName("groupName")
                    .select()
                    //为当前包路径
                    .apis(RequestHandlerSelectors.basePackage("com.example.springdemo.demos.web.controller"))
                    .build();
            configurableBeanFactory.registerSingleton("docket", docket);
            docketList.add(docket);
        return docketList;
    }

    //构建 api文档的详细信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("spring-demo")
                //创建人
                .contact(new Contact("pk",
                        "http://localhost:8080/doc.html",
                        "pk@lx.com"))
                //版本号
                .version("1.1.0Release")
                //描述
                .description("SpringConcept")
                .build();
    }

    @Override
    public void setBeanFactory(@NonNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}