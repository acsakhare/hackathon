package com.paapa.integration.service;

import com.paapa.domain.Merchant;
import com.paapa.domain.Wallets;
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

        merchant.getWalletMerchantId().put(Wallets.CITRUS, "citrus_merchant_10");

        return merchant;
    }
}
