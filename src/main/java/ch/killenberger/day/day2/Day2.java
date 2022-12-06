package ch.killenberger.day.day2;

import ch.killenberger.day.AbstractDay;
import ch.killenberger.day.Day;

import java.io.IOException;
import java.util.List;

public class Day2 extends AbstractDay implements Day<Integer> {
    public static final int REWARD_LOSS = 0;
    public static final int REWARD_TIE  = 3;
    public static final int REWARD_WIN  = 6;

    public Day2(String day) {
        super(day);
    }

    @Override
    public Integer run(boolean partOne) throws IOException {
        checkInputFile();

        final List<String> lines = readInput();

        return parseInput(lines, partOne);
    }

    private int parseInput(final List<String> lines, final boolean partOne) {
        HandType opponentType;
        HandType selfType;

        int result = 0;
        for(String s : lines) {
            char firstColumn  = s.charAt(0);
            char secondColumn = s.charAt(2);

            opponentType = HandType.findByLetter(firstColumn);

            if(partOne) {
                selfType = HandType.findByLetter(secondColumn);
            } else {
                selfType = getSelfEnum(opponentType, secondColumn);
            }

            result += calculateMatchup(opponentType, selfType);
        }

        return result;
    }

    // Calculates the score of a rock, paper, scissor matchup
    private int calculateMatchup(HandType opponentType, HandType selfType) {
        int result = 0;
        
        if(opponentType == selfType) {
            result = REWARD_TIE;
        } else if(opponentType == HandType.ROCK) {
            if(selfType == HandType.PAPER) {
                result = REWARD_WIN;
            } else if(selfType == HandType.SCISSOR) {
                result = REWARD_LOSS;
            }
        } else if(opponentType == HandType.PAPER) {
            if(selfType == HandType.SCISSOR) {
                result = REWARD_WIN;
            } else if (selfType == HandType.ROCK) {
                result = REWARD_LOSS;
            }
        } else if(opponentType == HandType.SCISSOR) {
            if(selfType == HandType.ROCK) {
                result = REWARD_WIN;
            } else if(selfType == HandType.PAPER) {
                result = REWARD_LOSS;
            }
        }

        return result + selfType.value;
    }

    private HandType getSelfEnum(HandType opponentType, char mode) {
        if(mode == 'X') {
            if(opponentType == HandType.ROCK) {
                return HandType.SCISSOR;
            }

            if(opponentType == HandType.PAPER) {
                return HandType.ROCK;
            }

            if(opponentType == HandType.SCISSOR) {
                return HandType.PAPER;
            }
        }

        if(mode == 'Y') {
            return opponentType;
        }

        if(mode == 'Z') {
            if(opponentType == HandType.ROCK) {
                return HandType.PAPER;
            }

            if(opponentType == HandType.PAPER) {
                return HandType.SCISSOR;
            }

            if(opponentType == HandType.SCISSOR) {
                return HandType.ROCK;
            }
        }

        throw new IllegalArgumentException("No matchup could be found for: " + opponentType.name() + " | " + mode);
    }
}
