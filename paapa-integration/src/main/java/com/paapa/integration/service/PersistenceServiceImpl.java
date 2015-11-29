package com.paapa.integration.service;


import com.paapa.domain.Merchant;
import com.paapa.domain.Wallets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by amehta on 28-11-2015.
 */
@Service(value = "persistenceService")
public class PersistenceServiceImpl implements  PersistenceService{

    @Autowired
    private RedisTemplate<String, String> template;

    private static final Logger logger = LoggerFactory.getLogger(PayumoneyMerchantRegistrationServiceImpl.class);

    public void persist(Merchant merchant) {
        logger.info("Persisting merchant information :" + merchant);

        String baseKey = "merchant." + merchant.getName();

        // or use template directly
        template.opsForValue().set(baseKey + ".name", merchant.getName());
        template.opsForValue().set(baseKey + ".phone", merchant.getPhoneNumber());
        template.opsForValue().set(baseKey + ".email", merchant.getEmail());
        template.opsForValue().set(baseKey + Wallets.PAYTM.getRedisMerchantIdKey(), merchant.getWalletMerchantId().get(Wallets.PAYTM));
        template.opsForValue().set(baseKey + Wallets.PAYUMONEY.getRedisMerchantIdKey(), merchant.getWalletMerchantId().get(Wallets.PAYUMONEY));
        template.opsForValue().set(baseKey + Wallets.CITRUS.getRedisMerchantIdKey(), merchant.getWalletMerchantId().get(Wallets.CITRUS));
    }
}
