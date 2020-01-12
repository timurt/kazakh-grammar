package kz.tim.services;

import kz.tim.enums.Quantity;

public class QuantitativeService implements Service {

    private static final String HARD_VOWELS = "аоуұы";
    private static final String SOFT_VOWELS = "әеиөүі";
    private static final String DAR_DER_CONSONANTS = "лмнңжз";
    private static final String TAR_TER_CONSONANTS = "пфкқтсшщхцчһбвгд";
    private static final String[][] ENDINGS = {{"дар", "дер"}, {"тар", "тер"}, {"лар", "лер"}};

    private Quantity quantitative;

    public QuantitativeService(Quantity quantitative) {
        this.quantitative = quantitative;
    }

    @Override
    public String process(String text) {
        if (quantitative == Quantity.PLURAL) {
            return pluralize(text);
        } else {
            return singularize(text);
        }
    }

    private String singularize(String text) {
        if (endsWithCorrectEnding(text) && text.length() > 3) {
            String probableSingular = text.substring(0, text.length() - 3);
            if (pluralize(probableSingular).equals(text)) {
                return probableSingular;
            }
        }
        return text;
    }

    private String pluralize(String text) {
        char lastLetter = text.charAt(text.length() - 1);
        int endingType = getEndingTypeByLastLetter(lastLetter);
        int vowelType = getLastVowelType(text);
        return text + ENDINGS[endingType][vowelType];
    }

    private boolean endsWithCorrectEnding(String text) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if (text.endsWith(ENDINGS[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getEndingTypeByLastLetter(char letter) {
        if (DAR_DER_CONSONANTS.indexOf(letter) != -1) {
            return 0;
        }
        if (TAR_TER_CONSONANTS.indexOf(letter) != -1) {
            return 1;
        }
        return 2;
    }

    private int getLastVowelType(String text) {
        for (int i = (text.length() - 1); i >= 0; i--) {
            if (HARD_VOWELS.indexOf(text.charAt(i)) != -1) {
                return 0;
            }
            if (SOFT_VOWELS.indexOf(text.charAt(i)) != -1) {
                return 1;
            }
        }
        return 0;
    }

}
