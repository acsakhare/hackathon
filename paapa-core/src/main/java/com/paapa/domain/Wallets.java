package com.paapa.domain;

/**
 * Created by amehta1 on 28-11-2015.
 */
public enum Wallets {

    PAYTM(".wallet.paytm.merchantId", "transaction.paytm", "https://paytm.com"),
    PAYUMONEY(".wallet.payumoney.merchantId", "transaction.payumoney", "https://payumoney.com"),
    CITRUS(".wallet.citrus.merchantId", "transaction.citrus", "https://citrus.com");

    Wallets(String redisMerchantIdKey, String transactionCountKey, String paymentUrl) {
        this.redisMerchantIdKey = redisMerchantIdKey;
        this.transactionCountKey = transactionCountKey;
        this.paymentUrl = paymentUrl;
    }

    private String redisMerchantIdKey;

    public String getTransactionCountKey() {
        return transactionCountKey;
    }

    private String transactionCountKey;

    public String getRedisMerchantIdKey() {
        return redisMerchantIdKey;
    }

    private String paymentUrl;

    public String getPaymentUrl() {
        return paymentUrl;
    }
}
