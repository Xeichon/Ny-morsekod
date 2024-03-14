import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeConverter {
    private static final Map<String, String> morseToEnglish = new HashMap<>();
    private static final Map<String, String> englishToMorse = new HashMap<>();

    static {
        String[][] morseEnglishMap = {
                {".-", "A"}, {"-...", "B"}, {"-.-.", "C"}, {"-..", "D"}, {".", "E"},
                {"..-.", "F"}, {"--.", "G"}, {"....", "H"}, {"..", "I"}, {".---", "J"},
                {"-.-", "K"}, {".-..", "L"}, {"--", "M"}, {"-.", "N"}, {"---", "O"},
                {".--.", "P"}, {"--.-", "Q"}, {".-.", "R"}, {"...", "S"}, {"-", "T"},
                {"..-", "U"}, {"...-", "V"}, {".--", "W"}, {"-..-", "X"}, {"-.--", "Y"},
                {"--..", "Z"}, {"--..--", ","}, {"..--..", "?"}, {".-.-.-", "."}, {"-.-.--","!"}
        };

        for (String[] pair : morseEnglishMap) {
            morseToEnglish.put(pair[0], pair[1]);
            englishToMorse.put(pair[1], pair[0]);
        }
    }

    public static String morseToEnglish(String morseCode) {
        StringBuilder result = new StringBuilder();
        for (String morseWord : morseCode.split(" / ")) {
            for (String morseChar : morseWord.split(" ")) {
                result.append(morseToEnglish.getOrDefault(morseChar, ""));
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    public static String englishToMorse(String englishText) {
        StringBuilder result = new StringBuilder();
        for (char c : englishText.toUpperCase().toCharArray()) {
            if (c == ' ') {
                result.append(" / ");
            } else {
                result.append(englishToMorse.getOrDefault(String.valueOf(c), "")).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välkommen till MorseCodeConverter!");
        System.out.println("1. Översätt morsekod till engelska");
        System.out.println("2. Översätt engelska till morsekod");
        System.out.print("Välj alternativ (1 eller 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("Ange morsekod: ");
            String morseCode = scanner.nextLine();
            String englishText = morseToEnglish(morseCode);
            System.out.println("Engelsk text: " + englishText);
        } else if (choice == 2) {
            System.out.print("Ange engelsk text: ");
            String englishText = scanner.nextLine();
            String morseCode = englishToMorse(englishText);
            System.out.println("Morsekod: " + morseCode);
        } else {
            System.out.println("Ogiltigt val. Avslutar programmet.");
        }

        scanner.close();
    }
}
