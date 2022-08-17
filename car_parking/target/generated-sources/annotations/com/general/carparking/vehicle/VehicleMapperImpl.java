package com.general.carparking.vehicle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-17T11:37:30+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public Vehicle toVehicle(VehicleDTO vehicleDTO) {
        if ( vehicleDTO == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setId( vehicleDTO.getId() );
        vehicle.setVersion( vehicleDTO.getVersion() );
        vehicle.setCreatedDate( vehicleDTO.getCreatedDate() );
        vehicle.setCreatedBy( vehicleDTO.getCreatedBy() );
        vehicle.setLastModifiedDate( vehicleDTO.getLastModifiedDate() );
        vehicle.setLastModifiedBy( vehicleDTO.getLastModifiedBy() );
        vehicle.setCarType( vehicleDTO.getCarType() );
        vehicle.setCarPlaque( vehicleDTO.getCarPlaque() );

        return vehicle;
    }

    @Override
    public VehicleDTO toVehicleDTO(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleDTO vehicleDTO = new VehicleDTO();

        vehicleDTO.setId( vehicle.getId() );
        vehicleDTO.setVersion( vehicle.getVersion() );
        vehicleDTO.setCreatedDate( vehicle.getCreatedDate() );
        vehicleDTO.setCreatedBy( vehicle.getCreatedBy() );
        vehicleDTO.setLastModifiedDate( vehicle.getLastModifiedDate() );
        vehicleDTO.setLastModifiedBy( vehicle.getLastModifiedBy() );
        vehicleDTO.setCarType( vehicle.getCarType() );
        vehicleDTO.setCarPlaque( vehicle.getCarPlaque() );

        return vehicleDTO;
    }

    @Override
    public List<Vehicle> toVehicleList(List<VehicleDTO> vehicleDTOS) {
        if ( vehicleDTOS == null ) {
            return null;
        }

        List<Vehicle> list = new ArrayList<Vehicle>( vehicleDTOS.size() );
        for ( VehicleDTO vehicleDTO : vehicleDTOS ) {
            list.add( toVehicle( vehicleDTO ) );
        }

        return list;
    }

    @Override
    public List<VehicleDTO> toVehicleDTOs(List<Vehicle> vehicleList) {
        if ( vehicleList == null ) {
            return null;
        }

        List<VehicleDTO> list = new ArrayList<VehicleDTO>( vehicleList.size() );
        for ( Vehicle vehicle : vehicleList ) {
            list.add( toVehicleDTO( vehicle ) );
        }

        return list;
    }
}
