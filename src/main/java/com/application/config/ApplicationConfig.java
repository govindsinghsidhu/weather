package com.application.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.CachingHttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.application.common.ApplicationDataRepository;

@Configuration
public class ApplicationConfig {

	@Bean
	public ApplicationDataRepository ApplicationDataRepositoryBean() {
		ApplicationDataRepository applicationDataRepository =new ApplicationDataRepository();
		applicationDataRepository.init();
		return applicationDataRepository;
	}
	@Bean
	  public RestTemplate restTemplate() {
	    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
	    RestTemplate restTemplate = new RestTemplate(requestFactory);
	    restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient())));
	    return restTemplate;
	  }

	  @Bean
	  public HttpClient httpClient() {
	    return CachingHttpClientBuilder
	      .create()
	      .setCacheConfig(cacheConfig())
	      .build();
	  }

	  @Bean
	  public CacheConfig cacheConfig() {
	    return CacheConfig
	      .custom()
	      .setMaxObjectSize(500000) 
	      .setMaxCacheEntries(2000)
	      .setNeverCacheHTTP10ResponsesWithQueryString(false)
	      .build();
	  }
}
