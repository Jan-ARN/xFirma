import java.time.LocalDate;

public class Geschäftsführer extends Mitarbeiter{
    private double zuschlag;

    public Geschäftsführer(String n, char g, LocalDate gD, String a, LocalDate eD, double zuschlag) {
        super(n, g, gD, a, eD);
        this.zuschlag = zuschlag;
        String mitarbeiterId = getMitarbeiterId() + "G";
        setMitarbeiterId(mitarbeiterId);
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
        double gehalt = 0;
        for (int i = 0; i < TextReader.fm.getMitarbeiterListe().length; i++) {
            if(TextReader.fm.getMitarbeiterListe()[i] != null) {
                if(TextReader.fm.getMitarbeiterListe()[i] instanceof Manager) {
                    Manager a = (Manager) TextReader.fm.getMitarbeiterListe()[i];
                    gehalt = (a.getFixGehalt() + getZuschlag());
                    break;
                }
            }

        }
        return gehalt;
    }
}
