package com.assesment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestApplicationTest{
@Test
	void contextLoads() {
	}

	@InjectMocks
    private DiscountCalculatorService discountCalculatorService;

    @Test
    public void testCalculateNetPayableAmount_Employee() {
        double billAmount = 1000.0;
        boolean isEmployee = true;
        boolean isAffiliate = false;
        boolean isLoyalCustomer = false;
        boolean isGrocery = false;
        User user = new User(billAmount, isEmployee, isAffiliate, isLoyalCustomer, isGrocery);

        double netPayableAmount = discountCalculatorService.calculateNetPayableAmount
        		(user);

        assertEquals(655.0, netPayableAmount);
    }

    @Test
    public void testCalculateNetPayableAmount_Affiliate() {
    	double billAmount = 1000.0;
        boolean isEmployee = false;
        boolean isAffiliate = true;
        boolean isLoyalCustomer = false;
        boolean isGrocery = false;
        User user = new User(billAmount, isEmployee, isAffiliate, isLoyalCustomer, isGrocery);

        double netPayableAmount = discountCalculatorService.calculateNetPayableAmount
        		(user);

        assertEquals(855.0, netPayableAmount);
    }
    
    @Test
    public void testCalculateNetPayableAmount_Loyal() {
    	double billAmount = 1000.0;
        boolean isEmployee = false;
        boolean isAffiliate = false;
        boolean isLoyalCustomer = true;
        boolean isGrocery = false;
        User user = new User(billAmount, isEmployee, isAffiliate, isLoyalCustomer, isGrocery);

        double netPayableAmount = discountCalculatorService.calculateNetPayableAmount
        		(user);

        assertEquals(905.0, netPayableAmount);
    }
    
    @Test
    public void testCalculateNetPayableAmount_BillDiscount() {
    	double billAmount = 990.0;
        boolean isEmployee = false;
        boolean isAffiliate = false;
        boolean isLoyalCustomer = false;
        boolean isGrocery = false;
        User user = new User(billAmount, isEmployee, isAffiliate, isLoyalCustomer, isGrocery);

        double netPayableAmount = discountCalculatorService.calculateNetPayableAmount
        		(user);

        assertEquals(945.45, netPayableAmount);
    }
}	

