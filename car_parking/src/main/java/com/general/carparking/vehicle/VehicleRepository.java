package com.general.carparking.vehicle;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {


}
