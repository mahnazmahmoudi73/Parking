package com.general.carparking.vehicle;


import com.general.carparking.common.BaseDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;




@Data
public class VehicleDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private  CarType carType;

    @ApiModelProperty(required = true, hidden = false)
    private  String carPlaque;



}
