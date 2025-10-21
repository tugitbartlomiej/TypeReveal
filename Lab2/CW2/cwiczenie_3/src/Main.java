import lib.Util;

public class Main {

    public static void main(String[] args) throws Exception {
        // Instrukcje warunkowe
        int num = 1000;

        if (num < 100) {
            System.out.println("Mała liczba");
        } else if (num > 100) {
            System.out.println("Duża liczba");
        } else {
            System.out.println("100");
        }

        lib.Util.runOrcEncounter();

        // !!ZADANIE!! Znajdź w kodzie library/src/Util.java, linijki kodu odpowiedzialne za wyświetlenie na ekranie
        // opcji dla gracza. Napisz komentarz poniżej na których linijkach je znajdziesz.

        // !!ZADANIE!! Wymyśl dwa dodatkowe opcje dla gracza i dodaj je do gry.

        // !!ZADANIE!! Znajdź gdzie w kodzie rejestruje się wybór gracza. Rozbuduj używając instrukcji warunkowych
        // 5 różnych odpowiedzi na wybór gracza zmieniając wartość "outcome".

        // !!ZADANIE!! Zrób kopię funkcji ShowGameOver i zmień nazwę na ShowWin. Zmień następujące wartośći.
        // 1.) ForegroundColor na zielony
        // 2.) Zmien string dead na alive i wykorzystaj ponizszy tekst.
//        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⣶⡿⠡⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡎⢳⠤⠃⠀⠀⢠⣤⡀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡰⢉⣩⠑⠑⢉⠶⢀⠀⠀⢈⣽⠁⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⠀⠀⠀⢀⡴⣁⠩⠚⣿⣶⣁⠀⢀⣞⠢⣠⠊⠇⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⠀⠀⠀⠀⢇⢱⠀⠀⣴⡌⠡⢊⠝⠈⠒⠇⠜⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⠀⠀⠀⠀⠈⡾⠄⢠⣿⠃⠄⢾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠊⢸⣧⣴⣶⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣿⣿⡟⠟⠃⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠟⠀⡨⠋⠉⠓⠧⢤⡀⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⠀⠀⠀⡠⠖⢅⠔⠉⠀⠀⠀⠀⠀⠜⠛⡜⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⠀⠀⡔⢁⠔⠁⠀⠀⠀⠀⠀⠀⡼⢀⠌⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⢀⡤⠾⡔⠁⠀⠀⠀⠀⠀⠀⠀⣰⢡⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠀⠀⠀⠀⢻⢸⠃⠀⠀⠀⠀⠀⠀⠀⠘⠤⡙⠆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⠤⠤⠤⠤⠬⠮⠆⠄⢀⡀⠤⠤⠤⠀⠀⠀⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
//        ⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀
//        ⣿⣯⣯⣝⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
        // 3.) Zmień string GAME OVER


        // !!ZADANIE!! Wybierz jedno z pięciu opcji gracza jako opcje zwycięstwa i wykorzystaj intsrukcje warunkowe
        // żeby ta opcja zwróciła funckje ShowWin.
    }
}
