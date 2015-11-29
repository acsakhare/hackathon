package com.paapa.integration.service;

import com.paapa.domain.Merchant;
import com.paapa.domain.Wallets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Random;

/**
 * Created by amehta on 28-11-2015.
 */
@Service(value = "paytmMerchantRegistrationService")
public class PayTmMerchantRegistrationServiceImpl implements MerchantRegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(PayTmMerchantRegistrationServiceImpl.class);

    Random random = new Random();

    public Merchant register(Merchant merchant) {
        logger.info("Registering merchant with Paytm Wallet");

        merchant.getWalletMerchantId().put(Wallets.PAYTM, "paytm_merchant_"+random.nextDouble()*100);

        return merchant;
    }
}
