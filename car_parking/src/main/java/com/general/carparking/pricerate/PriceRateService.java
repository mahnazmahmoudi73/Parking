package com.general.carparking.pricerate;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PriceRateService implements IPriceRateService{
    private final PriceRateRepository repository;

    @Override
    public PriceRate save(PriceRate priceRate) {
        return repository.save(priceRate);
    }

    @Override
    public PriceRate update(PriceRate priceRate) {
        PriceRate lastSavedPriceRate=getById(priceRate.getId());
        lastSavedPriceRate.setHourRate(priceRate.getHourRate());
        lastSavedPriceRate.setDayRate(priceRate.getDayRate());
        lastSavedPriceRate.setMonthRate(priceRate.getMonthRate());

        return repository.save(lastSavedPriceRate);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PriceRate getById(Long id) {
        Optional<PriceRate> optionalPriceRate=repository.findById(id);

        if (!optionalPriceRate.isPresent()){

            throw new NotFoundException("Not Found");
        }


        return optionalPriceRate.get();
    }

    @Override
    public List<PriceRate> getAll() {
        return (List<PriceRate>) repository.findAll();
    }
}
