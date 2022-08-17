package com.general.carparking.pricerate;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRateRepository extends PagingAndSortingRepository<PriceRate, Long> {
}
