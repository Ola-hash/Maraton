public class Main {
    public static void main(String[] args) {
        Maraton maraton = new Maraton("result.txt");
        maraton.wczytajPlik();
        maraton.najszybszyUczestnik();
        maraton.najwolniejszyUczestnik();
    }
}
