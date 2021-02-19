package com.itcrazy.alanmall.order.utils;

import com.itcrazy.alanmall.common.exception.BaseBusinessException;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.redisson.RedissonScript;
import org.redisson.api.RFuture;
import org.redisson.api.RScript;
import org.redisson.codec.JsonJacksonCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * @Auther: mathyoung
 * @description:
 */
@Data
@Component
public class GlobalIdGeneratorUtil {
    @Autowired
    private RedissonConfig redissonConfig;

    private static final FastDateFormat seqDateFormat = FastDateFormat.getInstance("yyMMddHHmmssSSS");

    private String keyName;

    private Integer incrby;

    // sha1
    private String sha1;

    private String script = "local function get_max_seq()\n" +
            "local key = tostring(KEYS[1])\n" +
            "local incr_amoutt = tonumber(KEYS[2])\n" +
            "local keyvalue = tostring(KEYS[3])\n" +
            "local month_in_seconds = 24 * 60 * 60 * 30\n" +
            "if (1 == redis.call('setnx', key, keyvalue))\n" +
            "then\n" +
            "   redis.call('expire', key, month_in_seconds)\n" +
            "   return keyvalue\n" +
            "else\n" +
            "   local pre_keyvalue = redis.call('get', key)" +
            "   if (keyvalue > pre_keyvalue)\n" +
            "   then\n" +
            "       redis.call('set', key, keyvalue)\n" +
            "       return keyvalue\n" +
            "   else\n" +
            "       redis.call('incrby', key, incr_amoutt)\n" +
            "       return redis.call('get', key)\n" +
            "   end\n" +
            "end\n" +
            "end\n" +
            "return get_max_seq()";

    public GlobalIdGeneratorUtil() throws IOException {

    }

    @PostConstruct
    public void init() {
        sha1 = redissonConfig.getScript(script);
    }

    // 订单生成器
    public String getNextSeq(String keyName, int incrby) {
        if (StringUtils.isBlank(keyName) || incrby <= 0) {
           throw new BaseBusinessException("参数不正确");
        }
        this.incrby = incrby;
        this.keyName = keyName;

        try {
            return getMaxSeq();
        } catch (Exception e) {
            e.printStackTrace();
            return UUID.randomUUID().toString().replace("-","");
        }
    }

    private String getMaxSeq() throws ExecutionException, InterruptedException {
        List<Object> keys= Arrays.asList(keyName,incrby,generateSeq());
        RedissonScript rScript=(RedissonScript) redissonConfig.redissonScript();
        //这里遇到一个bug，默认情况下使用evalSha，不加Codec属性时，会报错。这个错误很神奇。花了3个小时才搞定。
        RFuture<Long> seqNext=rScript.evalShaAsync("", RScript.Mode.READ_ONLY, JsonJacksonCodec.INSTANCE,sha1, RScript.ReturnType.VALUE,keys);
        return seqNext.get().toString();
    }

    private String generateSeq() {
        String seqDate = seqDateFormat.format(System.currentTimeMillis());
        String candidateSeq = new StringBuilder(17).append(seqDate).append(RandomStringUtils.randomNumeric(2)).toString();
        return candidateSeq;
    }

}
