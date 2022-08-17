package com.general.carparking.vehicle_parking;

import com.general.carparking.parking.ParkingMapper;
import com.general.carparking.vehicle.VehicleMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-17T11:37:30+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class VehicleParkingMapperImpl implements VehicleParkingMapper {

    @Autowired
    private ParkingMapper parkingMapper;
    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public VehicleParking toVehicleParking(VehicleParkingDTO vehicleParkingDTO) {
        if ( vehicleParkingDTO == null ) {
            return null;
        }

        VehicleParking vehicleParking = new VehicleParking();

        vehicleParking.setId( vehicleParkingDTO.getId() );
        vehicleParking.setVersion( vehicleParkingDTO.getVersion() );
        vehicleParking.setCreatedDate( vehicleParkingDTO.getCreatedDate() );
        vehicleParking.setCreatedBy( vehicleParkingDTO.getCreatedBy() );
        vehicleParking.setLastModifiedDate( vehicleParkingDTO.getLastModifiedDate() );
        vehicleParking.setLastModifiedBy( vehicleParkingDTO.getLastModifiedBy() );
        vehicleParking.setVehicle( vehicleMapper.toVehicle( vehicleParkingDTO.getVehicle() ) );
        vehicleParking.setParking( parkingMapper.toParking( vehicleParkingDTO.getParking() ) );

        return vehicleParking;
    }

    @Override
    public VehicleParkingDTO toVehicleParkingDTO(VehicleParking vehicleParking) {
        if ( vehicleParking == null ) {
            return null;
        }

        VehicleParkingDTO vehicleParkingDTO = new VehicleParkingDTO();

        vehicleParkingDTO.setId( vehicleParking.getId() );
        vehicleParkingDTO.setVersion( vehicleParking.getVersion() );
        vehicleParkingDTO.setCreatedDate( vehicleParking.getCreatedDate() );
        vehicleParkingDTO.setCreatedBy( vehicleParking.getCreatedBy() );
        vehicleParkingDTO.setLastModifiedDate( vehicleParking.getLastModifiedDate() );
        vehicleParkingDTO.setLastModifiedBy( vehicleParking.getLastModifiedBy() );
        vehicleParkingDTO.setVehicle( vehicleMapper.toVehicleDTO( vehicleParking.getVehicle() ) );
        vehicleParkingDTO.setParking( parkingMapper.toParkingDTO( vehicleParking.getParking() ) );

        return vehicleParkingDTO;
    }

    @Override
    public List<VehicleParking> toVehicleParkingList(List<VehicleParkingDTO> vehicleParkingDTOS) {
        if ( vehicleParkingDTOS == null ) {
            return null;
        }

        List<VehicleParking> list = new ArrayList<VehicleParking>( vehicleParkingDTOS.size() );
        for ( VehicleParkingDTO vehicleParkingDTO : vehicleParkingDTOS ) {
            list.add( toVehicleParking( vehicleParkingDTO ) );
        }

        return list;
    }

    @Override
    public List<VehicleParkingDTO> toVehicleParkingDTOs(List<VehicleParking> vehicleParkingList) {
        if ( vehicleParkingList == null ) {
            return null;
        }

        List<VehicleParkingDTO> list = new ArrayList<VehicleParkingDTO>( vehicleParkingList.size() );
        for ( VehicleParking vehicleParking : vehicleParkingList ) {
            list.add( toVehicleParkingDTO( vehicleParking ) );
        }

        return list;
    }
}
