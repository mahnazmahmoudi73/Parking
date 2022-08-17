package com.general.carparking.vehicle;


import com.general.carparking.common.BaseEntity;

import com.general.carparking.vehicle_parking.VehicleParking;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_vehicle")
@Data
public class Vehicle extends BaseEntity {

    @NotNull
    @Column(name="car_type")
    @Enumerated(value = EnumType.STRING)
    private  CarType carType;

    @NotNull
    @Column(name="car_plaque")
    private  String carPlaque;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<VehicleParking> vehicleParkingList;







}
