package data;

/**
 * Used for storing archived calculation results
 * @author Piotr Paczuła
 * @version 1.0
 */
public class CalculationArchive {

    public int gcm;
    public int lcm;
    public String date;
    public CalculationArchive(int gcm, int lcm, String date){
        this.gcm = gcm;
        this.lcm = lcm;
        this.date= date;
    }
}
