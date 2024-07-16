package com.assesment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.SpringApplication;

import com.assesment.test.dto.Order;
import com.assesment.test.dto.User;
import com.assesment.test.service.DiscountCalculatorService;

@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
    private DiscountCalculatorService discountCalculatorService;

    @Test
    public void testCalculateNetPayableAmount_Employee() {
        double billAmount = 1000.0;
        Order order = new Order(billAmount, false);
        User user = new User(order, "Employee", LocalDate.now());

        double netPayableAmount = discountCalculatorService.calculateNetPayableAmount
        		(user);

        assertEquals(655.0, netPayableAmount);
    }

    @Test
    public void testCalculateNetPayableAmount_Affiliate() {
    	double billAmount = 1000.0;
        Order order = new Order(billAmount, false);
        User user = new User(order, "Affiliate", LocalDate.now());

        double netPayableAmount = discountCalculatorService.calculateNetPayableAmount
        		(user);

        assertEquals(855.0, netPayableAmount);
    }
    
    @Test
    public void testCalculateNetPayableAmount_Loyal() {
    	double billAmount = 1000.0;
        Order order = new Order(billAmount, false);
        User user = new User(order, "User", LocalDate.now().minusYears(3));

        double netPayableAmount = discountCalculatorService.calculateNetPayableAmount
        		(user);

        assertEquals(905.0, netPayableAmount);
    }
    
    @Test
    public void testCalculateNetPayableAmount_BillDiscount() {
    	double billAmount = 990.0;
        Order order = new Order(billAmount, false);
        User user = new User(order, "User", LocalDate.now());

        double netPayableAmount = discountCalculatorService.calculateNetPayableAmount
        		(user);

        assertEquals(945.45, netPayableAmount);
    }
}
