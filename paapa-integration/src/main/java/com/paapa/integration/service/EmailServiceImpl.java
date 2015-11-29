package com.paapa.integration.service;

import com.paapa.domain.Merchant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by amehta on 28-11-2015.
 */
@Service(value = "emailService")
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    public void sendEmail(Merchant merchant) {
        logger.info("Registered merchant with Paytm Wallet");
    }
}
