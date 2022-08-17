package com.general.carparking.vehicle;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleService implements IVehicleService{
    private final VehicleRepository repository;

    @Override
    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {

        Vehicle lastSavedVehicle=getById(vehicle.getId());

        lastSavedVehicle.setCarType(vehicle.getCarType());
        lastSavedVehicle.setCarPlaque(vehicle.getCarPlaque());

        return repository.save(lastSavedVehicle);
    }

    @Override
    public void delete(Long id) {
         repository.deleteById(id);
    }

    @Override
    public Vehicle getById(Long id) {

        Optional<Vehicle> optionalVehicle=repository.findById(id);

        if (!optionalVehicle.isPresent()){

            throw new NotFoundException("Not Found");
        }


        return optionalVehicle.get();
    }



    @Override
    public List<Vehicle> getAll() {
        return  (List<Vehicle>) repository.findAll();
    }
}
