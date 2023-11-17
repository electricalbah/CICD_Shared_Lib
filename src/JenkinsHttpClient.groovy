#! /usr/bin/groovy
package com.test.c3.http

import com.cloudbees.groovy.cps.NonCPS
import groovy.json.JsonBuilder
@Grab("org.jodd:jodd-http:5.1.0")
import jodd.http.HttpRequest
import jodd.http.HttpResponse


class JenkinsHttpClient implements Serializable {

    private String userAgent


    JenkinsHttpClient(String userAgent = "Jenkins"){
        this.userAgent = userAgent
    }
  
}
