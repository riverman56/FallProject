public Class Date{

    public int day;
    public int month;
    public int year;

    public Date(int mm,  int dd, int yyyy){
        month = mm;
        day = dd;
        year = yyyy;
    }

    public boolean compareDates(Date other){ //true means this date is later than other or on the same day, false means this date is before other
        if(year>other.year){
            return true;
        }
        if(year< other.year){
            return false;
        }
        if(month> other.month){
            return true;
        }
        if(month < other.month){
            return false;
        }
        if(day > other.day){
            return true;
        }
        if(day < other.day){
            return false;
        }
        return true;
    }

    public String toString(){
        return month + "/" + day + "/" + year;
    }
}