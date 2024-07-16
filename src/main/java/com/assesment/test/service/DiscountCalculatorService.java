package com.assesment.test.service;

import java.time.LocalDate;
import java.util.Objects;

import com.assesment.test.dto.Order;
import com.assesment.test.dto.User;
import com.assesment.test.exception.OrderNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiscountCalculatorService {
	//This method will calculate on payable amount on basis of discount rule.
	//if user is Employee,then 30%
	//if user is Affiliate,then 10%
	//if user joined before 2 years,then 5%
	public double calculateNetPayableAmount(User user) {
		log.info("Calculating net payable amount for user {} ",user);
		Double totalDiscount = 0.0;

		Order order = user.getOrder();
		if(order == null) {
			throw new OrderNotFoundException("user has not done any order");
		}
		if (!order.isGrocery()) {
			if (Objects.equals(user.getType(), "Employee")) {
				totalDiscount = applyPercentageDiscount(order.getBillAmount(), 30);
				log.info("applying 30% dicount ");
			} else if (Objects.equals(user.getType(), "Affiliate")) {
				totalDiscount = applyPercentageDiscount(order.getBillAmount(), 10);
				log.info("applying 10% dicount ");
			} else if (user.getJoinedOn() != null 
					&& user.getJoinedOn().isBefore(LocalDate.now().minusYears(2))) {
				totalDiscount = applyPercentageDiscount(order.getBillAmount(), 5);
				log.info("applying 5% dicount ");
			}
		}

		totalDiscount = totalDiscount + calculateBillDiscount(order.getBillAmount());

		// for net payable amount
		double netPayableAmount = order.getBillAmount() - totalDiscount;
		log.info("Total net payable amount afetr discount {} ",netPayableAmount);
		return netPayableAmount;
	}

	//This method will calculate on payable amount on basis of discount.
	private double applyPercentageDiscount(double billAmount, int percentage) {
		double discountableAmount = (percentage / 100.0) * billAmount;
		return discountableAmount;
	}

	private double calculateBillDiscount(double billAmount) {
		return billAmount / 100 * 4.5;
	}
}
