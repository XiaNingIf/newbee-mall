package jit.txy.newbeemall.entity;

import lombok.Data;

/**
 * @author 唐星宇
 * @date 2022/9/15
 **/
@Data
public class AdminUser {
    private Long adminUserId;

    private String loginUserName;

    private String loginPassword;

    private String nickName;

    private Byte locked;
}