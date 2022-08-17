package com.general.carparking.vehicle_parking;


import com.general.carparking.parking.ParkingMapper;
import com.general.carparking.vehicle.VehicleMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ParkingMapper.class, VehicleMapper.class})
public interface VehicleParkingMapper {

    VehicleParking toVehicleParking(VehicleParkingDTO vehicleParkingDTO);

    VehicleParkingDTO toVehicleParkingDTO(VehicleParking vehicleParking);


    List<VehicleParking> toVehicleParkingList(List<VehicleParkingDTO> vehicleParkingDTOS);
    List<VehicleParkingDTO> toVehicleParkingDTOs(List<VehicleParking> vehicleParkingList);
}
