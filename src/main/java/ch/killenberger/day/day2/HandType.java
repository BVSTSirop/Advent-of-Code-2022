package ch.killenberger.day.day2;

import java.util.Arrays;

public enum HandType {

    ROCK('A', 'X', 1, HandType.SCISSOR, HandType.PAPER),
    PAPER('B', 'Y', 2, HandType.ROCK. HandType.SCISSOR),
    SCISSOR('C', 'Z', 3, HandType.PAPER, HandType.ROCK);

    char opponentLetter;
    char selfLetter;
    int value;
    HandType winningAgainst;
    HandType losingAgainst;
    private HandType(final char opponentLetter, char selfLetter, final int value, final HandType winningAgainst, final HandType losingAgainst) {
        this.opponentLetter = opponentLetter;
        this.selfLetter     = selfLetter;
        this.value          = value;
        this.winningAgainst = winningAgainst;
        this.losingAgainst  = losingAgainst;
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
