#!/usr/bin/env groovy

import com.util.JenkinsHttpClient
//import com.util.*
//import JenkinsHttpClient


//call is special function in teh vars folder
//called like - sayHello 'Alex'
def call(String name = 'human') {
  echo "Hello, ${name}."
}


//called like -> sayHello.getWebsiteText("https://jsonplaceholder.typicode.com/todos/1")
def getWebsiteText(url){
    return new URL(url)
          .getText(connectTimeout: 5000, 
                readTimeout: 10000, 
                useCaches: true, 
                allowUserInteraction: false, 
                requestProperties: ['Connection': 'close'])
}


def getWebsiteText3(url){
    def sample = new com.util.JenkinsHttpClient()
    //def sample = new JenkinsHttpClient()
    return sample.getWebsiteText2(url)
}




