package com.paapa.integration.router;

import java.util.ArrayList;
import java.util.List;

import com.paapa.domain.Merchant;
import com.paapa.domain.Wallets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

/**
 * Handles requests for the merchant registration
 */
@MessageEndpoint
public class RegistrationWalletRouter {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationWalletRouter.class);

	public enum WalletChannelMapping {
		PAYTM("paytm-registration-channel"),
		CITRUS("citrus-registration-channel"),
		PAYUMONEY("payumoney-registration-channel");

		private String registrationChannel;

		WalletChannelMapping(String registationChannel) {
			this.registrationChannel = registationChannel;
		}

		public String getRegistrationChannel() {
			return registrationChannel;
		}

		public static WalletChannelMapping getFromWalletName(Wallets wallet) {
			for(WalletChannelMapping walletChannelMapping: WalletChannelMapping.values()) {
				if(walletChannelMapping.name().equals(wallet.name())) {
					return walletChannelMapping;
				}
			}

			throw new RuntimeException("Unsupported Wallet Type");}
	}

	@Router(inputChannel = "registration-channel", defaultOutputChannel = "nullChannel")
	public List<String> route(Merchant merchant) {
		List<String> routes = new ArrayList<String>();
		for(Wallets wallet: merchant.getChannels()) {
			routes.add(WalletChannelMapping.getFromWalletName(wallet).getRegistrationChannel());
		}

		return routes;
	}
}
