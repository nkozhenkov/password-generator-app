package com.github.nkozhenkov.passwordgenerator.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PasswordService {

    private final Random random = new Random();

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*";

    public String generatePassword(int length, boolean uppercase, boolean lowercase,
                                   boolean numbers, boolean symbols) {

        return "TestPassword123!";
    }

    private char getRandomChar(String charSet) {
        int randomIndex = random.nextInt(charSet.length());
        return charSet.charAt(randomIndex);
    }

    private String shuffleString(String input) {
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }

        StringBuilder result = new StringBuilder();
        while (!characters.isEmpty()) {
            int randomIndex = random.nextInt(characters.size());
            result.append(characters.remove(randomIndex));
        }
        return result.toString();
    }


}
