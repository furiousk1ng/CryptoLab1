public class ROT {
    String str1 = "";
    String str2 = "";// words store
    char ch,ch1; // character variables
    int i,c; // 'i' for loop , 'c' to convert letter into integer

    public String encr(String str) {
        for(i=0;i<str.length();i++)
        {
            ch= str.charAt(i); // extracting character of the string
            if(ch>='A'&&ch<='M'||ch>='a'&&ch<='m')//checking, also could be done in ASCII
            {
                c=(int)ch+13;//adding 13 to change ascii value by 13 places
                ch=(char)c;//coversting that changed ASCII value to letter
                str1=str1+ch;
            }
            else if(ch>='N'&&ch<='Z'||ch>='n'&&ch<='z')
            {
                c=(int)ch-13;
                ch=(char)c;
                str1=str1+ch;

            }
        }
        return  str1;
    }

    public String decr(String str) {
        for(i=0;i<str.length();i++)
        {
            ch= str.charAt(i); // extracting character of the string
            if(ch>='A'&&ch<='M'||ch>='a'&&ch<='m')//checking, also could be done in ASCII
            {
                c=(int)ch+13;//adding 13 to change ascii value by 13 places
                ch=(char)c;//coverting that changed ASCII value to letter
                str2=str2+ch;
            }
            else if(ch>='N'&&ch<='Z'||ch>='n'&&ch<='z')
            {
                c=(int)ch-13;//decreasing ascii val by 13
                ch=(char)c;//converting value of c to character
                str2=str2+ch;
            }
        }
        return str2;
    }
}
