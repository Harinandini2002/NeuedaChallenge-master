package com.neuedatraining.CreditCardApplication.repository;

import com.neuedatraining.CreditCardApplication.dto.*;

import java.util.List;
import com.neuedatraining.CreditCardApplication.dto.CityTransaction;
import org.springframework.data.mongodb.repository.Query;


public interface TemplateRepo {

        List<CityTransaction> getAmountBasedOnCity();
        List<CategoryTransaction> getAmountBasedOnCategory();
        List<JobTransaction> getAmountBasedOnJob();
        List<MerchantTransaction> getAmountBasedOnMerchant();
        List<StateTransaction> getAmountBasedOnState();
        //@Query("{ 'amount' : { $gte : ?0, $lte : ?1 } }")
        List<LowVsHighTransaction> getAmountLowVsHigh();


}
