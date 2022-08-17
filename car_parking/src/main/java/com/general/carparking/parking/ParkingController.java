package com.general.carparking.parking;



import com.general.carparking.vehicle.IVehicleService;
import com.general.carparking.vehicle.Vehicle;
import com.general.carparking.vehicle_parking.IVehicleParkingService;
import com.general.carparking.vehicle_parking.VehicleParking;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/parking-controller/")
@AllArgsConstructor
public class ParkingController {
    private final IParkingService service;
    private final IVehicleService vehicleService;
    private final IVehicleParkingService vehicleParkingService;

    private ParkingMapper mapper;

    @PostMapping("/save-parking")
    public ResponseEntity save(@RequestBody ParkingDTO parkingDTO){
        Parking parking = mapper.toParking(parkingDTO);
        service.save(parking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update-parking")
    public ResponseEntity update(@RequestBody ParkingDTO parkingDTO){
        Parking parking=mapper.toParking(parkingDTO);

        service.update(parking);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/delete-parking/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-id-parking/{id}")
    public ResponseEntity<ParkingDTO> getById(@PathVariable Long id ){

        Parking parking=    service.getById(id);
        ParkingDTO parkingDTO=mapper.toParkingDTO(parking);
        return ResponseEntity.ok(parkingDTO);
    }
    @GetMapping("/get-all-parking")
    public ResponseEntity<List<ParkingDTO>> getAll(){

        List<Parking> parkingList=    service.getAll();


        List<ParkingDTO> parkingDTOS=    mapper.toParkingDTOs(parkingList);


        return ResponseEntity.ok(parkingDTOS);
    }

    @GetMapping("/get-all-by-price-rate/{id}")
    public ResponseEntity<List<ParkingDTO>> getAllByPriceRate(@PathVariable Long id){

        List<Parking> parkingList=    service.getAllByPriceRate(id);


        List<ParkingDTO> parkingDTOS=    mapper.toParkingDTOs(parkingList);


        return ResponseEntity.ok(parkingDTOS);
    }

    @GetMapping("/get-cost/{vehicleParkingId}")
    public ResponseEntity<Double> getCost(@PathVariable Long vehicleParkingId){

        VehicleParking vehicleParking = vehicleParkingService.getById(vehicleParkingId);
        Double totalCost = vehicleParking.getParking().getCost();
        return ResponseEntity.ok(totalCost);
    }

  /*  @GetMapping("/get-total-cost/{carPlaque}")
    public ResponseEntity<Double> getTotalCost(@PathVariable String carPlaque){
        VehicleParking vehicleParking = service.
        Double totalCost= service.calculateTotalCost(carPlaque);

        return ResponseEntity.ok(totalCost);
    }*/

}
