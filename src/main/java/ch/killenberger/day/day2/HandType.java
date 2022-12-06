package ch.killenberger.day.day2;

import java.util.Arrays;

public enum HandType {

    ROCK('A', 'X', 1),
    PAPER('B', 'Y',2),
    SCISSOR('C', 'Z', 3);

    char opponentLetter;
    char selfLetter;
    int value;
    private HandType(final char opponentLetter, char selfLetter, final int value) {
        this.opponentLetter = opponentLetter;
        this.selfLetter     = selfLetter;
        this.value          = value;
    }

    public static HandType findByLetter(char letter) {
        for(HandType h : values()) {
            if(h.opponentLetter == letter || h.selfLetter == letter) {
                return h;
            }
        }

        throw new IllegalArgumentException("No ENUM could be found relating to the letter: " + letter);
    }
}
