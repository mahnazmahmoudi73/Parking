package com.general.carparking.parking;

import com.general.carparking.pricerate.PriceRateMapper;
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
public class ParkingMapperImpl implements ParkingMapper {

    @Autowired
    private PriceRateMapper priceRateMapper;

    @Override
    public Parking toParking(ParkingDTO parkingDTO) {
        if ( parkingDTO == null ) {
            return null;
        }

        Parking parking = new Parking();

        parking.setId( parkingDTO.getId() );
        parking.setVersion( parkingDTO.getVersion() );
        parking.setCreatedDate( parkingDTO.getCreatedDate() );
        parking.setCreatedBy( parkingDTO.getCreatedBy() );
        parking.setLastModifiedDate( parkingDTO.getLastModifiedDate() );
        parking.setLastModifiedBy( parkingDTO.getLastModifiedBy() );
        parking.setCheckinTime( parkingDTO.getCheckinTime() );
        parking.setCheckoutTime( parkingDTO.getCheckoutTime() );
        parking.setCost( parkingDTO.getCost() );
        parking.setPriceRate( priceRateMapper.toPriceRate( parkingDTO.getPriceRate() ) );

        return parking;
    }

    @Override
    public ParkingDTO toParkingDTO(Parking parking) {
        if ( parking == null ) {
            return null;
        }

        ParkingDTO parkingDTO = new ParkingDTO();

        parkingDTO.setId( parking.getId() );
        parkingDTO.setVersion( parking.getVersion() );
        parkingDTO.setCreatedDate( parking.getCreatedDate() );
        parkingDTO.setCreatedBy( parking.getCreatedBy() );
        parkingDTO.setLastModifiedDate( parking.getLastModifiedDate() );
        parkingDTO.setLastModifiedBy( parking.getLastModifiedBy() );
        parkingDTO.setCheckinTime( parking.getCheckinTime() );
        parkingDTO.setCheckoutTime( parking.getCheckoutTime() );
        parkingDTO.setCost( parking.getCost() );
        parkingDTO.setPriceRate( priceRateMapper.toPriceRateDTO( parking.getPriceRate() ) );

        return parkingDTO;
    }

    @Override
    public List<Parking> toParkingList(List<ParkingDTO> parkingDTOS) {
        if ( parkingDTOS == null ) {
            return null;
        }

        List<Parking> list = new ArrayList<Parking>( parkingDTOS.size() );
        for ( ParkingDTO parkingDTO : parkingDTOS ) {
            list.add( toParking( parkingDTO ) );
        }

        return list;
    }

    @Override
    public List<ParkingDTO> toParkingDTOs(List<Parking> parkingList) {
        if ( parkingList == null ) {
            return null;
        }

        List<ParkingDTO> list = new ArrayList<ParkingDTO>( parkingList.size() );
        for ( Parking parking : parkingList ) {
            list.add( toParkingDTO( parking ) );
        }

        return list;
    }
}
