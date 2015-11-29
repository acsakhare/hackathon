package com.paapa.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amehta1 on 28-11-2015.
 */
public class Merchant implements Serializable {

    private static final long serialVersionUID = -7140469835254005904L;

    private String name;

    private String phoneNumber;

    private String email;

    private List<Wallets> channels;

    private Map<Wallets, String> walletMerchantId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Wallets> getChannels() {
        return channels;
    }

    public void setChannels(List<Wallets> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", channels=" + channels +
                '}';
    }

    public Map<Wallets, String> getWalletMerchantId() {
        if(walletMerchantId == null)
            walletMerchantId = new HashMap<Wallets, String>();

        return walletMerchantId;
    }

    public void setWalletMerchantId(Map<Wallets, String> walletMerchantId) {
        this.walletMerchantId = walletMerchantId;
    }
}
