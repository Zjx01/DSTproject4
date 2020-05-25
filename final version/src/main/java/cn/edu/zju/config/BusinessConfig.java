
package cn.edu.zju.config;
 
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 
/**
 * Created by Shower on 2017/4/1 0001.
 */
@Configuration
@ComponentScan("cn.edu.zju")
@EnableWebMvc
public class BusinessConfig {}

