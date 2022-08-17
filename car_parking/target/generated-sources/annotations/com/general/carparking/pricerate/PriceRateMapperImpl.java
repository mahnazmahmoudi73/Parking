package com.general.carparking.pricerate;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-17T11:37:31+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class PriceRateMapperImpl implements PriceRateMapper {

    @Override
    public PriceRate toPriceRate(PriceRateDTO priceRateDTO) {
        if ( priceRateDTO == null ) {
            return null;
        }

        PriceRate priceRate = new PriceRate();

        priceRate.setId( priceRateDTO.getId() );
        priceRate.setVersion( priceRateDTO.getVersion() );
        priceRate.setCreatedDate( priceRateDTO.getCreatedDate() );
        priceRate.setCreatedBy( priceRateDTO.getCreatedBy() );
        priceRate.setLastModifiedDate( priceRateDTO.getLastModifiedDate() );
        priceRate.setLastModifiedBy( priceRateDTO.getLastModifiedBy() );
        priceRate.setHourRate( priceRateDTO.getHourRate() );
        priceRate.setDayRate( priceRateDTO.getDayRate() );
        priceRate.setMonthRate( priceRateDTO.getMonthRate() );

        return priceRate;
    }

    @Override
    public PriceRateDTO toPriceRateDTO(PriceRate priceRate) {
        if ( priceRate == null ) {
            return null;
        }

        PriceRateDTO priceRateDTO = new PriceRateDTO();

        priceRateDTO.setId( priceRate.getId() );
        priceRateDTO.setVersion( priceRate.getVersion() );
        priceRateDTO.setCreatedDate( priceRate.getCreatedDate() );
        priceRateDTO.setCreatedBy( priceRate.getCreatedBy() );
        priceRateDTO.setLastModifiedDate( priceRate.getLastModifiedDate() );
        priceRateDTO.setLastModifiedBy( priceRate.getLastModifiedBy() );
        priceRateDTO.setHourRate( priceRate.getHourRate() );
        priceRateDTO.setDayRate( priceRate.getDayRate() );
        priceRateDTO.setMonthRate( priceRate.getMonthRate() );

        return priceRateDTO;
    }

    @Override
    public List<PriceRate> toPriceRateList(List<PriceRateDTO> priceRateDTOS) {
        if ( priceRateDTOS == null ) {
            return null;
        }

        List<PriceRate> list = new ArrayList<PriceRate>( priceRateDTOS.size() );
        for ( PriceRateDTO priceRateDTO : priceRateDTOS ) {
            list.add( toPriceRate( priceRateDTO ) );
        }

        return list;
    }

    @Override
    public List<PriceRateDTO> toPriceRateDTOs(List<PriceRate> priceRateList) {
        if ( priceRateList == null ) {
            return null;
        }

        List<PriceRateDTO> list = new ArrayList<PriceRateDTO>( priceRateList.size() );
        for ( PriceRate priceRate : priceRateList ) {
            list.add( toPriceRateDTO( priceRate ) );
        }

        return list;
    }
}
