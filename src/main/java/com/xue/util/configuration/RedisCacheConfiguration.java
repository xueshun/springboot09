package com.xue.util.configuration;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis 自定义缓存管理器
 * @author xueshun
 *
 */
@Configuration
public class RedisCacheConfiguration {
	
	/**
	 * 自定义缓存管理
	 * @param redisTemplate
	 * @return
	 */
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		//设置默认的过期时间
		cacheManager.setDefaultExpiration(20);
		Map<String,Long> expires = new HashMap<String,Long>();
		
		//单独设置
		expires.put("roncooCache", 200L);
		cacheManager.setExpires(expires);
		return cacheManager;
	}
	
	/**
	 * 自定义Key,
	 * 此方法将会根据类名+方法名+所有参数的值生成唯一的一个Key，
	 * 即使@Cache中的value属性一样，key也不会一样
	 * @return
	 */
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}
}
