package com.general.carparking.pricerate;

import com.general.carparking.common.BaseEntity;
import com.general.carparking.parking.Parking;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_price_rate")
@Data
public class PriceRate extends BaseEntity {

    @NotNull
    @Column(name="hour_rate")
    private Double hourRate;

    @NotNull
    @Column(name="day_rate")
    private Double dayRate;

    @NotNull
    @Column(name="month_rate")
    private Double monthRate;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "priceRate",cascade = CascadeType.ALL)
    private List<Parking> parkings;
}
