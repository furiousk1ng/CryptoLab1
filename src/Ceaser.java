import java.util.ArrayList;

public class Ceaser {
    public static String decrypt(String str, int shift) {

        char ch2[]=str.toCharArray();//Convert the string passed in into a character array and store the elements in array ch2
        char ch4; //Variable to be used to hold the substitute character (plain text character)
        String plainText = "";


        for(int i=0;i<str.length();i++) //Loop through each character in the array until reaching the end
        {
            if(Character.isLetter(ch2[i]))
            {
                if(Character.isUpperCase(ch2[i]))
                {
                    ch4=(char)(((int)ch2[i]-shift-65+26)%26+65); //Perform reverse shift on uppercase character
                }
                else
                {
                    ch4=(char)(((int)ch2[i]-shift-97+26)%26+97); //Perform reverse shift on lowercase character
                }
                //Append the character in ch4 to the string variable named plaintext
                plainText=plainText+ch4;
            }
            else
            {
                //Append unconverted non-alphabetic character to the string variable plaintext
                plainText=plainText+ch2[i];
            }
        }
        return plainText;
    }
}
