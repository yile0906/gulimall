package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import com.atguigu.gulimall.member.entity.MemberEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是声明式的远程调用
 *  1.引入依赖
 *      <dependency>
 *             <groupId>org.springframework.cloud</groupId>
 *             <artifactId>spring-cloud-starter-openfeign</artifactId>
 *         </dependency>
 *  2.调用方启动类加上注解@EnableFeignClients
 *  3.定义接口并且指定需要调用的应用名称 application.name      例：@FeignClient("gulimall-coupon")
 *  4.调用的方法的全限定名和路径(直接复制就行)   例子：@RequestMapping("/coupon/coupon/member/list")
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();

}
