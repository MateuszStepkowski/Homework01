package pl.coderslab.collection;

public class Main3 {

    static boolean verifyLogin(String email){

        String pattern ="^([a-z]|[A-Z]|[-_])[\\w-]{4,}$";

        if (email.matches(pattern)){return true;}
        else return false;
    }
}
