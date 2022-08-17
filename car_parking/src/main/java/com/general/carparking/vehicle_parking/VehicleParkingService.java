package com.general.carparking.vehicle_parking;


import com.general.carparking.parking.IParkingService;
import com.general.carparking.parking.Parking;
import com.general.carparking.vehicle.IVehicleService;
import com.general.carparking.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class VehicleParkingService implements IVehicleParkingService {


    private final VehicleParkingRepository repository;
    private final IParkingService parkingService;
    private final IVehicleService vehicleService;

    @Override
    public VehicleParking save(VehicleParking vehicleParking) {

        Long parkingId = vehicleParking.getParking().getId();
        Long vehicleId = vehicleParking.getVehicle().getId();
        Parking parking = parkingService.getById(parkingId);
        Vehicle vehicle = vehicleService.getById(vehicleId);
        vehicleParking.setParking(parking);
        vehicleParking.setVehicle(vehicle);
        return repository.save(vehicleParking);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public VehicleParking getById(Long id) {
        Optional<VehicleParking> optionalVehicleParking = repository.findById(id);


        if (!optionalVehicleParking.isPresent()){
            throw new RuntimeException("Not Found");
        }
        return optionalVehicleParking.get();
    }

    @Override
    public List<VehicleParking> getAll() {
        return (List<VehicleParking>) repository.findAll();
    }

    @Override
    public List<VehicleParking> getAllByParking(Long parkingId) {
        Parking parking = parkingService.getById(parkingId);
        List<VehicleParking> vehicleParkings = repository.findAllByParking(parking);
        return vehicleParkings;
    }

    @Override
    public List<VehicleParking> getAllByVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleService.getById(vehicleId);
        List<VehicleParking> vehicleParkings = repository.findAllByVehicle(vehicle);
        return vehicleParkings;
    }




  /*  @Override
    public List<VehicleParking> getAllByCarPlaque(String carPlaque) {

        VehicleParking vehicleParking = new VehicleParking();
        VehicleParking vehicleParking1 = vehicleParking.getVehicle().getCarPlaque();
        Vehicle vehicle=vehicleService.getById(carPlaque);

        List<Parking> parkings=repository.findAllByPriceRate(priceRate);


        return parkings;
    }*/

  /*  @Override
    public Date getCheckinTime(VehicleParking vehicleParking) {

        Date vehicleParkingInTime = vehicleParking.getParking().getCheckinTime();
        Date vehicleParkingOutTime = vehicleParking.getParking().getCheckoutTime();
        String carPlaque1 = vehicleParking.getVehicle().getCarPlaque();
        Parking parking = parkingService.getById(parkingId);
        Vehicle vehicle = vehicleService.getById(vehicleId);
        vehicleParking.setParking(parking);
        vehicleParking.setVehicle(vehicle);
        return repository.save(vehicleParking);



        String carPlaque = vehicle.getCarPlaque();
        repository.findAllByParking_CheckinTime(carPlaque);

        return null;
    }*/
}
