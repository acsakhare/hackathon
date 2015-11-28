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

import org.apache.camel.builder.RouteBuilder;


public class TutorialRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("ghttp:///merchant-registration")
            .process(new MerchantRegistrationRequestProcessor())
            //.process(new DuplicateValidator())
            .marshal().serialization()
            .to("gtask://registration")
            .unmarshal().serialization()
            .process(new ResponseProcessor());
      
        /*from("gtask://registration")
            .unmarshal().serialization()
            .setHeader(Exchange.HTTP_QUERY, constant("weather=").append(ReportData.city()))
            .enrich("ghttp://www.google.com/ig/api", reportDataAggregator())
            .setHeader(GMailBinding.GMAIL_SUBJECT, constant("Registration Success"))
            .setHeader(GMailBinding.GMAIL_SENDER, ReportData.requestor())
            .setHeader(GMailBinding.GMAIL_TO, ReportData.recipient())
            .process(new ReportGenerator())        
            .to("gmail://success");*/
    }

}
