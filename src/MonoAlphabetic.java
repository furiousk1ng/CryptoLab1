public class MonoAlphabetic {
    String key;
    String keyUpper;
    public MonoAlphabetic(String key){
        this.key = key;
        keyUpper=key.toUpperCase();
    }


    public String Encryption(String data){

        String response = "";
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if(c>=65 && c<=92){
                int b = c-65;
                char st = keyUpper.charAt(b);
                response = response+st;
            }
            else if(c>=97 && c<=122){
                int b = c-97;
                char st = key.charAt(b);
                response = response+st;
            }
        }
        return response;
    }
    public String Decryption(String data){
        String response = "";
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if(c>=65 && c<=92){
                int a = keyUpper.indexOf(c);
                char st = (char) (a+65);
                response = response+st;
            }
            else if(c>=97 && c<=122){
                int a = key.indexOf(c);
                char st = (char) (a+97);
                response = response+st;
            }
        }
        return response;
    }
}