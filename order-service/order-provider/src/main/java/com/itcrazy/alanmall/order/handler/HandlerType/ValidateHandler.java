package com.itcrazy.alanmall.order.handler.HandlerType;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Component
@PropertySource("classpath:rocketmq.properties")
@Data
public class ValidateHandler extends AbstracTransHandler {
    @Autowired
    RocketMQTemplate rocketMQTemplate;


    @Value("#{rocketmq.topic_first}")
    private String topic;

    @Override
    public boolean isAysc() {
        return false;
    }

    @Override
    public boolean doHandler(TransHandlerContext context) {
        try {
            String json = JSON.toJSONString(context);
            Message message = new Message(topic, "tagA", "order", json.getBytes());
            // 发送信息
            SendResult result = rocketMQTemplate.syncSend(topic, message, 3000);

            if (SendStatus.SEND_OK == result.getSendStatus()) {
                // context 进行赋值
                // TODO: 2021/1/21  

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

}
