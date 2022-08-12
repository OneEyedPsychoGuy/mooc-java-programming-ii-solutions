public class LicensePlate {
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public boolean equals(Object comparedObject) {
        if(this == comparedObject) {
            return true;
        }

        if(comparedObject == null || this.getClass() != comparedObject.getClass()) {
            return false;
        }

        LicensePlate comparedLicensePlate = (LicensePlate) comparedObject;

        if(this.liNumber.equals(comparedLicensePlate.liNumber) &&
            this.country.equals(comparedLicensePlate.country)) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.liNumber.hashCode() + this.country.hashCode();
    }
}