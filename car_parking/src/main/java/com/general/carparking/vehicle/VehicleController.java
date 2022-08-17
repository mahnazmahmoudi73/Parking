package com.general.carparking.vehicle;



import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicle-controller/")
@AllArgsConstructor
public class VehicleController {

    private final IVehicleService service;

    private VehicleMapper mapper;

    @PostMapping("/save-vehicle")
    public ResponseEntity save(@RequestBody VehicleDTO vehicleDTO){
        Vehicle vehicle = mapper.toVehicle(vehicleDTO);
        service.save(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update-vehicle")
    public ResponseEntity update(@RequestBody VehicleDTO vehicleDTO){
        Vehicle vehicle=mapper.toVehicle(vehicleDTO);

        service.update(vehicle);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete-vehicle/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-id-vehicle/{id}")
    public ResponseEntity<VehicleDTO> getById(@PathVariable Long id ){

        Vehicle vehicle=    service.getById(id);
        VehicleDTO vehicleDTO=mapper.toVehicleDTO(vehicle);
        return ResponseEntity.ok(vehicleDTO);
    }
    @GetMapping("/get-all-vehicle")
    public ResponseEntity<List<VehicleDTO>> getAll(){

        List<Vehicle> vehicleList=    service.getAll();


        List<VehicleDTO> vehicleDTOS=    mapper.toVehicleDTOs(vehicleList);


        return ResponseEntity.ok(vehicleDTOS);
    }


}
