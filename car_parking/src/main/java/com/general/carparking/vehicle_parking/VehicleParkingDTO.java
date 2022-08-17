package com.general.carparking.vehicle_parking;


import com.general.carparking.common.BaseDTO;
import com.general.carparking.parking.ParkingDTO;
import com.general.carparking.vehicle.VehicleDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class VehicleParkingDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private VehicleDTO vehicle;

    @ApiModelProperty(required = true, hidden = false)
    private ParkingDTO parking;





}
