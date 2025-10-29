public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int loftSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int loftSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.loftSize = loftSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLoftSize() {
        return loftSize;
    }

    public void setLoftSize(int loftSize) {
        this.loftSize = loftSize;
    }

    @Override
    public double getValue() {
        double perSquareFt;
        switch (condition) {
            case 1 : perSquareFt = 180.0;
                System.out.println("Excellent");
            break;
            case 2 : perSquareFt = 130.0;
                System.out.println("Good");
            break;
            case 3 : perSquareFt = 90.0;
                System.out.println("Fair");
            break;
            case 4 :perSquareFt = 80.0;
                System.out.println("Poor");
            break;
            default: perSquareFt = 90.0;
            break;
        }

        double houseValue = perSquareFt * squareFoot;
        double lotValue = 0.25 * loftSize;
        return houseValue + lotValue;
    }
}
