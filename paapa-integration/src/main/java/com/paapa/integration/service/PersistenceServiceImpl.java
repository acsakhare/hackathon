package com.paapa.integration.service;


import com.paapa.domain.Merchant;
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
        logger.info("Persisting merchant information :" +merchant);

        // or use template directly
        template.opsForValue().set("merchant.name", merchant.getName());
        template.opsForValue().set("merchant.unique", merchant.getName()+merchant.getPhoneNumber());
        template.opsForValue().set("merchant.phone", merchant.getPhoneNumber());
        template.opsForValue().set("merchant.email", merchant.getEmail());
        template.opsForValue().set("merchant.wallet.paytm.merchantId", "10");
    }
}
