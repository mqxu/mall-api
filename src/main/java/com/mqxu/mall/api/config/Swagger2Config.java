package com.mqxu.mall.api.config;

import com.mqxu.mall.api.entity.MallUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mqxu
 * @description: swagger配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket api() {

        ParameterBuilder tokenParam = new ParameterBuilder();
        List<Parameter> swaggerParams = new ArrayList<Parameter>();
        tokenParam.name("token").description("用户认证信息")
                .modelRef(new ModelRef("string")).parameterType("header")
                //header中的ticket参数非必填，传空也可以
                .required(false).build();
        //根据每个方法名也知道当前方法在设置什么参数
        swaggerParams.add(tokenParam.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .ignoredParameterTypes(MallUser.class)
                .select()
                // 修改为自己的 controller 包路径
                .apis(RequestHandlerSelectors.basePackage("com.mqxu.mall.api"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(swaggerParams);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("楼楼商城接口文档")
                .description("swagger接口文档")
                .version("2.0")
                .build();
    }
}