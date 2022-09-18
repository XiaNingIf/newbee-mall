package jit.txy.newbeemall.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 唐星宇
 * @date 2022/9/15
 **/
@Data
public class AdminUserToken {
    private Long adminUserId;

    private String token;

    private Date updateTime;

    private Date expireTime;
}
