#! /usr/bin/groovy
package com.foo

import groovy.json.JsonBuilder
@Grab("org.jodd:jodd-http:5.1.0")
import jodd.http.HttpRequest
import jodd.http.HttpResponse


class JenkinsHttpClient implements Serializable {

    private String userAgent

    def getWebsiteText2(url){
    return new URL(url)
          .getText(connectTimeout: 5000, 
                readTimeout: 10000, 
                useCaches: true, 
                allowUserInteraction: false, 
                requestProperties: ['Connection': 'close'])
    }
   
 
}
