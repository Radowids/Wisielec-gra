package pl.programujodpodstaw;

public class LetterComparator {

    public char[] compareLetter(char letter, char[] password, char[] codedPassword){
        for (int i=0; i<password.length; i++) {
            if (letter == password[i]) {
                codedPassword[i] = letter;
            }
        }
        return codedPassword;
    }
}
