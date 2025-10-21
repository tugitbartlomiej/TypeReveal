// To jest komentarz - nie jest wykonywany przez program
// Każdy program w Javie musi mieć klasę
public class HelloWorld {

    // Metoda main to punkt startowy programu - tutaj zaczyna się wykonywanie
    public static void main(String[] args) {

        //Tablica
        String[] tablica = new String[5];
        tablica[0] = "Ala";
        tablica[1] = "ma";

        //Lista
        java.util.List<String> lista = new java.util.ArrayList<>();
        lista.add("Ala");
        lista.add("ma");

        //arraylist
        java.util.ArrayList<String> arrayList = new java.util.ArrayList<>();
        arrayList.add("Ala");
        arrayList.add("ma");
        arrayList.add("kota");

        String tab = tablica[0];
        lista.get(0);
        arrayList.get(0);

        // System.out.println() wyświetla tekst na ekranie
        System.out.println("Hello World!");

        // Możemy wyświetlić więcej tekstu
        System.out.println("Witaj w swiecie Javy!");
    }
}
