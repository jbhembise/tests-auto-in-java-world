package jbhembise.testauto.discount;

public class DiscountCalculator {

    private static int DISCOUNT_PERCENTAGE_BETWEEN_500_AND_1000 = 5;
    private static int DISCOUNT_PERCENTAGE_BETWEEN_1000_AND_2000 = 10;
    private static int DISCOUNT_PERCENTAGE_GREATER_THAN_2000 = 15;

    /**
     * Calculate percentage of discount.
     * Between 500 and 1000 : 5%.
     * Between 1000 and 2000 : 10%.
     * After 2000 : 15%.
     *
     * @param quantity the amount of product ordered.
     * @return the discount percentage
     */
    public static int calculatePercentage(int quantity) {
        if (quantity >= 500 && quantity < 1000) {
            return DISCOUNT_PERCENTAGE_BETWEEN_500_AND_1000;
        } else if (quantity >= 1000 && quantity < 2000) {
            return DISCOUNT_PERCENTAGE_BETWEEN_1000_AND_2000;
        } else if (quantity >= 2000) {
            return DISCOUNT_PERCENTAGE_GREATER_THAN_2000;
        }
        return 0;
    }
}
