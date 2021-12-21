import java.time.LocalDate;

public class Arbeiter extends Mitarbeiter{

    private double stundenLohn;
    private int anzStunden;
    private double überstundenZuschlag;
    private int anzÜberstunden;
    private double praemie;
    private double schichtzulage;

    public Arbeiter(String n, char g, LocalDate gD, String a, LocalDate eD, double stundenLohn, int anzStunden, double überstundenZuschlag, int anzÜberstunden, double praemie, double schichtzulage) {
        super(n, g, gD, a, eD);
        this.stundenLohn = stundenLohn;
        this.anzStunden = anzStunden;
        this.überstundenZuschlag = überstundenZuschlag;
        this.anzÜberstunden = anzÜberstunden;
        this.praemie = praemie;
        this.schichtzulage = schichtzulage;
        String mitarbeiterId = getMitarbeiterId() + "AR";
        setMitarbeiterId(mitarbeiterId);
    }

    public double getSchichtzulage() {
        return schichtzulage;
    }

    public void setSchichtzulage(double schichtzulage) {
        this.schichtzulage = schichtzulage;
    }

    public double getStundenLohn() {
        return stundenLohn;
    }

    public void setStundenLohn(double stundenLohn) {
        this.stundenLohn = stundenLohn;
    }

    public int getAnzStunden() {
        return anzStunden;
    }

    public void setAnzStunden(int anzStunden) {
        this.anzStunden = anzStunden;
    }

    public double getÜberstundenZuschlag() {
        return überstundenZuschlag;
    }

    public void setÜberstundenZuschlag(double überstundenZuschlag) {
        this.überstundenZuschlag = überstundenZuschlag;
    }

    public int getAnzÜberstunden() {
        return anzÜberstunden;
    }

    public void setAnzÜberstunden(int anzÜberstunden) {
        this.anzÜberstunden = anzÜberstunden;
    }

    public double getPraemie() {
        return praemie;
    }

    public void setPraemie(double praemie) {
        this.praemie = praemie;
    }

    @Override
    public String toString() {
        return "Arbeiter{" +
                "stundenLohn=" + stundenLohn +
                ", anzStunden=" + anzStunden +
                ", überstundenZuschlag=" + überstundenZuschlag +
                ", anzÜberstunden=" + anzÜberstunden +
                ", praemie=" + praemie +
                ", schichtzulage=" + schichtzulage +
                '}';
    }

    public double gehalt() {
        return getAnzStunden() * getStundenLohn() + getAnzÜberstunden() * getÜberstundenZuschlag() + getSchichtzulage();
    }

    public void gehaltsErhöung(double p) {
        p = p/100;
        double sum = getStundenLohn() * p;
        setStundenLohn(getStundenLohn() * sum);
    }
}
