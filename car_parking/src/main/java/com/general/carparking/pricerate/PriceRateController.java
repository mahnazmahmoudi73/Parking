package com.general.carparking.pricerate;



import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pricerate-controller/")
@AllArgsConstructor
public class PriceRateController {

    private final IPriceRateService service;

    private PriceRateMapper mapper;

    @PostMapping("/save-price-rate")
    public ResponseEntity save(@RequestBody PriceRateDTO priceRateDTO){
        PriceRate priceRate = mapper.toPriceRate(priceRateDTO);
        service.save(priceRate);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping("/update-price-rate")
    public ResponseEntity update(@RequestBody PriceRateDTO priceRateDTO){
        PriceRate priceRate=mapper.toPriceRate(priceRateDTO);

        service.update(priceRate);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-price-rate/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-id-price-rate/{id}")
    public ResponseEntity<PriceRateDTO> getById(@PathVariable Long id ){

        PriceRate priceRate=    service.getById(id);
        PriceRateDTO priceRateDTO=mapper.toPriceRateDTO(priceRate);
        return ResponseEntity.ok(priceRateDTO);
    }
    @GetMapping("/get-all-price-rate")
    public ResponseEntity<List<PriceRateDTO>> getAll(){

        List<PriceRate> priceRateList=    service.getAll();


        List<PriceRateDTO> priceRateDTOS=    mapper.toPriceRateDTOs(priceRateList);


        return ResponseEntity.ok(priceRateDTOS);
    }
}
