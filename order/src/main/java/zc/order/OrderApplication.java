package zc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@author: zou
 *@desc:
 *@date:2021/4/8-9:58
 *@CLassName:OrderApplication
  */
@SpringBootApplication
@EnableFeignClients
//@EnableDiscoveryClient
public class OrderApplication {


    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }


}
