package com.general.carparking.pricerate;

import com.general.carparking.common.BaseDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;




@Data
public class PriceRateDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private Double hourRate;

    @ApiModelProperty(required = true, hidden = false)
    private Double dayRate;

    @ApiModelProperty(required = true, hidden = false)
    private Double monthRate;
}
