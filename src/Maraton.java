import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
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

    public void najszybszyUczestnik() {
        Integer najszybczyCzas = null;
        for (Integer czasUczestnika : czas) {
            najszybczyCzas = Collections.min(czas);
        }
        System.out.println("Najszybszy uczestnik maratonu uzyskał czas "+ najszybczyCzas+" sekund.");
    }

    public void najwolniejszyUczestnik() {
        Integer najwolniejszyCzas = null;
        for (Integer czasUczestnika : czas) {
            najwolniejszyCzas = Collections.max(czas);
        }
        System.out.println("Najwolniejszy uczestnik maratonu uzyskal czas "+najwolniejszyCzas+ " sekund.");

    }

}
