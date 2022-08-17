package com.general.carparking.parking;



import java.util.Date;
import java.util.List;

public interface IParkingService {
    Parking save(Parking parking);
    Parking update(Parking parking);
    void delete(Long id);
    Parking getById (Long id);
    List<Parking> getAll ();

    List<Parking> getAllByPriceRate(Long priceRateId);

    Double calculateTotalCost(/*Date checkinTime, Date checkoutTime,*/ Parking parking);

    //Double calculateTotalCost(VehicleParking vehicleParking);
}
