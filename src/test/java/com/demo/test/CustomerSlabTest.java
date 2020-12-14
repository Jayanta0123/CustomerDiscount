package com.demo.test;

import com.demo.shoppingcart.discount.Calculation;
import com.demo.shoppingcart.discount.CustomerTypeEnum;
import com.demo.shoppingcart.discount.SlabsData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerSlabTest {

    // print this before the tests execute
    @BeforeClass
    public static void printSlabsData() {
        SlabsData.printSlabs(CustomerTypeEnum.PREMIUM);
        SlabsData.printSlabs(CustomerTypeEnum.REGULAR);
    }

    // First 10 unit-tests tests the equality of the calculated and the provided value
    @Test
    public void testPremiumCustomerDiscount1() {
        long discount = Calculation.calculateDiscount("PREMIUM", 45000);
        long calculatedDiscount = 11700;
        Assert.assertEquals(discount, calculatedDiscount);
    }
    @Test
    public void testPremiumCustomerDiscount2() {
        long discount = Calculation.calculateDiscount("PREMIUM", 175234);
        long calculatedDiscount = 50770;
        Assert.assertEquals(discount, calculatedDiscount);
    }

    @Test
    public void testPremiumCustomerDiscount3() {
        long discount = Calculation.calculateDiscount("PREMIUM", 1540);
        long calculatedDiscount = 154;
        Assert.assertEquals(discount, calculatedDiscount);
    }

    @Test
    public void testPremiumCustomerDiscount4() {
        long discount = Calculation.calculateDiscount("PREMIUM", 13200);
        long calculatedDiscount = 2160;
        Assert.assertEquals(discount, calculatedDiscount);
    }

    @Test
    public void testPremiumCustomerDiscount5() {
        long discount = Calculation.calculateDiscount("PREMIUM", 22500);
        long calculatedDiscount = 4950;
        Assert.assertEquals(discount, calculatedDiscount);
    }

    @Test
    public void testRegularCustomerDiscount1() {
        long discount = Calculation.calculateDiscount("REGULAR", 45000);
        long calculatedDiscount = 7500;
        Assert.assertEquals(discount, calculatedDiscount);
    }

    @Test
    public void testRegularCustomerDiscount2() {
        long discount = Calculation.calculateDiscount("REGULAR", 175234);
        long calculatedDiscount = 33546;
        Assert.assertEquals(discount, calculatedDiscount);
    }

    @Test
    public void testRegularCustomerDiscount3() {
        long discount = Calculation.calculateDiscount("REGULAR", 1540);
        long calculatedDiscount = 0;
        Assert.assertEquals(discount, calculatedDiscount);
    }

    @Test
    public void testRegularCustomerDiscount4() {
        long discount = Calculation.calculateDiscount("REGULAR", 13200);
        long calculatedDiscount = 1140;
        Assert.assertEquals(discount, calculatedDiscount);
    }

    @Test
    public void testRegularCustomerDiscount5() {
        long discount = Calculation.calculateDiscount("REGULAR", 25000);
        long calculatedDiscount = 3500;
        Assert.assertEquals(discount, calculatedDiscount);
    }


    // The following five tests the inequality of the two values provided
    @Test
    public void testPremiumDiscount91() {
        long discount = Calculation.calculateDiscount("PREMIUM", 65000);
        long calculatedDiscount = 3500;
        Assert.assertNotEquals(discount, calculatedDiscount);
    }
    @Test
    public void testPremiumDiscount92() {
        long discount = Calculation.calculateDiscount("PREMIUM", 15000);
        long calculatedDiscount = 10;
        Assert.assertNotEquals(discount, calculatedDiscount);
    }
    @Test
    public void testPremiumDiscount93() {
        long discount = Calculation.calculateDiscount("PREMIUM", 10500);
        long calculatedDiscount = 250;
        Assert.assertNotEquals(discount, calculatedDiscount);
    }

    @Test
    public void testRegularDiscount94() {
        long discount = Calculation.calculateDiscount("REGULAR", 65000);
        long calculatedDiscount = 3500;
        Assert.assertNotEquals(discount, calculatedDiscount);
    }
    @Test
    public void testRegularDiscount95() {
        long discount = Calculation.calculateDiscount("REGULAR", 25000);
        long calculatedDiscount = 500;
        Assert.assertNotEquals(discount, calculatedDiscount);
    }
}
