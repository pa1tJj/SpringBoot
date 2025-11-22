package com.jone.spring.spring_to_go.ioc.v1scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//class này là nơi khai báo các object dependency của riêng ta
//và gửi cho spring container giữ
//cũng là nơi khai báo các thông tin về các dependency khác ma ta không tự tạo
//class này là nơi lưu giữ các thông tin về các dependency mà ta nhờ spring quản lí giúp
//các object dependency new PdfGenerator(), new ConstractService(), new Repository() sẽ được khai báo ở class này

//những object dependency trong Spring sẽ gọi là các Bean
@Configuration //tương đương @SpringBootApplication khi chơi SpringBoot
@ComponentScan("com.jone.spring.spring_to_go.ioc.v1scan") // SCAN tất cả cái package này, class nào có @Component, @Serice, @Repository, @Controller... --> thì new 
                                                          //chúng nó - gọi là bean
@ComponentScan(basePackages = {"com.jone.spring.spring_to_go.ioc.v1scansf", "dhakfhads", "fkkfsdafk"})// quét nhiều package khác nhau
public class AppConfig {

}
