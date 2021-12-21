import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TextReader {
    public static Software fm = new Software();
    public TextReader() throws FileNotFoundException {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("D:\\schule\\Java\\JavaProjekt\\src\\personen.txt"));
            String line;
            int zeile = 0;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(", ");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate geb = LocalDate.parse(strings[4], timeFormatter);
                LocalDate eintritt = LocalDate.parse(strings[5], timeFormatter);
                String name = strings[1];
                String address = strings[2];
                char ges = strings[3].charAt(0);
                if(strings[0].equals("Angestellter")) {
                    double gehalt = Double.parseDouble(strings[6]);
                    double ortsZuschlag = Double.parseDouble(strings[7]);
                    double zulage = Double.parseDouble(strings[8]);
                    fm.addAngestellte(new Angestellter(name,ges,geb,address,eintritt,gehalt,ortsZuschlag,zulage));
                } else if(strings[0].equals("Arbeiter")) {
                    double sL = Double.parseDouble(strings[6]);
                    int aZ = Integer.parseInt(strings[7]);
                    double üZ = Double.parseDouble(strings[8]);
                    int aZÜ = Integer.parseInt(strings[9]);
                    double schichtZulage = Double.parseDouble(strings[10]);
                    double p = Double.parseDouble(strings[11]);
                    fm.addAngestellte(new Arbeiter(name, ges, geb, address, eintritt,sL,aZ,üZ,aZÜ,p,schichtZulage));
                } else if(strings[0].equals("Manager")) {
                    double p = Double.parseDouble(strings[6]);
                    double fG = Double.parseDouble(strings[7]);
                    fm.addAngestellte(new Manager(name,ges,geb,address,eintritt,p,fG));

                } else if(strings[0].equals("Geschäftsführer")) {
                    double z = Double.parseDouble(strings[6]);
                    double g =Double.parseDouble(strings[7]);
                    fm.addAngestellte(new Geschäftsführer(name,ges,geb,address,eintritt,z,g));
                } else {
                    throw new Exception("FEHLER");
                }
                zeile++;

            }
            System.out.println(fm);
        }catch (Exception e) {
            e.getMessage();
        }
    }
}
