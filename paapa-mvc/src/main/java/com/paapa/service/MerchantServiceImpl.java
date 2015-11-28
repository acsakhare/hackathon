package com.paapa.service;

import com.paapa.domain.Merchant;
import com.paapa.domain.Wallets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by amehta on 28-11-2015.
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public void registerMerchantAsyncronously(final Merchant merchant) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(merchant);
            }
        });
    }

    @Override
    public boolean ifAlreadyExists(Merchant merchant, Wallets wallet) {
        return false;
    }
}
