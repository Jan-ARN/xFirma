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

    public static void gehaltsErhöung(String n, double p) throws Exception {
        p = p / 100;
        for (int i = 0; i < TextReader.fm.getMitarbeiterListe().length; i++) {
            switch (n) {
                case "Geschäftsführer":
                    if (TextReader.fm.getMitarbeiterListe()[i] instanceof Geschäftsführer) {
                        double sum = ((Geschäftsführer) TextReader.fm.getMitarbeiterListe()[i]).getGehalt() * p;
                        ((Geschäftsführer) TextReader.fm.getMitarbeiterListe()[i]).setGehalt(((Geschäftsführer) TextReader.fm.getMitarbeiterListe()[i]).getGehalt() + sum);
                    }
                    break;
                case "Manager":
                    if (TextReader.fm.getMitarbeiterListe()[i] instanceof Manager || p < 10) {
                        double sum = ((Manager) TextReader.fm.getMitarbeiterListe()[i]).getFixGehalt() * p;
                        ((Manager) TextReader.fm.getMitarbeiterListe()[i]).setFixGehalt(((Manager) TextReader.fm.getMitarbeiterListe()[i]).getFixGehalt() + sum);
                    }else {
                        throw new Exception("Zu viel %");
                    }
                    break;
                case "Angestellter":
                    if (TextReader.fm.getMitarbeiterListe()[i] instanceof Angestellter) {
                        double sum = ((Angestellter) TextReader.fm.getMitarbeiterListe()[i]).getGrundGehalt() * 0.05;
                        ((Angestellter) TextReader.fm.getMitarbeiterListe()[i]).setGrundGehalt(((Angestellter) TextReader.fm.getMitarbeiterListe()[i]).getGrundGehalt()+sum);
                    }
                    break;
                case "Arbeiter":
                    if (TextReader.fm.getMitarbeiterListe()[i] instanceof Arbeiter) {
                        double sum = ((Arbeiter) TextReader.fm.getMitarbeiterListe()[i]).getStundenLohn() * p;
                        ((Arbeiter) TextReader.fm.getMitarbeiterListe()[i]).setStundenLohn(((Arbeiter) TextReader.fm.getMitarbeiterListe()[i]).getStundenLohn()+sum);
                    }
                    break;
            }

        }
    }

}
