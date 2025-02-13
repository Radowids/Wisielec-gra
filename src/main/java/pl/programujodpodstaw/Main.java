package pl.programujodpodstaw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isntPasswordGuessed = true;
        int counter = 0;
        int repeteCounter = 0;
        HashSet<Character> usedLetters = new HashSet<>();

        PasswordCreator passwordCreator = new PasswordCreator();
        char[] password = passwordCreator.createPassword("wiśnia");
        char[] codedPassword = new char[password.length];
        for (int i = 0; i < password.length; i++) {
            codedPassword[i] = '-';
        }
        System.out.println("Witamy w grze w wisielca! Proszę o wpisywanie pojedynczych liter aby zgadnąć hasło.");
        System.out.println(codedPassword);

        int notGuessedCounter = password.length;

        LetterComparator letterComparator = new LetterComparator();

        while (isntPasswordGuessed && counter < 10) {
            char letter = scanner.next().charAt(0);
            char[] letterToPassword = letterComparator.compareLetter(letter, password, codedPassword);
            System.out.println(letterToPassword);
            for (int i = 0; i < password.length; i++) {
                if (letter == password[i] && !usedLetters.contains(letter)) {
                    letterToPassword[i] = letter;
                    notGuessedCounter--;
                }
                if (notGuessedCounter == 0){
                    isntPasswordGuessed = false;
                }
                usedLetters.add(letter);
            }
            for (char c : password) {
                if (letter == c) {
                    repeteCounter--;
                }
            }
            if (repeteCounter > 0){
                counter++;
            }
            repeteCounter = 1;

            System.out.println("Pozostało " + (10 - counter) + " prób!");
            System.out.println("Użyte litery: " + usedLetters);
        }
        if (counter < 10) {
            System.out.print("Gratulacje! twoje hasło to: ");
            for (char c : password) {
                System.out.print(c);
            }
        } else {
            System.out.println("Koniec prób!");
        }
    }
}