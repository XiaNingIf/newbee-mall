package jit.txy.newbeemall.admin.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 唐星宇
 * @date 2022/9/16
 **/
@Data
public class BatchIdParam implements Serializable {
    //id数组
    Long[] ids;
}

