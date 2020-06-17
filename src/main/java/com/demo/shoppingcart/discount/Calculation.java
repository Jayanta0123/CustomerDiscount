package com.demo.shoppingcart.discount;

public class Calculation {

    public static long calculateDiscount(String customerType, long spendAmount) {
        long discount = 0;
        Slab[] regularSlabs = SlabsData.getRegularCustomerSlabs();
        Slab[] premiumSlabs = SlabsData.getPremiumCustomerSlabs();

        if(spendAmount <=0) {
            System.err.println("Wrong spend!! Should spend a positive amount");
            return -1;
        }else {
            if(customerType.equalsIgnoreCase(CustomerTypeEnum.REGULAR.toString()))
                discount = applyRegularSlabs (regularSlabs, spendAmount);
            else discount = applyPremiumSlabs (premiumSlabs, spendAmount);
        }
        System.out.println("For spend-amount " + spendAmount + ", of customer-type " + customerType + ", total discount = " + discount);

        return discount;
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
