package com.creativearts.bigdata;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author:zhoubh
 * @create:2018-11-19
 **/
@Configuration
@ImportResource(locations={"classpath:kafka-consumer.xml"})
public class ConfigClass {
}
