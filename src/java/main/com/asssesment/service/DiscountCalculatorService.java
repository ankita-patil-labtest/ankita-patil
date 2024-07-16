package com.assesment.service;

@Service
public class DiscountCalculatorService {
public double calculateNetPayableAmount(User user) {
        double totalDiscount = 0.0;

		if (!user.isGrocery()) {
            if (user.isEmployee()) {
                totalDiscount = applyMaxPercentageDiscount(user.getBillAmount(), 30);
            } else if (user.isAffiliate()) {
                totalDiscount = applyMaxPercentageDiscount(user.getBillAmount(), 10);
            } else if (user.isLoyalCustomer()) {
                totalDiscount = applyMaxPercentageDiscount(user.getBillAmount(), 5);
            }
        }

        totalDiscount = totalDiscount + calculateBillDiscount(user.getBillAmount());

        //for net payable amount
        double netPayableAmount = user.getBillAmount() - totalDiscount;
        return netPayableAmount;
    }

    private double applyMaxPercentageDiscount(double billAmount, int percentage) {
        double maxDiscountableAmount = (percentage / 100.0) * billAmount;
        return maxDiscountableAmount;
    }

    private double calculateBillDiscount(double billAmount) {
        return billAmount / 100 * 4.5;
    }
}
