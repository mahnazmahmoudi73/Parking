package com.general.carparking.vehicle_parking;


import com.general.carparking.common.BaseEntity;
import com.general.carparking.parking.Parking;
import com.general.carparking.vehicle.Vehicle;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_vehicle_parking",uniqueConstraints = {@UniqueConstraint(columnNames = {"parking_id", "vehicle_id"})})
@Data
public class VehicleParking extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;


}
