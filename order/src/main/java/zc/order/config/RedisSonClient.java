package zc.order.config;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author: zou
 * @desc:
 * @date:2021-04-19 19:56
 */
@Configuration
public class RedisSonClient {

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        //单机模式  依次设置redis地址和密码
        config.useSingleServer().
                setAddress("redis://localhost:6379");
        //设置编码
        config.setCodec(new StringCodec());
        return Redisson.create(config);
    }


}
