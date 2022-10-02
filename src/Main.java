public class Main {
    public static void main(String[] args) {
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