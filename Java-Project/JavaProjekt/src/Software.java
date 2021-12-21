import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Software {

    private Mitarbeiter[] mitarbeiterListe = new Mitarbeiter[20];
    private Mitarbeiter[] alteMitarbeiterListe = new Mitarbeiter[20];

    public Mitarbeiter[] getMitarbeiterListe() {
        return mitarbeiterListe;
    }

    public Mitarbeiter[] getAlteMitarbeiterListe() {
        return alteMitarbeiterListe;
    }

    @Override
    public String toString() {
        return "Software{" +
                "mitarbeiterListe=" + Arrays.toString(mitarbeiterListe) +
                ", alteMitarbeiterListe=" + Arrays.toString(alteMitarbeiterListe) +
                '}';
    }

    public boolean addAngestellte(Mitarbeiter angestellte) {
        boolean added = false;
        for(int i = 0; i < getMitarbeiterListe().length; i++) {
            if(getMitarbeiterListe()[i] == null) {
                getMitarbeiterListe()[i] = angestellte;
                added = true;
                break;
            }
        }
        return added;
    }

    public boolean deleteAngestellte(Mitarbeiter mitarbeiter) {
        boolean found = false;
        ;
        for (int i = 0; i < getMitarbeiterListe().length; i++) {
            if (getMitarbeiterListe()[i] != null) {
                if (getMitarbeiterListe()[i].getMitarbeiterId().equalsIgnoreCase(mitarbeiter.getMitarbeiterId())) {
                    getMitarbeiterListe()[i] = null;
                    found = true;
                    break;
                }
            } else {
                continue;
            }
        }
        for (int b = 0; b < getAlteMitarbeiterListe().length; b++) {
            if (getAlteMitarbeiterListe()[b] == null) {
                getAlteMitarbeiterListe()[b] = getMitarbeiterListe()[b];
                break;
            } else {
                continue;
            }
        }
        return found;
    }

    public void durschnittsAlter() {
        int counter = 1;
        int alter = 0;
        for (int i = 0; i < getMitarbeiterListe().length; i++) {
            if (getMitarbeiterListe()[i] != null) {
                alter += Period.between(getMitarbeiterListe()[i].getGebDatum(), LocalDate.now()).getYears();
            } else {
                continue;
            }
            counter++;
        }
        System.out.println("Durschnittsalter = " + alter / counter);
    }


    public void geschlechteraufteilung() {
        int M = 0;
        int W = 0;
        for (int i = 0; i < getMitarbeiterListe().length; i++) {
            if (getMitarbeiterListe()[i] != null) {
                if (getMitarbeiterListe()[i].getGeschlecht() == 'M') {
                    M++;
                } else if (getMitarbeiterListe()[i].getGeschlecht() == 'W') {
                    W++;
                }
            } else {
                continue;
            }
        }
        System.out.println("Es gibt " + M + " Männer und " + W + " Frauen");
    }


    public void anzahlMitarbeiter() {
        int counter = 0;
        for (int i = 0; i < getMitarbeiterListe().length; i++) {
            if (getMitarbeiterListe()[i] != null) {
                counter++;
            } else {
                continue;
            }
        }
        System.out.println("Es gibt " + counter + " Mitarbeiter");
    }


    public Mitarbeiter laengsteFirmenzugehörigkeit() {
        Mitarbeiter b;
        Mitarbeiter a = getMitarbeiterListe()[0];
        for (int i = 0; i < getMitarbeiterListe().length; i++) {
            if (getMitarbeiterListe()[i] != null) {
                b = getMitarbeiterListe()[i];
                int p1 = Period.between(b.getEinDatum(), LocalDate.now()).getDays() + Period.between(b.getEinDatum(), LocalDate.now()).getMonths() + Period.between(b.getEinDatum(), LocalDate.now()).getYears();
                int p2 = Period.between(a.getEinDatum(), LocalDate.now()).getDays() + Period.between(a.getEinDatum(), LocalDate.now()).getMonths() + Period.between(a.getEinDatum(), LocalDate.now()).getYears();
                if (p1 > p2) {
                    a = getMitarbeiterListe()[i];
                }
            } else {
                continue;
            }
        }
        return a;
    }
}
