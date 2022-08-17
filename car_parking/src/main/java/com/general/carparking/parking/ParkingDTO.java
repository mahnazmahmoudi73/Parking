package com.general.carparking.parking;


import com.general.carparking.common.BaseDTO;
import com.general.carparking.pricerate.PriceRateDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.util.Date;


@Data
public class ParkingDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private Long checkinTime;

    @ApiModelProperty(required = true, hidden = false)
    private Long checkoutTime;

    @ApiModelProperty(required = true, hidden = false)
    private Double cost;

    @ApiModelProperty(required = true, hidden = false)
    private PriceRateDTO priceRate;





}
