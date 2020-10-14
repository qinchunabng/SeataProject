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
public class CreateOrderDTO implements Serializable {
    private static final long serialVersionUID = -7553070613390283113L;

    @NotBlank(message = "用户ID不能为空")
    @ApiModelProperty("用户ID")
    private String userId;

    @NotBlank(message = "商品编码不能空")
    @ApiModelProperty("商品编码")
    private String commodityCode;

    @NotNull(message = "商品数量不能为空")
    @Min(value = 1, message = "商品数量最少不能少于1")
    @ApiModelProperty("商品数量")
    private Integer orderCount;
}
