package jit.txy.newbeemall.admin.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author 唐星宇
 * @date 2022/9/16
 **/
@Data
public class UpdateAdminPasswordParam {

    @NotEmpty(message = "originalPassword不能为空")
    private String originalPassword;

    @NotEmpty(message = "newPassword不能为空")
    private String newPassword;
}