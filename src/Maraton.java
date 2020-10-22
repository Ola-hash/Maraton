import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maraton {
    public String sciezka;
    public ArrayList<String> uczestnicy;
    public ArrayList<Integer> czas;

    public Maraton(String sciezka) {
        this.sciezka = sciezka;
        uczestnicy = new ArrayList<>();
        czas = new ArrayList<>();
    }

    public void wczytajPlik() {
        try {
            File file = new File(sciezka);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String wartosc = scanner.nextLine();
                String[] tab = wartosc.split("-");
                uczestnicy.add(tab[0]);
                czas.add(Integer.parseInt(tab[1]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        }
    }

    public String minutyNaGodziny(int wartosc) {
        String wynik = "";
        int liczbaMiut = wartosc % 60;
        int liczbaGodzin = wartosc / 60;
        return wynik += liczbaGodzin + "h i " + liczbaMiut + " minut, ";
    }

    public void najszybszyUczestnik() {
        int min = Integer.MAX_VALUE;
        String wartosc = null;
        int indeks = 0;
        for (int i = 0; i < czas.size(); i++) {
            if (czas.get(i) < min) {
                min = czas.get(i);
                indeks = i;
            }
        }
        String imie=uczestnicy.get(indeks);
        wartosc = minutyNaGodziny(min);
        System.out.println("Najszybszy uczestnik maratonu uzyskał czas " + wartosc+"jest to "+imie+".");
    }


    public void najwolniejszyUczestnik() {
        String wartosc = null;
        int max = Integer.MIN_VALUE;
        int indeks = 0;
        for (int i = 0; i < czas.size(); i++) {
            if (czas.get(i) > max) {
                max = czas.get(i);
                indeks = i;
            }
        }
        String imie=uczestnicy.get(indeks);
        wartosc = minutyNaGodziny(max);
        System.out.println("Najwolniejszy uczestnik maratonu uzyskal czas " + wartosc+"jest to "+imie);
    }

}
