public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean earlier(SimpleDate date) {
        if(this.year < date.year) {
            return true;
        }

        if(this.year == date.year &&
            this.month < date.month) {
            return true;
        }

        return this.year == date.year && 
            this.month == date.month &&
            this.day < date.day;
    }

    public int differenceInYears(SimpleDate date) {
        if (earlier(date)) {
            return date.differenceInYears(this);
        }

        int removed = 0;

        if(this.month < date.month) {
            removed = 1;
        } else if(this.month == date.month && this.day < date.day) {
            removed = 1;
        }

        return this.year - date.year - removed;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof SimpleDate)) {
            return false;
        }

        SimpleDate date = (SimpleDate) obj;

        return this.day == date.day &&
            this.month == date.month &&
            this.year == date.year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }
}