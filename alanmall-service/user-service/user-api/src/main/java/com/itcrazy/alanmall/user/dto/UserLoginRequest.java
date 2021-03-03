package com.itcrazy.alanmall.user.dto;
import com.itcrazy.alanmall.common.result.AbstractResponse;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
// 需要创建一个Abstract抽象类，作为继承
public class UserLoginRequest extends AbstractRequest {
    private long id;
    private String username;
    private String password;

    @Override
    public void requestCheck() {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            // TODO 创建异常类做同一处理
        }

    }

}
