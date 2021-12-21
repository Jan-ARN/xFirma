
public class TestMain {



    public static void main(String[] args) {

        try {
            new TextReader();
            TextReader.fm.deleteAngestellte(TextReader.fm.getMitarbeiterListe()[1]);
            System.out.println(TextReader.fm);
            TextReader.fm.durschnittsAlter();
            TextReader.fm.geschlechteraufteilung();
            TextReader.fm.anzahlMitarbeiter();
            System.out.println(TextReader.fm.laengsteFirmenzugehörigkeit());


            if(TextReader.fm.getMitarbeiterListe()[1] instanceof Manager) {
                System.out.println(((Manager) TextReader.fm.getMitarbeiterListe()[1]).getFixGehalt());
            }

            Mitarbeiter.gehaltsErhöung("Manager",8);


            if(TextReader.fm.getMitarbeiterListe()[1] instanceof Manager) {
                System.out.println(((Manager) TextReader.fm.getMitarbeiterListe()[1]).getFixGehalt());
            }


        }catch (Exception e) {
            System.out.println(e.getMessage());
    }}
}
