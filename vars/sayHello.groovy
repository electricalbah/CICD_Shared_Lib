#!/usr/bin/env groovy

def call(String name = 'human') {
  echo "Hello, ${name}."
}

def getWebsiteText(url){
    return new URL(url)
          .getText(connectTimeout: 5000, 
                readTimeout: 10000, 
                useCaches: true, 
                allowUserInteraction: false, 
                requestProperties: ['Connection': 'close'])
}

def getjwtToken(guardrailurl,apikey){
    body = """{\"apiKey\":\"${apikey}\"}"""   
    req = httpRequest contentType: 'APPLICATION_JSON', httpMode: 'POST', quiet: true, ignoreSslErrors: true, requestBody: body, url: guardrailurl+"/v2/auth", wrapAsMultipart: false
    jSon =  readJSON text: req.getContent()
    JWT_TOKEN = jSon['jwtToken']
    return JWT_TOKEN
}



