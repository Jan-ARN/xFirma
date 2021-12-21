import java.time.LocalDate;

public class Angestellter extends Mitarbeiter {
    private double grundGehalt;
    private double ortsZuschlag;
    private double zulage;

    public Angestellter(String n, char g, LocalDate gD, String a, LocalDate eD, double grundGehalt, double ortsZuschlag, double zulage) {
        super(n, g, gD, a, eD);
        this.grundGehalt = grundGehalt;
        this.ortsZuschlag = ortsZuschlag;
        this.zulage = zulage;
        String mitarbeiterId = getMitarbeiterId() + "AN";
        setMitarbeiterId(mitarbeiterId);
    }

    public double getGrundGehalt() {
        return grundGehalt;
    }

    public void setGrundGehalt(double grundGehalt) {
        this.grundGehalt = grundGehalt;
    }

    public double getOrtsZuschlag() {
        return ortsZuschlag;
    }

    public void setOrtsZuschlag(double ortsZuschlag) {
        this.ortsZuschlag = ortsZuschlag;
    }

    public double getZulage() {
        return zulage;
    }

    public void setZulage(double zulage) {
        this.zulage = zulage;
    }

    public void gehaltsErhöung() {
        double sum = getGrundGehalt() * 0.05;
        setGrundGehalt(getGrundGehalt() * sum);
    }

    public double gehalt() {
        return getGrundGehalt() + getZulage() + getOrtsZuschlag();
    }

    @Override
    public String toString() {
        return  super.toString() + "Angestellter{" +
                "grundGehalt=" + grundGehalt +
                ", ortsZuschlag=" + ortsZuschlag +
                ", zulage=" + zulage +
                '}';
    }
}
