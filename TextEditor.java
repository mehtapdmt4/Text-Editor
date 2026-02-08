import java.util.Scanner;

public class TextEditor {
    static char[] textArray;
    static char[] originalTextArray;
    static String[] log = new String[3];
    static int logIndex = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        enterAText(input);

        boolean running = true;
        while (running) {
            System.out.println("\nOptions:");
            System.out.println("1 - Print Text");
            System.out.println("2 - Show Statistics");
            System.out.println("3 - Convert to Lowercase");
            System.out.println("4 - Convert to Uppercase");
            System.out.println("5 - Capitalize Each Word");
            System.out.println("6 - Reverse All Characters");
            System.out.println("7 - Reverse Word Order");
            System.out.println("8 - Insert a Word");
            System.out.println("9 - Delete a Word");
            System.out.println("10 - Show Recent Operations");
            System.out.println("0 - Exit");

            int secim = input.nextInt();
            input.nextLine();

            switch (secim) {
            case 1 : printText(); break;
             case 2 : getStatistics(); break;
             case 3 : { textArray = originalTextArray.clone(); makeLowercase(); printText(); } break;
             case 4 : { textArray = originalTextArray.clone(); makeUppercase(); printText(); } break;
             case 5 : { textArray = originalTextArray.clone(); capitalizeEachWord(); printText(); } break;
             case 6 : { textArray = originalTextArray.clone(); reverseAllCharacters(); printText(); } break;
             case 7 : { textArray = originalTextArray.clone(); reverseAllWords(); printText(); } break;
             case 8 : { textArray = originalTextArray.clone(); insertAWord(input); printText(); } break;
             case 9 : { textArray = originalTextArray.clone(); deleteAWord(input); printText(); } break;
             case 10 : showLog(); break;
             case 0 : { quit(); running = false; } break;
             default : System.out.println("Invalid option!");
        }

        }
    }

    public static void enterAText(Scanner input) {
        System.out.println("Enter the text (1 to 1024 characters):");
        String text = input.nextLine();
        while (text.length() < 1 || text.length() > 1024) {
            System.out.println("Text must be between 1 and 1024 characters. Please try again:");
            text = input.nextLine();
        }
        originalTextArray = text.toCharArray();
        textArray = originalTextArray.clone();
    }

    public static void printText() {
        System.out.println(new String(textArray));
    }

    public static void getStatistics() {
        int upper = 0, lower = 0, digits = 0, symbols = 0, spaces = 0;
        for (char c : originalTextArray) {
            if (Character.isUpperCase(c)) upper++;
            else if (Character.isLowerCase(c)) lower++;
            else if (Character.isDigit(c)) digits++;
            else if (c == ' ') spaces++;
            else symbols++;
        }
        String text = new String(originalTextArray).trim();
        int words = text.isEmpty() ? 0 : text.split("\\s+").length;
        System.out.println("Uppercase letters: " + upper);
        System.out.println("Lowercase letters: " + lower);
        System.out.println("Digits: " + digits);
        System.out.println("Symbols: " + symbols);
        System.out.println("Spaces: " + spaces);
        System.out.println("Number of words: " + words);
    }

    public static void makeLowercase() {
        for (int i = 0; i < textArray.length; i++)
            textArray[i] = Character.toLowerCase(textArray[i]);
        addToLog("makeLowercase");
    }

    public static void makeUppercase() {
        for (int i = 0; i < textArray.length; i++)
            textArray[i] = Character.toUpperCase(textArray[i]);
        addToLog("makeUppercase");
    }

    public static void capitalizeEachWord() {
        boolean capitalize = true;
        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i] == ' ') {
                capitalize = true;
            } else if (capitalize && Character.isLetter(textArray[i])) {
                textArray[i] = Character.toUpperCase(textArray[i]);
                capitalize = false;
            } else {
                textArray[i] = Character.toLowerCase(textArray[i]);
            }
        }
        addToLog("capitalizeEachWord");
    }

    public static void reverseAllCharacters() {
        for (int i = 0, j = textArray.length - 1; i < j; i++, j--) {
            char temp = textArray[i];
            textArray[i] = textArray[j];
            textArray[j] = temp;
        }
        addToLog("reverseAllCharacters");
    }

    public static void reverseAllWords() {
        String[] words = new String(textArray).trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) reversed.append(" ");
        }
        textArray = reversed.toString().toCharArray();
        addToLog("reverseAllWords");
    }

    public static void insertAWord(Scanner input) {
        System.out.println("After which word index do you want to insert?");
        int index = input.nextInt();
        input.nextLine();
        System.out.println("Enter the word to insert:");
        String newWord = input.nextLine();

        String[] words = new String(textArray).trim().split("\\s+");

        index = index - 1;
        if (index < 0) index = 0;
        if (index >= words.length) index = words.length - 1;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= index; i++) result.append(words[i]).append(" ");
        result.append(newWord).append(" ");
        for (int i = index + 1; i < words.length; i++) result.append(words[i]).append(" ");
        textArray = result.toString().trim().toCharArray();
        addToLog("insertAWord");
    }

    public static void deleteAWord(Scanner input) {
        System.out.println("Which word number should be deleted?");
        int index = input.nextInt();
        input.nextLine();

        index = index - 1;

        String[] words = new String(textArray).trim().split("\\s+");
        if (index < 0 || index >= words.length) {
            System.out.println("Invalid index!");
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i != index) result.append(words[i]).append(" ");
        }
        textArray = result.toString().trim().toCharArray();
        addToLog("deleteAWord");
    }

    public static void showLog() {
        for (String op : log) {
            if (op != null) System.out.println(op);
        }
    }

    public static void quit() {
        System.out.println("Exiting the program...");
    }

    private static void addToLog(String operation) {
        log[logIndex % 3] = operation;
        logIndex++;
    }
}



