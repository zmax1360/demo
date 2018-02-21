package demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main( String[] args ) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    CommandLineRunner init( CustomerRepository r) {
        return args -> Arrays
                .stream(
                        ("Mark,Fisher;Scott,Frederick;Brian,Dussault;"
                                + "Josh,Long;Kenny,Bastani;Dave,Syer;Spencer,Gibb").split(";"))
                .map(n -> n.split(",")).map(tpl -> r.save(new Customer(tpl[0], tpl[1])))
                .forEach(System.out::println);
    }
}
