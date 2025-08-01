package io.u2ware.ocpp.test.base20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.u2ware.ocpp.OCPPVersion;
import io.u2ware.ocpp.config.EnableOcppServer;

@SpringBootApplication
@EnableOcppServer(version = OCPPVersion.V1_6, uri = "/helloOcpp")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
