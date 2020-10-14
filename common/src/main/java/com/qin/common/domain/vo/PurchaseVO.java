package com.qin.common.domain.vo;

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
public class PurchaseVO implements Serializable {
    private static final long serialVersionUID = -289817118422867221L;

    @NotBlank(message = "用户ID不能为空")
    @ApiModelProperty("用户ID")
    private String userId;

    @NotBlank(message = "商品编码不能为空")
    @ApiModelProperty("商品编码")
    private String commodityCode;

    @NotNull(message = "订单数量不能为空")
    @Min(value = 1, message = "订单数量不能少于1")
    @ApiModelProperty("订单数量")
    private Integer orderCount;
}
