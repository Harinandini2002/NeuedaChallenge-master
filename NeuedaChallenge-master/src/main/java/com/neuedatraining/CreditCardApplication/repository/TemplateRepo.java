package com.neuedatraining.CreditCardApplication.repository;

import com.neuedatraining.CreditCardApplication.dto.*;

import java.util.List;
import com.neuedatraining.CreditCardApplication.dto.CityTransaction;


public interface TemplateRepo {

        List<CityTransaction> getAmountBasedOnCity();
        List<CategoryTransaction> getAmountBasedOnCategory();
        List<JobTransaction> getAmountBasedOnJob();
        List<MerchantTransaction> getAmountBasedOnMerchant();
        List<StateTransaction> getAmountBasedOnState();


}
