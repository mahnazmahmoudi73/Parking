package com.general.carparking.vehicle;



import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    Vehicle toVehicle(VehicleDTO vehicleDTO);

    VehicleDTO toVehicleDTO(Vehicle vehicle);


    List<Vehicle> toVehicleList(List<VehicleDTO> vehicleDTOS);
    List<VehicleDTO> toVehicleDTOs(List<Vehicle> vehicleList);
}
