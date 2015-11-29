package com.paapa.service;

import com.paapa.domain.Merchant;
import com.paapa.domain.Wallets;

import java.util.Map;

/**
 * Created by amehta on 28-11-2015.
 */
public interface MerchantService {

    void registerMerchantAsyncronously(Merchant merchant);

    boolean ifAlreadyExists(Merchant merchant, Wallets wallet);

    Merchant getDetails(String merchantName);

    Map<Wallets,String> getAnalytics();

    void registerTransaction(Wallets wallet);

    String getPaymentUrlForWallet(Wallets wallet);
}
