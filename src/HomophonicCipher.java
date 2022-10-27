//import java.util.Arrays;
//import java.util.Random;
//
//public class HomophonicCipher {
//    private final int NUMBER_OF_ALPHABET_LETTERS;
//    private final int FIRST_ALPHABET_LETTER_ASCII_POSITION;
//    private final int MAX_HOMOPHONE_VALUE;
//    private final int MIN_HOMOPHONE_VALUE;
//
//    public HomophonicCipher(int numberOfAlphabetLetters, int minHomophoneValue, int maxHomophoneValue) {
//        NUMBER_OF_ALPHABET_LETTERS = numberOfAlphabetLetters;
//        MAX_HOMOPHONE_VALUE = maxHomophoneValue;
//        MIN_HOMOPHONE_VALUE = minHomophoneValue;
//    }
//
//    @Override
//    public HomophonesArray generate(int numberOfHomophones) {
//        HomophonesArray homophonesArray = new SimpleHomophonesArray(NUMBER_OF_ALPHABET_LETTERS, numberOfHomophones);
//        Set<Integer> uniqueNumbers = new HashSet<>();
//        Random random = new Random();
//        for (int i = 0; i < homophonesArray.getNumberOfLetters(); i++) {
//            for (int j = 0; j < homophonesArray.getNumberOfHomophones()[i]; j++) {
//                homophonesArray.add(getRandomUniqueNumber(random, uniqueNumbers), i, j);
//            }
//        }
//        return homophonesArray;
//    }
//
//    private int getRandomUniqueNumber(Random random, Set<Integer> uniqueNumbers) {
//        int randomUniqueNumber = random.nextInt((MAX_HOMOPHONE_VALUE + 1) - MIN_HOMOPHONE_VALUE) + MIN_HOMOPHONE_VALUE;
//        if (!uniqueNumbers.add(randomUniqueNumber)) {
//            return getRandomUniqueNumber(random, uniqueNumbers);
//        }
//        return randomUniqueNumber;
//    }
//    public HomophonicCipher(int firstAlphabetLetterAsciiPosition) {
//        FIRST_ALPHABET_LETTER_ASCII_POSITION = firstAlphabetLetterAsciiPosition;
//    }
//
//    @Override
//    public String encode(String text, HomophonesArray homophonesArray) {
//        StringBuilder encryptedText = new StringBuilder();
//        Random random = new Random();
//        for (int i = 0; i < text.length(); i++) {
//            if (text.charAt(i) == 32) {
//                encryptedText.append(" ");
//                continue;
//            }
//            encryptedText.append(
//                    homophonesArray.get(text.charAt(i) - FIRST_ALPHABET_LETTER_ASCII_POSITION, random.nextInt(3)));
//        }
//        return encryptedText.toString();
//    }
//    private final int[][] homophones;
//
//    private final int numberOfLetters;
//    private final int numberOfHomophones;
//
//    public SimpleHomophonesArray(int numberOfLetters, int numberOfHomophones) {
//        this.numberOfLetters = numberOfLetters;
//        this.numberOfHomophones = numberOfHomophones;
//        this.homophones = new int[numberOfLetters][numberOfHomophones];
//    }
//
//    public int get(int letterIndex, int homophoneIndex) {
//        return homophones[letterIndex][homophoneIndex];
//    }
//
//    public void add(int homophone, int letterIndex, int homophoneIndex) {
//        homophones[letterIndex][homophoneIndex] = homophone;
//    }
//
//    public int getLetterByHomophone(int homophone) {
//        for (int i = 0; i < homophones.length; i++) {
//            for (int j = 0; j < homophones[i].length; j++) {
//                if(homophones[i][j] == homophone) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    public int getNumberOfLetters() {
//        return numberOfLetters;
//    }
//
//    public int[] getNumberOfHomophones() {
//        int[] numberOfHomophones = new int[numberOfLetters];
//        Arrays.fill(numberOfHomophones, this.numberOfHomophones);
//        return numberOfHomophones;
//    }
//
//    @Override
//    public String toString() {
//        return Arrays.deepToString(homophones);
//    }
//    private final int FIRST_ALPHABET_LETTER_ASCII_POSITION;
//    private final int NUMBER_OF_DIGITS;
//
//    public NDigitsHomophonicDecoder(int firstAlphabetLetterAsciiPosition, int numberOfDigits) {
//        FIRST_ALPHABET_LETTER_ASCII_POSITION = firstAlphabetLetterAsciiPosition;
//        NUMBER_OF_DIGITS = numberOfDigits;
//    }
//
//    @Override
//    public String decode(String encodedText, HomophonesArray homophonesArray) {
//        StringBuilder decryptedText = new StringBuilder();
//        for (int i = 0; i < encodedText.length(); i += NUMBER_OF_DIGITS) {
//            if (encodedText.charAt(i) == 32) {
//                decryptedText.append(" ");
//                i++;
//            }
//            int encodedChar = Integer.parseInt(encodedText.substring(i, i + NUMBER_OF_DIGITS));
//            char decryptedChar = (char) (homophonesArray.getLetterByHomophone(encodedChar) + FIRST_ALPHABET_LETTER_ASCII_POSITION);
//            decryptedText.append(decryptedChar);
//        }
//        return decryptedText.toString();
//    }
//
//    }
//
