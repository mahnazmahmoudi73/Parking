package com.general.carparking.parking;


import com.general.carparking.pricerate.PriceRate;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends PagingAndSortingRepository<Parking, Long> {

    List<Parking> findAllByPriceRate(PriceRate priceRate);



}
