package com.general.carparking.common;

import com.general.carparking.parking.Parking;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class DataSave<T> {

        private Parking parking;
        private  Parking parking1;
        private List<T> data;
}
