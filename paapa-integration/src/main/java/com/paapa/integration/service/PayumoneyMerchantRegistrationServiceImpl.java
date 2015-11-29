package com.paapa.integration.service;

import com.paapa.domain.Merchant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by amehta on 28-11-2015.
 */
@Service(value = "payumoneyMerchantRegistrationService")
public class PayumoneyMerchantRegistrationServiceImpl implements MerchantRegistrationService {
    private static final Logger logger = LoggerFactory.getLogger(PayumoneyMerchantRegistrationServiceImpl.class);


    public Merchant register(Merchant merchant) {
      logger.info("Registering merchant with Payumoney Wallet");
        return merchant;
    }
}
