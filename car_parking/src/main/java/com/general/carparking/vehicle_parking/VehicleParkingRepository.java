package com.general.carparking.vehicle_parking;


import com.general.carparking.parking.Parking;
import com.general.carparking.vehicle.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleParkingRepository extends PagingAndSortingRepository<VehicleParking, Long> {

    List<VehicleParking> findAllByVehicle(Vehicle vehicle);
    List<VehicleParking> findAllByParking(Parking parking);


    //List<VehicleParking> findAllByCarPlaque(Vehicle vehicle);
    /*Date findAllByParking_CheckinTime(VehicleParking vehicleParking);*/


}
