package pages;

import java.util.ArrayList;

public class ArraySum {

    private static int sum;
    private static int[] numbers ={1, 2, 3};

   private static String[] array1 = {"Python", "JAVA", "PHP", "C#", "C++", "SQL"};

    private static String[] array2 = {"MySQL", "SQL", "SQLite", "Oracle", "PostgreSQL", "DB2", "JAVA"};

    private static ArrayList<String> commonElements = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("The first array: " + array1);
        System.out.println("The second array: " + array2);

        System.out.println("Common Elements: " + findCommonElements());
    }
    public static int sumArrayNumbers( ) {

        for (int number: numbers) {

            sum += number;
        }
        return sum;
    }

    public static ArrayList<String> findCommonElements() {

        for (String array1Element : array1) {
            for (String array2Element : array2) {
                if (array1Element.equalsIgnoreCase(array2Element))
                    commonElements.add(array2Element);
            }

        }
        return commonElements;
    }
}
