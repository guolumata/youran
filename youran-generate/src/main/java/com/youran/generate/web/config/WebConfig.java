package com.youran.generate.web.config;

import com.youran.common.xss.JacksonXssDeserializer;
import com.youran.common.xss.WebXSSFilter;
import com.youran.generate.config.GenerateProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title:web配置</p>
 * <p>Description:</p>
 * @author: cbb
 * @date: 2018/2/11
 */
@Configuration
public class WebConfig {


    /**
     * 防止通过parameter传入XSS脚本
     * @return
     */
    @Bean
    public FilterRegistrationBean webXSSFilterBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        WebXSSFilter filter = new WebXSSFilter();
        registrationBean.setFilter(filter);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

    /**
     * 防止通过body传入XSS脚本
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonXssCustomizer(){
        return jacksonObjectMapperBuilder ->
            jacksonObjectMapperBuilder.deserializerByType(String.class,new JacksonXssDeserializer());
    }

    /**
     * security配置
     */
    @Configuration
    public static class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

        @Autowired
        private GenerateProperties generateProperties;

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            if(generateProperties.isSecurityEnabled()){
                http.csrf().disable()
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().and()
                    .httpBasic();
            }else{
                http.csrf().disable().authorizeRequests().anyRequest().permitAll();
            }
        }
    }

}
