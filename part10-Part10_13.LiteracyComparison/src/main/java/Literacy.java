public class Literacy implements Comparable<Literacy> {
    private String theme;
    private String ageGroup;
    private String gender;
    private String country;
    private int year;
    private double literacyPercent;

    public Literacy(String theme, String ageGroup, String gender, String country, int year, double literacyPercent) {
        this.theme = theme;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
    }

    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literacyPercent;
    }

    @Override
    public int compareTo(Literacy literacy) {
        if(this.literacyPercent < literacy.literacyPercent) {
            return -1;
        }
        else if(this.literacyPercent > literacy.literacyPercent) {
            return 1;
        }
        return 0;
    }
}