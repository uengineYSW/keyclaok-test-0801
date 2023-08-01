package keyclaoktest.common;

import io.cucumber.spring.CucumberContextConfiguration;
import keyclaoktest.HotelReservationApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { HotelReservationApplication.class })
public class CucumberSpingConfiguration {}
