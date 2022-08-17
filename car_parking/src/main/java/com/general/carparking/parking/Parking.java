package com.general.carparking.parking;


import com.general.carparking.common.BaseEntity;
import com.general.carparking.pricerate.PriceRate;

import com.general.carparking.vehicle_parking.VehicleParking;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_parking")
@Data
public class Parking extends BaseEntity {

    @NotNull
    @Column(name="checkin_time")
    private Long checkinTime;

    @NotNull
    @Column(name="checkout_time")
    private Long checkoutTime;

    @NotNull
    @Column(name="cost")
    private Double cost;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parking", cascade = CascadeType.ALL)
    private List<VehicleParking> vehicleParkingList;


    @ManyToOne()
    @JoinColumn(name = "price_rate_id")
    private PriceRate priceRate;
}
