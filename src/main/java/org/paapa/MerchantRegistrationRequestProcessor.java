/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.paapa;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MerchantRegistrationRequestProcessor implements Processor {

    //private static final Logger LOGGER = LoggerFactory.getLogger(MerchantRegistrationRequestProcessor.class);
    
    public void process(Exchange exchange) throws Exception {
        String name = (String)exchange.getIn().removeHeader("name");
        String phone = (String)exchange.getIn().removeHeader("phone");
        String email = (String)exchange.getIn().removeHeader("email");

        MerchantRegistrationData merchantRegistrationData = new MerchantRegistrationData(name, phone, email);

        exchange.getIn().setBody(merchantRegistrationData);
      //  LOGGER.info("Merchant "+ merchantRegistrationData + " requested for registration!!");
    }
}
