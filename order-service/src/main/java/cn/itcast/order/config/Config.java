package cn.itcast.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    @LoadBalanced  // 表示将使用Ribbon拦截请求---LoadBalancerInterceptor
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 负载均衡策略
     * @return
     */
//    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
