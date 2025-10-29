import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        double original = getOriginalCost();

        int currentYear = LocalDate.now().getYear();
        int age = currentYear - year;
        if (age < 0) {
            age = 0;
        }

        double valueAfterVehicleAgeDepreciation = original;
        if (age <= 3) {
            double reduction = original * (0.03 * age);
            valueAfterVehicleAgeDepreciation = original - reduction;
        } else if (age <= 6) {
            double reduction = original * (0.06 * age);
            valueAfterVehicleAgeDepreciation = original - reduction;
        } else if (age <= 10) {
            double reduction = original * (0.08 * age);
            valueAfterVehicleAgeDepreciation = original - reduction;
        } else {
            int yearsOverTen = age - 10;
            double reduction = 1000.0 * yearsOverTen;
            valueAfterVehicleAgeDepreciation = original - reduction;
        }

        String modelName= "";
        if (makeModel != null) {
            modelName = makeModel.toLowerCase();
        }

        boolean isHondaOrToyota = modelName == "hondo" || modelName == "toyota";

        double finalValue = valueAfterVehicleAgeDepreciation;
        if  ( odometer > 10000 && !isHondaOrToyota ) {
            finalValue = finalValue * 0.75;
        }

        if (finalValue < 0 ) {
            finalValue = 0.0;
        }

        return finalValue;

    }
}
