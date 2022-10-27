import HomophonicCipher.HomophonesArray;
import HomophonicCipher.HomophonicDecoder;
import HomophonicCipher.HomophonicEncoder;
import HomophonicCipher.SimpleHomophonesArrayGenerator;
import HomophonicCipher.impl.NDigitsHomophonicDecoder;
import HomophonicCipher.impl.SimpleHomophonesArrayGeneratorImpl;
import HomophonicCipher.impl.SimpleHomophonicEncoder;

public class Main {
    public static void main(String[] args) {
         int HOMOPHONES_NUMBER = 3;
         int NUMBER_OF_ALPHABET_LETTERS = 26;
         int FIRST_ALPHABET_LETTER_ASCII_POSITION = 97;
         int NUMBER_OF_DIGITS_TO_ENCODE_LETTER = 2;
         int MIN_HOMOPHONE_VALUE = 10;
         int MAX_HOMOPHONE_VALUE = 99;


        // Plain text to encode
        String text = "vova";

        // Generate a random array of homophones for 26 letters (with 3 homophones each with values from 10 to 99), to encode the text
        SimpleHomophonesArrayGenerator simpleHomophonesArrayGenerator = new SimpleHomophonesArrayGeneratorImpl(
                NUMBER_OF_ALPHABET_LETTERS, MIN_HOMOPHONE_VALUE, MAX_HOMOPHONE_VALUE);
        HomophonesArray homophonesArray = simpleHomophonesArrayGenerator.generate(HOMOPHONES_NUMBER);

        // Prepare simple encoder (which operates on ascii alphabet)
        HomophonicEncoder homophonicEncoder = new SimpleHomophonicEncoder(FIRST_ALPHABET_LETTER_ASCII_POSITION);

        // Prepare 2 digits cipher decoder (digits number depends on the MIN and MAX homophone values)
        HomophonicDecoder homophonicDecoder = new HomophonicCipher.impl.NDigitsHomophonicDecoder(FIRST_ALPHABET_LETTER_ASCII_POSITION, NUMBER_OF_DIGITS_TO_ENCODE_LETTER);

        String encodedText = homophonicEncoder.encode(text, homophonesArray);
        System.out.println("Homophones array:" + homophonesArray.toString());
        System.out.println("Encoded text: " + encodedText);
        System.out.println("Decoded text: " + homophonicDecoder.decode(encodedText, homophonesArray));

        PermutationCipher aa = new PermutationCipher();
        String enccstr = aa.encrypt("столбцевойперестановочныйшифр");
        String decrstr = aa.decrypt("собеопрсаоонйиртлцвйеетнвчышф");
        System.out.println(enccstr);
        System.out.println(decrstr);
        MonoAlphabetic mono = new MonoAlphabetic("zyxwvutsrqponmlkjihgfedcba");
        String enc = mono.Encryption("v");
        String dec = mono.Decryption("wvuVovaFilinotsrq");
        System.out.println("Моноалфавитный шифр: " +  enc);
        System.out.println("Моноалфавитный шифр: " +  dec);


        TaskFour tf = new TaskFour();
        tf.setKey("crypto");
        tf.KeyGen();
        System.out.println("Шифрование(Задание 4): " + tf.encryptMessage("whatdo"));
        System.out.println("Расшифровка(Задание 4): " + tf.decryptMessage("ynerea"));
        Vigenere vig = new Vigenere();
        System.out.println("Зашифрованное сообщение(Виженера): " + vig.encrypt("Vova", "davc"));
        System.out.println("Расшифрованное сообщение(Виженера): " + vig.decrypt("yoqc", "davc"));
        Ceaser ceaser = new Ceaser();
        System.out.println(ceaser.decrypt("Pbatenghyngvbaf! Vg'f n Pnrfne pvcure!",13));
        ROT rot = new ROT();
        System.out.println("Зашифрованное сообщение(ROT13): " + rot.encr("abcd"));
        System.out.println("Расшифрованное сообщение:(ROT13): " + rot.decr("nopq"));


    }
}