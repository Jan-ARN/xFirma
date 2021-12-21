import java.time.LocalDate;

public class Mitarbeiter {

    private String name;
    private char geschlecht;
    private LocalDate gebDatum;
    private String adresse;
    private LocalDate einDatum;
    private static int count = 1;
    private String MitarbeiterId;

    public Mitarbeiter(String n, char g, LocalDate gD, String a, LocalDate eD) {
        this.name = n;
        this.geschlecht = g;
        this.gebDatum = gD;
        this.adresse = a;
        this.einDatum = eD;
        String mitarbeiterId = String.valueOf(getGeschlecht() + getGebDatum().getYear() + getName().charAt(0) + count);
        setMitarbeiterId(mitarbeiterId);
        count++;
    }


    //getter


    public String getMitarbeiterId() {
        return MitarbeiterId;
    }

    public String getName() {
        return name;
    }

    public char getGeschlecht() {
        return geschlecht;
    }

    public LocalDate getGebDatum() {
        return gebDatum;
    }

    public String getAdresse() {
        return adresse;
    }

    public LocalDate getEinDatum() {
        return einDatum;
    }

    //setter


    public void setMitarbeiterId(String mitarbeiterId) {
        MitarbeiterId = mitarbeiterId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGeschlecht(char geschlecht) {
        this.geschlecht = geschlecht;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
                "name='" + name + '\'' +
                ", geschlecht=" + geschlecht +
                ", gebDatum=" + gebDatum +
                ", adresse='" + adresse + '\'' +
                ", einDatum='" + einDatum + '\'' +
                '}';
    }
}
