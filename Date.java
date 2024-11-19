public class Date {
    public int day;
    public int month;
    public int year;

    public Date(int mm, int dd, int yyyy) {
        month = mm;
        day = dd;
        year = yyyy;
    }

    // true means this date is >= other
    // false means this date is before other
    public boolean compare(Date other) {
        if (year > other.year)
            return true;

        if (year < other.year)
            return false;

        if (month > other.month)
            return true;

        if (month < other.month)
            return false;

        if (day > other.day)
            return true;

        if (day < other.day)
            return false;

        return true;
    }

    public int difference(Date other) {
        return 365*(other.year - year) + 30*(other.month - month) + (other.day - day);
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }
}