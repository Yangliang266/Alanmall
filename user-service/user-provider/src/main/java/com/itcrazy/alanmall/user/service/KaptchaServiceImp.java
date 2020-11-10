package com.itcrazy.alanmall.user.service;

import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.user.IKaptchaService;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;
import com.itcrazy.alanmall.user.dal.entity.ImageResult;
import com.itcrazy.alanmall.user.dto.KaptchaCodeRequest;
import com.itcrazy.alanmall.user.dto.KaptchaCodeResponse;
import com.itcrazy.alanmall.user.utils.ExceptionProcessorUtils;
import com.itcrazy.alanmall.user.utils.VerifyCodeUtils;
import jdk.nashorn.internal.runtime.GlobalConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class KaptchaServiceImp implements IKaptchaService {
    @Autowired
    RedissonConfig redissonConfig;

    // 作为存储到redis中 kaptcha的key
    private final String KAPTCHA_UUID="kaptcha_uuid";

    @Override
    public KaptchaCodeResponse getKaptchaCode(KaptchaCodeRequest kaptchaCodeRequest) {
        log.info("Begin: KaptchaServiceImp.getKaptchaCode.request: " + kaptchaCodeRequest);
        KaptchaCodeResponse kaptchaCodeResponse = new KaptchaCodeResponse();
        try {
            // 1 获取图片验证码
            ImageResult capText = VerifyCodeUtils.VerifyCode(140, 43, 4);

            String uuid = UUID.randomUUID().toString();
            // 2.1 图片验证码 key 放入redis
            redissonConfig.setCache(KAPTCHA_UUID + uuid, capText.getCode()).expire(60, TimeUnit.SECONDS);

            // 3 返回reposnse包含的uuid imgresult msg code
            kaptchaCodeResponse.setUuid(uuid);
            kaptchaCodeResponse.setImageCode(capText.getImg());
            kaptchaCodeResponse.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
            kaptchaCodeResponse.setCode(SysRetCodeConstants.SUCCESS.getCode());
        } catch (Exception e) {
            log.error("Error: KaptchaServiceImpl.getKaptchaCode.Exception: "+e);
            ExceptionProcessorUtils.wrapperHandlerException(kaptchaCodeResponse,e);
        }

        log.info("End: KaptchaServiceImp.getKaptchaCode.response: " + kaptchaCodeResponse);
        return kaptchaCodeResponse;
    }

    @Override
    public KaptchaCodeResponse validateKaptcha(KaptchaCodeRequest kaptchaCodeRequest) {
        log.info("Begin: KaptchaServiceImp.validateKaptcha.request: " + kaptchaCodeRequest);
        kaptchaCodeRequest.requestCheck();
        KaptchaCodeResponse kaptchaCodeResponse = new KaptchaCodeResponse();
        try {
            // 1 从redis 中查找
            String redisKey = KAPTCHA_UUID + kaptchaCodeRequest.getUuid();
            String code = redissonConfig.getCache(redisKey);
            log.info("请求的redisKey={},请求的code={},从redis获得的code={}",redisKey,kaptchaCodeRequest.getCode(),code);
            // 2 判断code 是否与redis中的一样
            if (StringUtils.isNotBlank(code) && StringUtils.equalsIgnoreCase(kaptchaCodeRequest.getCode(),code)) {
                kaptchaCodeResponse.setCode(SysRetCodeConstants.SUCCESS.getCode());
                kaptchaCodeResponse.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
                log.info("End: KaptchaServiceImp.validateKaptcha.response: " + kaptchaCodeResponse);
                return kaptchaCodeResponse;
            }
            kaptchaCodeResponse.setCode(SysRetCodeConstants.KAPTCHA_CODE_ERROR.getCode());
            kaptchaCodeResponse.setMsg(SysRetCodeConstants.KAPTCHA_CODE_ERROR.getMessage());
        } catch (Exception e) {
            log.error("Error: KaptchaServiceImpl.validateKaptchaCode.Exception: "+e);
            ExceptionProcessorUtils.wrapperHandlerException(kaptchaCodeResponse,e);
        }

        log.info("End: KaptchaServiceImp.validateKaptcha.response: " + kaptchaCodeResponse);
        return kaptchaCodeResponse;
    }
}
