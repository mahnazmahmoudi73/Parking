package com.general.carparking.vehicle_parking;


import com.general.carparking.parking.Parking;

import java.util.List;

public interface IVehicleParkingService {

    VehicleParking save(VehicleParking vehicleParking);

    void delete(Long id);

    VehicleParking getById (Long id);

    List<VehicleParking> getAll ();

    List<VehicleParking> getAllByParking(Long parkingId);

    List<VehicleParking> getAllByVehicle(Long vehicleId);






    /*List<VehicleParking> getAllByCarPlaque(String carPlaque);*/

    /*Date getCheckinTime(VehicleParking vehicleParking);*/
}
