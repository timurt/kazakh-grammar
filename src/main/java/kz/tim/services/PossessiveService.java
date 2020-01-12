package kz.tim.services;

import kz.tim.enums.Form;
import kz.tim.enums.Quantity;

/**
 * Documentation for {@code PossessiveService}.
 *
 * @author Timur Tibeyev.
 */
public class PossessiveService implements Service {
    private Form possessive;
    private Quantity quantitative;

    private static final String HARD_VOWELS = "аоуұы";
    private static final String SOFT_VOWELS = "әеиөүі";
    private static final String VOWELS = HARD_VOWELS + SOFT_VOWELS;
    private static final String[][] ENDINGS =
            {
                {"ым", "ім", "м", "м"},
                {"ың", "ің", "ң", "ң"},
                {"ыңыз", "іңіз", "ңыз", "ңіз"},
                {"ы", "і", "сы", "сі"},
                {"ымыз", "іміз", "мыз", "міз"}
            };


    public PossessiveService(Form possessive, Quantity quantitative) {
        this.possessive = possessive;
        this.quantitative = quantitative;
    }

    @Override
    public String process(String text) {
        int line = getPersonType(possessive, quantitative);
        int column = getLastVowelType(text);

        return text + ENDINGS[line][column];
    }

    private int getPersonType(Form possessive, Quantity quantitative) {
        int result;
        if (possessive == Form.FIRST) {
            if (quantitative == Quantity.SINGULAR) {
                result = 0;
            } else {
                result = 4;
            }
        } else
        if (possessive == Form.SECOND) {
            result = 1;
        } else
        if (possessive == Form.SECOND_RESPECTFUL) {
            result = 2;
        } else {
            result = 3;
        }
        return result;
    }

    private int getLastVowelType(String text) {
        int result = 0;

        char lastLetter = text.charAt(text.length() - 1);
        if (VOWELS.indexOf(lastLetter) != -1) {
            result += 2;
        }

        for (int i = (text.length() - 1); i >= 0; i--) {
            if (HARD_VOWELS.indexOf(text.charAt(i)) != -1) {
                break;
            }
            if (SOFT_VOWELS.indexOf(text.charAt(i)) != -1) {
                result++;
                break;
            }
        }
        return result;
    }

}
