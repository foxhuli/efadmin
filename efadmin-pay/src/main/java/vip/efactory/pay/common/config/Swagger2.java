package vip.efactory.pay.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket webApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("支付后台API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("vip.efactory.pay.web"))
                .paths(PathSelectors.any()).build();
    }

    @Bean
    public Docket alipayApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("支付宝API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("vip.efactory.pay.ali"))
                .paths(PathSelectors.any()).build();
    }

    @Bean
    public Docket weixinpayApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("微信API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("vip.efactory.pay.wx"))
                .paths(PathSelectors.any()).build();
    }

    @Bean
    public Docket unionpayApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("银联API接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("vip.efactory.pay.union"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("支付系统")
                .description("微信、支付宝、银联支付服务")
                .termsOfServiceUrl("http://pay.efactory.vip")
                .contact(new Contact("科帮网 ", "http://pay.efactory.vip", "1797890817@qq.com"))
                .version("1.0").build();
    }

}