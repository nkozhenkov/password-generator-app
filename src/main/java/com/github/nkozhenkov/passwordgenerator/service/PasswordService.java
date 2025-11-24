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

        if (!uppercase && !lowercase && !numbers && !symbols) {
            throw new IllegalArgumentException("Должен быть выбран хотя бы один тип символов!");
        }

        StringBuilder availableChars = new StringBuilder();
        if (uppercase) {
            availableChars.append(UPPERCASE);
        }

        if (lowercase) {
            availableChars.append(LOWERCASE);
        }

        if (numbers) {
            availableChars.append(NUMBERS);
        }

        if (symbols) {
            availableChars.append(SYMBOLS);
        }

        StringBuilder password = new StringBuilder();

        List<Character> guaranteedChars = new ArrayList<>();
        if (uppercase) {
            guaranteedChars.add(getRandomChar(UPPERCASE));
        }

        if (lowercase) {
            guaranteedChars.add(getRandomChar(LOWERCASE));
        }

        if (numbers) {
            guaranteedChars.add(getRandomChar(NUMBERS));
        }

        if (symbols) {
            guaranteedChars.add(getRandomChar(SYMBOLS));
        }

        for (Character c : guaranteedChars) {
            password.append(c);
        }

        while (password.length() < length) {
            char randomChar = getRandomChar(availableChars.toString());
            password.append(randomChar);
        }

        return shuffleString(password.toString());
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
