package jit.txy.newbeemall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 唐星宇
 * @date 2022/9/18
 **/
@Data
public class GoodsCategory {
    private Long categoryId;

    private Byte categoryLevel;

    private Long parentId;

    private String categoryName;

    private Integer categoryRank;

    private Byte isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private Integer updateUser;
}
