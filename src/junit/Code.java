package junit;

public class Code {

    public static boolean isSpecial(int candidate) {
        // Candidate is special if it can be divided by 11 with a remainder of 0, 1, 2 or 3.
        return candidate % 11 <= 3;
    }

    public static Character mode(String inputString) {
        if (inputString == null || inputString == "") {
            return null;
        }

        int[] charCountArray = new int[256];
        for (char c : inputString.toCharArray()) {
            charCountArray[c]++;
        }

        int maxCount = 0;
        Character mode = null;
        for (Character i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (charCountArray[c] > maxCount) {
                maxCount = charCountArray[c];
                mode = c;
            }
        }

        return mode;
    }

    public static int getCharacterCount(String allCharacters, char targetCharacter) {
        int charCount = 0;
        for (char i : allCharacters.toCharArray()) {
            if (i == targetCharacter) {
                charCount++;
            }
        }
        return charCount;
    }

    public static int longestStreak(String inputString) {
        if (inputString == null || inputString == "") {
            return 0;
        }

        int maxStreakLength = 0;
        int curStreakLength = 1;
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i) == inputString.charAt(i - 1)) {
                curStreakLength++;
            } else {
                if (maxStreakLength < curStreakLength) {
                    maxStreakLength = curStreakLength; // update maxStreak.
                }
                curStreakLength = 1; // reset curStreakLength.
            }
        }

        if (maxStreakLength < curStreakLength) {
            maxStreakLength = curStreakLength;
        }

        return maxStreakLength;
    }


    public static int[] removeDuplicates(int[] integers) {
        return null;
    }

    public static int sumIgnoringDuplicates(int[] integers) {
        return 0;
    }

}
