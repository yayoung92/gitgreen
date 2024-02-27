package org.example.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@ComponentScan("org.example.member")
@Configuration
@ComponentScan({"org.example.member","org.example.component"})
public class MyConf {

}
