package org.hanke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application 
{
    public static void main( String[] args ) throws Exception
    {
        SpringApplication.run(Application.class, args);
    }
}
