package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Бутун сан жазыныз же Рим сан жазыныз: ");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        String input = scanner.nextLine();
        char[] ch = new char[10];
        char operation = 0;
        for (int i = 0; i < input.length(); i++) {
            ch[i] = input.charAt(i);
            if (ch[i] == '+') {
                operation = '+';
            }
            if (ch[i] == '-') {
                operation = '-';
            }
            if (ch[i] == '*') {
                operation = '*';
            }
            if (ch[i] == '/') {
                operation = '/';
            }
        }
        String charString = String.valueOf(ch);
        String[] massiv = charString.split("[+-/*]");
        String stable1 = massiv[0];
        String stable2 = massiv[1];
        String stable3 = stable2.trim();
        int result;
        if (number1 < 0 && number2 < 0) {
        } else {
            result = calculator(number1, number2, operation);
            System.out.println("Рим сандары үчүн жыйынтык.");
            String resultRoman = convertNumToRoman(result);
            System.out.println(stable1 + " " + operation + " " + stable3 + " = " + resultRoman);
        }
        number1 = Integer.parseInt(stable1);
        number2 = Integer.parseInt(stable3);
        result = calculator(number1, number2, operation);
        System.out.println("Бутун сандары учун  жыйынтык: ");
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
    }
    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX"
        };
        final String s = roman[numArabian];
        return s;
    }


    private static int toNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Бул маалымат жарабайт.");
        }
        return -1;
    }

    public static int calculator (int num1, int num2, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Туура эмес операция белгиси.");
        }
        return result;


    }

}
