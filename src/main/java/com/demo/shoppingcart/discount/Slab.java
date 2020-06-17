package com.demo.shoppingcart.discount;

public class Slab {
    private long minLimit, maxLimit;
    private int discount;
    private CustomerTypeEnum customerTypeEnum;

    public long getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(long minLimit) {
        this.minLimit = minLimit;
    }

    public long getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(long maxLimit) {
        this.maxLimit = maxLimit;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public CustomerTypeEnum getCustomerTypeEnum() {
        return customerTypeEnum;
    }

    public void setCustomerTypeEnum(CustomerTypeEnum customerTypeEnum) {
        this.customerTypeEnum = customerTypeEnum;
    }

    public Slab(long minLimit, long maxLimit, int discount, CustomerTypeEnum customerTypeEnum){
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.discount = discount;
        this.customerTypeEnum = customerTypeEnum;
    }
}
