public class IndividualBusinessman extends Client {

    private static final String INDIVIDUAL_BUSINESSMAN = "индивидуальный предприниматель";
    private static final double ONE_PERCENT = 0.99;
    private static final double HALF_PERCENT = 0.995;

    @Override
    public String getInfo() {
        return INDIVIDUAL_BUSINESSMAN;
    }

    @Override
    public void put(double amountToPut) {

        if (super.canPut(amountToPut * getRightCommission(amountToPut))) {
            super.put(amountToPut * getRightCommission(amountToPut));
        }
    }

    private double getRightCommission(double amountToPut) {
        return amountToPut < 1000 ? ONE_PERCENT : HALF_PERCENT;
    }
}