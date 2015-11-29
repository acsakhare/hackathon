package com.paapa.integration.service;

import com.paapa.domain.Merchant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by amehta on 28-11-2015.
 */
@Service(value = "citrusMerchantRegistrationService")
public class CitrusMerchantRegistrationServiceImpl implements MerchantRegistrationService {
    private static final Logger logger = LoggerFactory.getLogger(CitrusMerchantRegistrationServiceImpl.class);


    public Merchant register(Merchant merchant) {
      logger.info("Registering merchant with Citrus Wallet");
        return merchant;
    }
}
