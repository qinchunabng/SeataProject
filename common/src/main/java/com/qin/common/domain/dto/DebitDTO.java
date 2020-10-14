package com.qin.common.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author qinch
 */
@Data
public class DebitDTO implements Serializable {
    private static final long serialVersionUID = -8117468913539748040L;

    public DebitDTO(){

    }

    public DebitDTO(String userId, Integer money){
        this.userId = userId;
        this.money = money;
    }

    @NotBlank(message = "用户ID不能为空")
    @ApiModelProperty("用户ID")
    private String userId;

    @Min(value = 1, message = "金额不能小于1")
    @NotNull(message = "金额不能为空")
    @ApiModelProperty("金额")
    private Integer money;
}
