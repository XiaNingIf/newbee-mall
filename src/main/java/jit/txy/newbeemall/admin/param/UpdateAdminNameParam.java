package jit.txy.newbeemall.admin.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author 唐星宇
 * @date 2022/9/16
 **/
@Data
public class UpdateAdminNameParam {

    @NotEmpty(message = "loginUserName不能为空")
    private String loginUserName;

    @NotEmpty(message = "nickName不能为空")
    private String nickName;
}
