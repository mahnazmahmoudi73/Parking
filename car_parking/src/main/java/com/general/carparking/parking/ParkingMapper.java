package com.general.carparking.parking;


import com.general.carparking.pricerate.PriceRateMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PriceRateMapper.class})
public interface ParkingMapper {

    Parking toParking(ParkingDTO parkingDTO);

    ParkingDTO toParkingDTO(Parking parking);


    List<Parking> toParkingList(List<ParkingDTO> parkingDTOS);
    List<ParkingDTO> toParkingDTOs(List<Parking> parkingList);
}
