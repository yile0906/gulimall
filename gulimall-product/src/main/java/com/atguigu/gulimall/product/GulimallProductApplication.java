package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 整合Mybatis-plus
 * 1.引入依赖
 *         <dependency>
 *             <groupId>com.baomidou</groupId>
 *             <artifactId>mybatis-plus-boot-starter</artifactId>
 *             <version>3.2.0</version>
 *         </dependency>
 *2.配置
 *  1）配置数据源
 *      1.1）导入驱动
 *        <dependency>
 *             <groupId>mysql</groupId>
 *             <artifactId>mysql-connector-java</artifactId>
 *             <version>8.0.17</version>
 *         </dependency>
 *         在application.yml配置
 *       1.2）配置mybatis-plus;
 *          1.使用MapperScan
 *
 *
 * * 3、JSR303  数据校验
 *  *   1）、给Bean添加校验注解:javax.validation.constraints，并定义自己的message提示
 *  *   2)、开启校验功能@Valid
 *  *      效果：校验错误以后会有默认的响应；
 *  *   3）、给校验的bean后紧跟一个BindingResult，就可以获取到校验的结果
 *  *   4）、分组校验（多场景的复杂校验）
 *  *         1)、	@NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
 *  *          给校验注解标注什么情况需要进行校验
 *  *         2）、@Validated({AddGroup.class})
 *  *         3)、默认没有指定分组的校验注解@NotBlank，在分组校验情况@Validated({AddGroup.class})下不生效，只会在@Validated生效；
 *  *
 *  *   5）、自定义校验
 *  *      1）、编写一个自定义的校验注解
 *  *      2）、编写一个自定义的校验器 实现ConstraintValidator接口（需要导入validation-api jar包）
 *  *      3）、关联自定义的校验器和自定义的校验注解
 *          *      @Documented
 *          * @Constraint(validatedBy = { ListValueConstraintValidator.class【可以指定多个不同的校验器，适配不同类型的校验】 })
 *          * @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
 *          * @Retention(RUNTIME)
 *          * public @interface ListValue {
 *  *
 *  * 4、统一的异常处理
 *  * @ControllerAdvice
 *  *  1）、编写异常处理类，使用@ControllerAdvice。
 *  *  2）、使用@ExceptionHandler标注方法可以处理的异常。
 *  */
@MapperScan("com.atguigu.gulimall.product.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
