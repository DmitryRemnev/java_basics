public class LegalPerson extends Client {

    private static final String LEGAL_PERSON = "юридическое лицо";
    private static final double ONE_PERCENT = 1.01;

    @Override
    public String getInfo() {
        return LEGAL_PERSON;
    }

    @Override
    public void take(double amountToTake) {

        if (super.canTake(amountToTake * ONE_PERCENT)) {
            super.take(amountToTake * ONE_PERCENT);
        }
    }
}