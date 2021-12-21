
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
            if(TextReader.fm.getMitarbeiterListe()[6] instanceof Arbeiter) {
                System.out.println(((Arbeiter) TextReader.fm.getMitarbeiterListe()[6]).gehalt());
            }
            if(TextReader.fm.getMitarbeiterListe()[1] instanceof Geschäftsführer) {
                System.out.println(((Geschäftsführer) TextReader.fm.getMitarbeiterListe()[1]).gehalt());
            }




        }catch (Exception e) {
            System.out.println(e.getMessage());
    }}
}
