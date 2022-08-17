package com.general.carparking.parking;


import com.general.carparking.pricerate.IPriceRateService;
import com.general.carparking.pricerate.PriceRate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class ParkingService implements IParkingService{
    private final ParkingRepository repository;

    private  final IPriceRateService priceRateService;

    @Override
    public Parking save(Parking parking) {

        Long priceRateId=parking.getPriceRate().getId();
        //Parking parking1=getById(parking.getId());
        PriceRate priceRate=priceRateService.getById(priceRateId);
        parking.setPriceRate(priceRate);
        Double cost = calculateTotalCost(/*parking.getCheckinTime(), parking.getCheckoutTime(),*/ parking);
       // System.out.println("checkin" + parking.getCheckinTime());
        parking.setCost(cost);
        return repository.save(parking);
        /* VehicleParking vehicleParking = new VehicleParking();

        Long priceRateId=parking.getPriceRate().getId();
        Parking parking1 = parkingService.getById(parking.getId());
        parking1.setCost(cost);
        PriceRate priceRate=priceRateService.getById(priceRateId);
        parking.setPriceRate(priceRate);
        return repository.save(new Parking(parking, parking1));*/
      /*  Long priceRateId=parking.getPriceRate().getId();

        PriceRate priceRate=priceRateService.getById(priceRateId);
        parking.setPriceRate(priceRate);
        return repository.save(parking);
        return  null;*/
    }

    @Override
    public Parking update(Parking parking) {

        Parking lastSavedParking=getById(parking.getId());
        lastSavedParking.setCheckinTime(parking.getCheckinTime());
        lastSavedParking.setCheckoutTime(parking.getCheckoutTime());
        lastSavedParking.setCost(parking.getCost());

        return repository.save(lastSavedParking);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Parking getById(Long id) {

        Optional<Parking> optionalParking=repository.findById(id);

        if (!optionalParking.isPresent()){

            throw new NotFoundException("Not Found");
        }


        return optionalParking.get();
    }

    @Override
    public List<Parking> getAll() {
        return (List<Parking>) repository.findAll();
    }

    @Override
    public List<Parking> getAllByPriceRate(Long priceRateId) {
        PriceRate priceRate=priceRateService.getById(priceRateId);

        List<Parking> parkings=repository.findAllByPriceRate(priceRate);


        return parkings;
    }



    @Override
    public Double calculateTotalCost(/*Date checkInTime, Date checkOutTime,*/ Parking parking) {
        //Parking parking = new Parking();
        //String carPlaque=vehicle.getCarPlaque();



      /*  Double hourRate = Double.valueOf(5000);
        Double dayRate =  Double.valueOf(100000);
        Double monthRate = Double.valueOf(200000);*/

        Double hourRate = parking.getPriceRate().getHourRate();
        Double dayRate =  parking.getPriceRate().getDayRate();
        Double monthRate =parking.getPriceRate().getMonthRate();

       /* Date checkInTime = vehicleParking.getParking().getCheckinTime();
        Date checkOutTime = vehicleParking.getParking().getCheckoutTime();
        String carPlaque1 = vehicleParking.getVehicle().getCarPlaque();*/

       /*   Double hourRate = parking.getPriceRate().getHourRate();
        Double dayRate = parking.getPriceRate().getDayRate();
        Double monthRate = parking.getPriceRate().getMonthRate();
      Date checkInTime = parking.getCheckinTime();
        Date checkOutTime = parking.getCheckoutTime();*/

       /* var checkInTimeStamp = convertDateToTimestamp(parking.getCheckinTime());
        var checkOutTimeStamp = convertDateToTimestamp(parking.getCheckoutTime());*/

        Long elapsedTime = parking.getCheckoutTime() - parking.getCheckinTime();
        System.out.println("elapsedTime"+elapsedTime);

        if(elapsedTime < 86400000){

            Long hour = (elapsedTime / 1000) / 3600;
            Double hourlyCost = hourRate * hour;
            return hourlyCost;
            // return hourCost(elapsedTime, hourRate);
        }
        else if(elapsedTime >= 86400000 && elapsedTime < 2628000000l){
            Long day = (elapsedTime / 1000) / 86400;
            Double dayDouble = (elapsedTime / 1000) / Double.valueOf(86400);
            Double c = dayDouble - day;
            Long x = Double.valueOf(c * 24).longValue();
            /*Double dayCost = (dayRate * day);
            Double hourCost = (hourRate * x);
            Double result = dayCost + hourCost;*/

            Double dayCost =(dayRate * day) + (hourRate * x);
            return dayCost;

        }else {
            Long month = (elapsedTime / 1000) / 2628000;
            Double monthDouble = (elapsedTime / 1000) / Double.valueOf(2628000);
            System.out.println(monthDouble);
            Double h = monthDouble - month;
            System.out.println(h);
            Long y = Double.valueOf(h * 30).longValue();
            System.out.println(y);
            Double j = h * 30;
            System.out.println(j);
            Double o = j - y;
            System.out.println(o);
            Long p = Double.valueOf(o * 24).longValue();
            System.out.println(p);
            Double monthCost = (monthRate * month) +(dayRate * y) + (hourRate * p);
            return monthCost;

        }

    }

/*   public Double hourCost(Long elapsedTime, Double hourRate){
        Long hour = (elapsedTime / 1000) / 3600;
        Double hourlyCost = hourRate * hour;
        return hourlyCost;
    }

    public Double dayCost(Long elapsedTime, Double hourRate, Double dayRate){
        Long day = (elapsedTime / 1000) / 86400;
        Double dayDouble = Double.valueOf((elapsedTime / 1000) / 86400);
        Double c = dayDouble - day;
        double f = c* 86400000;
        hourCost(f, hourRate);
        Long x = Double.valueOf(c * 24).longValue();
            *//*Double dayCost = (dayRate * day);
            Double hourCost = (hourRate * x);
            Double result = dayCost + hourCost;*//*

        Double dayCost =(dayRate * day) + (hourRate * x);
        return dayCost;
    }*/



  /*  public Long convertDateToTimestamp(Date date){

        if (date!=null)
            return date.getTime();
        return null;
    }*/


/*
    @Override
    public Double calculateTotalCost(VehicleParking vehicleParking) {
        Parking parking = new Parking();
        //String carPlaque=vehicle.getCarPlaque();
        Date checkInTime = vehicleParking.getParking().getCheckinTime();
        Date checkOutTime = vehicleParking.getParking().getCheckoutTime();
        String carPlaque1 = vehicleParking.getVehicle().getCarPlaque();

        Double hourRate = parking.getPriceRate().getHourRate();
        Double dayRate = parking.getPriceRate().getDayRate();
        Double monthRate = parking.getPriceRate().getMonthRate();
       *//* Date checkInTime = parking.getCheckinTime();
        Date checkOutTime = parking.getCheckoutTime();*//*

        var checkInTimeStamp = convertDateToTimestamp(checkInTime);
        var checkOutTimeStamp = convertDateToTimestamp(checkOutTime);

        var elapsedTime = checkOutTimeStamp - checkInTimeStamp;

        if(elapsedTime <= 86400000){
            Long hour = (elapsedTime / 1000) / 3600;
            Double hourlyCost = hourRate * hour;
            parking.setCost(hourlyCost);
            return hourlyCost;
        }
        else if(elapsedTime < 86400000 && elapsedTime >= 2592000000l){
            Long day = (elapsedTime / 1000) / 86400;
            Double dayDouble = Double.valueOf((elapsedTime / 1000) / 86400);
            Double c = dayDouble - day;
            Long x = Double.valueOf(c * 24).longValue();
            Double dayCost = (dayRate * day) + (hourRate * x);
            parking.setCost(dayCost);
            return dayCost;

        }else {
            Long month = (elapsedTime / 1000) / 2628000;
            Double monthDouble = Double.valueOf((elapsedTime / 1000) / 2628000);
            Double h = monthDouble - month;
            Long y = Double.valueOf(h * 30).longValue();
            Double j = h * 30;
            Double o = j - y;
            Long p = Double.valueOf(o * 24).longValue();
            Double monthCost = (monthRate * month) + (dayRate * y) + (hourRate * p);
            parking.setCost(monthCost);
            return monthCost;

        }

    }

    public Long convertDateToTimestamp(Date date){

        if (date!=null)
            return date.getTime();
        return null;
    }*/


}
