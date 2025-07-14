package io.u2ware.ocpp.test.client1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.u2ware.ocpp.config.EnableOcppClient;
import io.u2ware.ocpp.core.OCPPVersion;

@SpringBootApplication
@EnableOcppClient(version = OCPPVersion.V2_0_1)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
