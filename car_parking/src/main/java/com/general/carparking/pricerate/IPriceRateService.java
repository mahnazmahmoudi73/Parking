package com.general.carparking.pricerate;

import java.util.List;

public interface IPriceRateService {

    PriceRate save(PriceRate priceRate);
    PriceRate update(PriceRate priceRate);
    void delete(Long id);
    PriceRate getById(Long id);
    List<PriceRate> getAll();

}
