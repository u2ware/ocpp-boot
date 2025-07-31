package io.u2ware.ocpp.test.server2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.u2ware.ocpp.config.EnableOcppServer;
import io.u2ware.ocpp.core.OCPPVersion;

@SpringBootApplication
@EnableOcppServer(version = OCPPVersion.V1_6)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
