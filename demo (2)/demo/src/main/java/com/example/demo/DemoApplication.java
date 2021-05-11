package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

/*
{
"/api": {
  "target": "http://localhost:8080",
  "secure": false
}
}

    "start": "ng serve --proxy-config proxy.conf.json",

export const environment = {
  production: false,
  BaseUrl: 'http://localhost:8080/api/allowed'
};

*/