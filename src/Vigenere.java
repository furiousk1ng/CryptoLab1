import java.util.HashMap;

public class Vigenere {
    private char[] alphabet;
    private char[][] table;
    private HashMap<Integer, Integer> asciiConverter;


    public Vigenere() {

        this.alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        this.table = new char[26][26];
        this.asciiConverter = new HashMap<Integer, Integer>();
        constructTable();
        constructAsciiConverter();
    }

    private void constructTable()
    {

        int offset = 0;
        for (int row = 0; row < this.table.length; row++)
        {
            for (int col = 0; col < this.table[row].length; col++)
            {
                int newCol = (col + offset) % 26;
                this.table[row][col] = this.alphabet[newCol];
            }
            offset++;
        }
    }

    private void constructAsciiConverter()
    {
        int[] asciiArray = new int[26];
        int asciiNum = 97;
        for (int i = 0; i < asciiArray.length; i++)
        {
            asciiArray[i] = asciiNum;
            asciiNum++;
        }

        for (int i = 0; i < asciiArray.length; i++)
        {
            this.asciiConverter.put(asciiArray[i], i);
        }
    }

    public void printAsciiConverter()
    {
        System.out.println("Looping to see pairs from 97 to 122 (lowercase ascii letters)");
        for (int i = 97; i < 123; i++)
        {
            System.out.println(i + " | " + this.asciiConverter.get(i));
        }
    }

    public void printTable()
    {
        int offset = 0;
        for (int row = 0; row < this.table.length; row++)
        {
            for (int col = 0; col < this.table[row].length; col++)
            {

                System.out.print(this.table[row][col] + " ");
            }
            System.out.println();
        }
    }

    public String encrypt(String plaintext, String keyWord)
    {
        //Remove all spaces
        plaintext = plaintext.replaceAll("\\s+", "");
        keyWord = keyWord.replaceAll("\\s+", "");

        plaintext = plaintext.toLowerCase();
        keyWord = keyWord.toLowerCase();

        char[] plaintextArray = plaintext.toCharArray();
        char[] keyWordArray = keyWord.toCharArray();
        char[] cipherText = new char[plaintextArray.length];

        int keywordLen = keyWordArray.length;

        for (int i = 0; i < plaintextArray.length; i++)
        {
            int curPlainTextCharCode = (int) plaintextArray[i];
            int curKeyWordCharCode = (int) keyWordArray[i % keywordLen];

            cipherText[i] = table[asciiConverter.get(curKeyWordCharCode)][asciiConverter.get(curPlainTextCharCode)];
        }

        return new String(cipherText);
    }

    public String decrypt(String ciphertext, String keyWord)
    {
        ciphertext = ciphertext.replaceAll("\\s+", "");
        keyWord = keyWord.replaceAll("\\s+", "");

        ciphertext = ciphertext.toLowerCase();
        keyWord = keyWord.toLowerCase();

        char[] cipherTextArray = ciphertext.toCharArray();
        char[] keyWordArray = keyWord.toCharArray();
        char[] plaintext = new char[cipherTextArray.length];

        int keywordLen = keyWordArray.length;

        for (int i = 0; i < cipherTextArray.length; i++)
        {
            int curKeyWordCharCode = (int) keyWordArray[i % keywordLen];

            int foundCol = -1;

            for (int x = 0; x < 26; x++)
            {
                //System.out.print(table[asciiConverter.get(curKeyWordCharCode)][x] + " ");

                if ( table[asciiConverter.get(curKeyWordCharCode)][x] == cipherTextArray[i] )
                {
                    foundCol = x;
                }
            }

            //System.out.println();

            plaintext[i] = table[0][foundCol];
        }


        return new String(plaintext);
    }
    }
