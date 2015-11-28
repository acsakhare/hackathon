package com.paapa.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.paapa.domain.Merchant;
import com.paapa.domain.Wallets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.paapa.service.MerchantService;

/**
 * Handles requests for the merchant registration
 */
@Controller
public class MerchantRegistrationController {
	
	private static final Logger logger = LoggerFactory.getLogger(MerchantRegistrationController.class);

	@Autowired
	MerchantService merchantService;
	
	/**
	 * Validates registration request and asynchronously process registration request
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestBody Merchant merchant) {
		logger.info("Registering merchant {}" + merchant);

		List<Wallets> registered = new ArrayList<Wallets>();
		List<Wallets> unregistered = new ArrayList<Wallets>();

		for(Wallets wallet : merchant.getChannels()) {
			if(merchantService.ifAlreadyExists(merchant, wallet)) {
				registered.add(wallet);
			} else {
				unregistered.add(wallet);
			}
		}

		StringBuilder message = new StringBuilder();
		message.append("Thanks for choosing PAAPA Wallet.");

		if(!unregistered.isEmpty()) {
			merchant.setChannels(unregistered);
			merchantService.registerMerchantAsyncronously(merchant);

			message.append("We have received your request for registration for following wallets : " +unregistered);
		}

		if(!registered.isEmpty()) {
			message.append("You are already registered for following wallets: "+ registered);
		}

		return message.toString();
	}
}
