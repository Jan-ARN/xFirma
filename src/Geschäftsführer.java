import java.time.LocalDate;

public class Geschäftsführer extends Mitarbeiter{
    private double zuschlag;
    private double gehalt;

    public Geschäftsführer(String n, char g, LocalDate gD, String a, LocalDate eD, double zuschlag,double gehalt) {
        super(n, g, gD, a, eD);
        this.zuschlag = zuschlag;
        this.gehalt = gehalt;
        String mitarbeiterId = getMitarbeiterId() + "G";
        setMitarbeiterId(mitarbeiterId);
    }

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }

    public double getZuschlag() {
        return zuschlag;
    }

    public void setZuschlag(double zuschlag) {
        this.zuschlag = zuschlag;
    }

    @Override
    public String toString() {
        return super.toString() + "Geschäftsführer{" +
                "zuschlag=" + zuschlag +
                '}';
    }

    public double gehalt() {
        return getGehalt()+getZuschlag();
    }
}
