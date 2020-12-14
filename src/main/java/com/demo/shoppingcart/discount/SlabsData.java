package com.demo.shoppingcart.discount;

public class SlabsData {
    public static void printSlabs(CustomerTypeEnum type) {
        if(type.equals(CustomerTypeEnum.REGULAR)) {
            System.out.println(" :: Regular Slabs :: \n\t[0 - 5000] => 0%" +
                    "\n\t[5000 - 10000] => 10%\n\t[10000 - more] => 20%\n");
        }else {
            System.out.println(" :: Premium Slabs :: \n\t[0 - 4000] => 10%" +
                    "\n\t[4000 - 8000] => 15%\n\t[8000 - 12000] => 20%\n\t" +
                    "[12000 - more] => 30%\n");
        }
    }

    public static Slab[] getRegularCustomerSlabs() {
        Slab firstSlab = new Slab(0, 5000, 0, CustomerTypeEnum.REGULAR);
        Slab secondSlab = new Slab(5000, 10000, 10, CustomerTypeEnum.REGULAR);
        Slab thirdSlab = new Slab(10000, 99999999, 20, CustomerTypeEnum.REGULAR);

        Slab[] regularCustomerSlabs = {firstSlab, secondSlab, thirdSlab};
        return regularCustomerSlabs;
    }

    public static Slab[] getPremiumCustomerSlabs() {
        Slab firstSlab = new Slab(0, 4000, 10, CustomerTypeEnum.PREMIUM);
        Slab secondSlab = new Slab(4000, 8000, 15, CustomerTypeEnum.PREMIUM);
        Slab thirdSlab = new Slab(8000, 12000, 20, CustomerTypeEnum.PREMIUM);
        Slab fourthSlab = new Slab(12000, 99999999, 30, CustomerTypeEnum.PREMIUM);

        Slab[] premiumCustomerSlabs = {firstSlab, secondSlab, thirdSlab, fourthSlab};

        return premiumCustomerSlabs;
    }
}
