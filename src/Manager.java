import java.time.LocalDate;

public class Manager extends Mitarbeiter{

    private double praemie;
    private double fixGehalt;

    public Manager(String n, char g, LocalDate gD, String a, LocalDate eD, double praemie, double fixGehalt) {
        super(n, g, gD, a, eD);
        this.praemie = praemie;
        this.fixGehalt = fixGehalt;
        String mitarbeiterId = getMitarbeiterId() + "M";
        setMitarbeiterId(mitarbeiterId);
    }

    public double getPraemie() {
        return praemie;
    }

    public double getFixGehalt() {
        return fixGehalt;
    }

    public void setPraemie(double praemie) {
        this.praemie = praemie;
    }

    public void setFixGehalt(double fixGehalt) {
        this.fixGehalt = fixGehalt;
    }

    @Override
    public String toString() {
        return super.toString() + "Manager{" +
                "praemie=" + praemie +
                ", fixGehalt=" + fixGehalt +
                '}';
    }

    public double gehaltsEhoeung(double p) throws Exception {
        if(p < 10) {
            p = p/100;
            double sum = getFixGehalt() * p;
            setFixGehalt(getFixGehalt()*sum);
        } else {
            throw new Exception();
        }
        return p;
    }

    public double gehalt(double p, Angestellter a) {
        return getFixGehalt() + provision(p,a);
    }

    public double provision(double p, Angestellter a) {
        p = p / 100;
        double sum = a.gehalt() * p;
        return a.gehalt() * sum;
    }
}
