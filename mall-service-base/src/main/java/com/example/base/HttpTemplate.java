package com.example.base;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
@DependsOn("springBeanUtil")
@Slf4j
public class HttpTemplate {

    private static final RestTemplate restTemplate;

    static {
        restTemplate = SpringBeanUtil.getBean(RestTemplate.class);
    }

    @SuppressWarnings("unchecked")
    public static <T> ApiResponse postForJson(String url, T t) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        String param = JSON.toJSONString(t);
        HttpEntity<String> formEntity = new HttpEntity<>(param, headers);

        log.warn("url:{},param:{}", url, param);
        ResponseEntity<ApiResponse> responseEntity;
        try {
            responseEntity = restTemplate.postForEntity(url, formEntity, ApiResponse.class);
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            throw new BizException(ApiResponseEnum.FAIL, String.format("接口[%s]调用失败:%s", url, e.getMessage()));
        }
        if (HttpStatus.OK != responseEntity.getStatusCode()) {
            throw new BizException(ApiResponseEnum.FAIL, "http调用失败");
        }
        ApiResponse entityBody = responseEntity.getBody();
        if (entityBody == null || entityBody.getCode() != ApiResponseEnum.SUCCESS.getCode()) {
            throw new BizException(ApiResponseEnum.FAIL, "http调用业务响应失败");
        }
        return entityBody;
    }

}
