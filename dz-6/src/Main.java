import java.util.*;

public class Main {


    public static void main(String[] args) {
        int firstWordsCounter = 2;
        String[] wordsArr = new String[]{"test space", "it was me", "mama", "Hoy Hoy", "Hello World", "papa", "yes", "lala", "lolo" };

        String[] filteredWordsArr = spaceDeleter(wordsArr);  //Видалення всіх пробілів в масиві слів.
        List<String> pairCharArray = (List<String>) stringToChar(filteredWordsArr, firstWordsCounter); //Пошук перших двух(або скільки передати в firstWordsCounter) слів з парною кількостью літер.
        Set<Character> uniqueLetters = uniqueChars(pairCharArray); //Пошук унікальних символів, повернення набору літер.
    }

    public static Collection<String> stringToChar(String[] wordsArr, int limit) {
        int counter = 0;
        List<String> firstTwoPairCharArray = new ArrayList<>();
        for (int i = 0; i < wordsArr.length; i++) {
            if (counter < limit) {
                boolean isGoodWord = false;
                char[] chars = wordsArr[i].toCharArray();


                Map<Character, Integer> duplicateCharSearcher = new HashMap<>();

                for (Character character : chars) {
                    if (duplicateCharSearcher.containsKey(character)) {
                        duplicateCharSearcher.put(character, duplicateCharSearcher.get(character) + 1);
                    } else {
                        duplicateCharSearcher.put(character, 1);
                    }
                }
                for (Integer key : duplicateCharSearcher.values()) {
                    if (key % 2 != 0) {
                        isGoodWord = false;
                        break;
                    } else {
                        isGoodWord = true;
                    }
                }

                if (isGoodWord) {
                    firstTwoPairCharArray.add(wordsArr[i]);
                    counter++;
                }
            } else {
                break;
            }
        }
        return firstTwoPairCharArray;
    }

    public static String[] spaceDeleter (String[] words){
        String[] noSpaceWords =  new String[words.length];
        for (int i = 0; i < words.length; i++) {
            noSpaceWords[i] = words[i].replaceAll("\\s", "");
        }
        return noSpaceWords;
    }

    public static Set<Character> uniqueChars(List<String> uniqueWords) {
        Set<Character> mySet = new HashSet<>();
        for (String word : uniqueWords) {
            for (Character character : word.toCharArray()) {
                mySet.add(character);
            }
        }
        return mySet;
    }
}