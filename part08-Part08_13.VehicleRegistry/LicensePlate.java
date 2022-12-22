public class LicensePlate {
    private String country;
    private String license;

    public LicensePlate(String country, String license) {
        this.country = country;
        this.license = license;
    }

    @Override
    public int hashCode() {
        return this.country.hashCode() + this.license.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof LicensePlate)) {
            return false;
        }

        LicensePlate plate = (LicensePlate) obj;

        return this.license.equals(plate.license) &&
            this.country.equals(plate.country);
    }

    @Override
    public String toString() {
        return this.country + " " + this.license;
    }
}