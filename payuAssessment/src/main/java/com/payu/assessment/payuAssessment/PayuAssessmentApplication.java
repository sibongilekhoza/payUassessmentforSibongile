package com.payu.assessment.payuAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.payu.assessment.payuAssessment")
public class PayuAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayuAssessmentApplication.class, args);
	}

}
