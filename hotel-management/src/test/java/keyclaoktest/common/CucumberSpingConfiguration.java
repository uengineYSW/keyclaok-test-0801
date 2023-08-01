package keyclaoktest.common;

import io.cucumber.spring.CucumberContextConfiguration;
import keyclaoktest.HotelManagementApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { HotelManagementApplication.class })
public class CucumberSpingConfiguration {}
