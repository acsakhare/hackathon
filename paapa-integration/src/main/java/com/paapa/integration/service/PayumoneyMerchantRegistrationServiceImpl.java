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
@Service(value = "payumoneyMerchantRegistrationService")
public class PayumoneyMerchantRegistrationServiceImpl implements MerchantRegistrationService {
    private static final Logger logger = LoggerFactory.getLogger(PayumoneyMerchantRegistrationServiceImpl.class);

    Random random = new Random();


    public Merchant register(Merchant merchant) {
      logger.info("Registering merchant with Payumoney Wallet");

        merchant.getWalletMerchantId().put(Wallets.PAYUMONEY, "payumoney_merchant_"+random.nextDouble()*100);

        return merchant;
    }
}
