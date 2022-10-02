import java.util.Scanner;
class Subsyi
{
    public static String alpa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String message ;
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the key");
        String key = in.nextLine();
        key = key.toUpperCase();
        String temp = "" ;
        for (int i = 0; i < key.length(); i++)
        {
            temp += key.charAt(i);
        }
        for (int i = 0; i< 26; i++)
        {
            temp += (char)(i+65);
        }

        for (int i = 0; i <temp.length(); i++)
        {
            Boolean found = false;
            for (int j = 0; j < key.length(); j++ )
            {
                if (temp.charAt(i) == key.charAt(j))
                {
                    found = true;
                    break;
                }
            }
            if (found == false)
            {
                key += temp.charAt(i);
            }
        }

        System.out.println("enter the message");
        message = in.nextLine();
        message = message.toUpperCase();


        String encrypt = "";
        for (int i = 0; i < message.length(); i++)
        {
            if (message.charAt(i) == (char)32)
            {
                encrypt += " ";
            } else
            {
                int count = 0;
                for (int j = 0; j< alpa.length(); j++)
                {
                    if(message.charAt(i) == alpa.charAt(j))
                    {
                        encrypt += key.charAt(count);
                        break;
                    } else
                    {
                        count++;
                    }
                }
            }
        }
        System.out.println("enctypt Text: " + encrypt);


        String dec = "";
        for (int i = 0; i < message.length(); i++)
        {
            if (message.charAt(i) == (char)32)
            {
                dec += " ";
            }else
            {
                int count = 0;
                for (int j = 0; j < alpa.length(); j++)
                {
                    if (message.charAt(i) == alpa.charAt(j)){
                        dec += alpa.charAt(count);
                        break;
                    } else
                    {
                        count++;
                    }
                }
            }

        }
        System.out.println("Decript message : " +dec);

    }
}