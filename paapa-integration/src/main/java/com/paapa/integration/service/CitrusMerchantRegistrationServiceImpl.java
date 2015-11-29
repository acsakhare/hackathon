package com.paapa.integration.service;

import com.paapa.domain.Merchant;
import com.paapa.domain.Wallets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by amehta on 28-11-2015.
 */
@Service(value = "citrusMerchantRegistrationService")
public class CitrusMerchantRegistrationServiceImpl implements MerchantRegistrationService {
    private static final Logger logger = LoggerFactory.getLogger(CitrusMerchantRegistrationServiceImpl.class);

    Random random = new Random();

    public Merchant register(Merchant merchant) {
       logger.info("Registering merchant with Citrus Wallet");

        merchant.getWalletMerchantId().put(Wallets.CITRUS, "citrus_merchant_"+random.nextDouble()*100);

        return merchant;
    }
}
