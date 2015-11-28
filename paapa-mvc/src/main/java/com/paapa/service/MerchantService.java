package com.paapa.service;

import com.paapa.domain.Merchant;
import com.paapa.domain.Wallets;

/**
 * Created by amehta on 28-11-2015.
 */
public interface MerchantService {

    void registerMerchantAsyncronously(Merchant merchant);

    boolean ifAlreadyExists(Merchant merchant, Wallets wallet);
}
