package com.paapa.service;

import com.paapa.domain.Merchant;
import com.paapa.domain.Wallets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amehta on 28-11-2015.
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    private RedisTemplate<String, String> template;

    @Override
    public void registerMerchantAsyncronously(final Merchant merchant) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(merchant);
            }
        });
    }

    public boolean ifAlreadyExists(Merchant merchant, Wallets wallet) {
        String merchantId = template.opsForValue().get("merchant."+ merchant.getName() + wallet.getRedisMerchantIdKey());
        return merchantId == null? false : true;
    }

    public Merchant getDetails(String merchantName) {
        String baseKey = "merchant." + merchantName;

        Merchant merchant = new Merchant();

        // or use template directly
        merchant.setName(template.opsForValue().get(baseKey + ".name"));
        merchant.setPhoneNumber(template.opsForValue().get(baseKey + ".phone"));
        merchant.setEmail(template.opsForValue().get(baseKey + ".email"));
        merchant.getWalletMerchantId().put(Wallets.PAYTM, template.opsForValue().get(baseKey + Wallets.PAYTM.getRedisMerchantIdKey()));
        merchant.getWalletMerchantId().put(Wallets.PAYUMONEY, template.opsForValue().get(baseKey + Wallets.PAYUMONEY.getRedisMerchantIdKey()));
        merchant.getWalletMerchantId().put(Wallets.CITRUS, template.opsForValue().get(baseKey + Wallets.CITRUS.getRedisMerchantIdKey()));

        return merchant;
    }

    public Map<Wallets, String> getAnalytics() {
        Map<Wallets, String> walletTransactionCount = new HashMap<Wallets, String>();
        walletTransactionCount.put(Wallets.PAYTM, template.opsForValue().get(Wallets.PAYTM.getTransactionCountKey()));
        walletTransactionCount.put(Wallets.CITRUS, template.opsForValue().get(Wallets.CITRUS.getTransactionCountKey()));
        walletTransactionCount.put(Wallets.PAYUMONEY,template.opsForValue().get(Wallets.PAYUMONEY.getTransactionCountKey()));
        return walletTransactionCount;
    }

    public void registerTransaction(Wallets wallet) {
        template.opsForValue().increment(wallet.getTransactionCountKey(), 1);
    }

    public String getPaymentUrlForWallet(Wallets wallet) {
        return wallet.getPaymentUrl();
    }
}
