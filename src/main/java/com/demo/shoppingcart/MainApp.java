package com.demo.shoppingcart;

import com.demo.shoppingcart.discount.CustomerTypeEnum;
import com.demo.shoppingcart.discount.Slab;
import com.demo.shoppingcart.discount.SlabsData;

public class MainApp {
    public static void main (String[] args) {
        long startTime = System.currentTimeMillis();

        calculateDiscount("PREMIUM", 45000);
        calculateDiscount("PREMIUM", 0);
        calculateDiscount("PREMIUM", 175234);
        calculateDiscount("PREMIUM", 1540);
        calculateDiscount("PREMIUM", 13200);
        calculateDiscount("PREMIUM", 25000);
        calculateDiscount("PREMIUM", 105000);
        calculateDiscount("PREMIUM", 22500);

        System.out.println("\n");

        calculateDiscount("REGULAR", 45000);
        calculateDiscount("REGULAR", 0);
        calculateDiscount("REGULAR", 175234);
        calculateDiscount("REGULAR", 1540);
        calculateDiscount("REGULAR", 13200);
        calculateDiscount("REGULAR", 25000);
        calculateDiscount("REGULAR", 105000);
        calculateDiscount("REGULAR", 22500);

        long endtime = System.currentTimeMillis();
        System.out.println("Total time taken (in ms) = " + (endtime - startTime));
    }

    static void calculateDiscount(String customerType, long spendAmount) {
        long discount = 0;
        Slab[] regularSlabs = SlabsData.getRegularCustomerSlabs();
        Slab[] premiumSlabs = SlabsData.getPremiumCustomerSlabs();

        if(spendAmount <=0) {
            System.err.println("Wrong spend!! Should spend a positive amount");
            return;
        }else {
            if(customerType.equalsIgnoreCase(CustomerTypeEnum.REGULAR.toString()))
                discount = applyRegularSlabs (regularSlabs, spendAmount);
            else discount = applyPremiumSlabs (premiumSlabs, spendAmount);
        }
        System.out.println("For spend-amount " + spendAmount + ", of customer-type " + customerType + ", total discount = " + discount);
    }

    static long applyRegularSlabs (Slab[] regularSlabs, long spendAmount) {
        long discount = 0;
        if(spendAmount <regularSlabs[0].getMaxLimit())
            discount += 0;
        else if(spendAmount >regularSlabs[0].getMaxLimit() && spendAmount <= regularSlabs[1].getMaxLimit()) {
            discount += (regularSlabs[1].getDiscount() * (spendAmount - regularSlabs[1].getMinLimit())) / 100;
        }
        else {
            discount += ( (regularSlabs[1].getDiscount() * (regularSlabs[1].getMaxLimit() - regularSlabs[1].getMinLimit())) / 100 +
                     (regularSlabs[2].getDiscount() * (spendAmount - regularSlabs[2].getMinLimit())) / 100);
        }
        return discount;
    }

    static long applyPremiumSlabs (Slab[] premiumSlabs, long spendAmount) {
        long discount = 0;
        if(spendAmount <premiumSlabs[0].getMaxLimit())
            discount += (premiumSlabs[0].getDiscount() * (spendAmount - premiumSlabs[0].getMinLimit())) / 100;
        else if(spendAmount >premiumSlabs[0].getMaxLimit() && spendAmount <= premiumSlabs[1].getMaxLimit()) {
            discount += ((premiumSlabs[0].getDiscount() * (premiumSlabs[0].getMaxLimit() - premiumSlabs[0].getMinLimit()))/ 100 +
                    (premiumSlabs[1].getDiscount() * (spendAmount - premiumSlabs[1].getMinLimit())) / 100 );
        }
        else if(spendAmount >premiumSlabs[1].getMaxLimit() && spendAmount <= premiumSlabs[2].getMaxLimit()) {
            discount += ((premiumSlabs[0].getDiscount() * (premiumSlabs[0].getMaxLimit() - premiumSlabs[0].getMinLimit())) / 100 +
                    (premiumSlabs[1].getDiscount() * (premiumSlabs[1].getMaxLimit() - premiumSlabs[1].getMinLimit())) / 100 +
                    (premiumSlabs[2].getDiscount() * (spendAmount - premiumSlabs[2].getMinLimit())) / 100);

        }else {
            discount += ( (premiumSlabs[0].getDiscount() * (premiumSlabs[0].getMaxLimit() - premiumSlabs[0].getMinLimit())) / 100 +
                    (premiumSlabs[1].getDiscount() * (premiumSlabs[1].getMaxLimit() - premiumSlabs[1].getMinLimit())) / 100 +
                    (premiumSlabs[2].getDiscount() * (premiumSlabs[2].getMaxLimit() - premiumSlabs[2].getMinLimit())) / 100 +
                    (premiumSlabs[3].getDiscount() * (spendAmount - premiumSlabs[3].getMinLimit()))/100
            );
        }
        return discount;
    }
}
