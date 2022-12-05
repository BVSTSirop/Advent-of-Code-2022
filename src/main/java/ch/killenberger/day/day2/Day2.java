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
        char opponentChar;
        char selfChar;
        int  result = 0;
        for(String s : lines) {
            final char[] splits = s.toCharArray();

            opponentChar = splits[0];
            if(partOne) {
                selfChar = splits[2];
            } else {
                selfChar     = getSelfEnum(opponentChar, splits[2]).selfLetter;
            }

            result += calculateMatchup(opponentChar, selfChar);
        }

        return result;
    }

    private int calculateMatchup(char opponentChar, char selfChar) {
        final HandType opponentType = HandType.findByLetter(opponentChar);
        final HandType selfType     = HandType.findByLetter(selfChar);

        if(opponentType == selfType) {
            return REWARD_TIE + opponentType.value;
        }

        if(opponentType == HandType.ROCK) {
            if(selfType == HandType.PAPER) {
                return REWARD_WIN + HandType.PAPER.value;
            } else if(selfType == HandType.SCISSOR) {
                return REWARD_LOSS + HandType.SCISSOR.value;
            }
        } else if(opponentType == HandType.PAPER) {
            if(selfType == HandType.SCISSOR) {
                return REWARD_WIN + HandType.SCISSOR.value;
            } else if (selfType == HandType.ROCK) {
                return REWARD_LOSS + HandType.ROCK.value;
            }
        } else if(opponentType == HandType.SCISSOR) {
            if(selfType == HandType.ROCK) {
                return REWARD_WIN + HandType.ROCK.value;
            } else if(selfType == HandType.PAPER) {
                return REWARD_LOSS + HandType.PAPER.value;
            }
        }

        throw new IllegalArgumentException("No matchup could be found for: " + opponentChar + " | " + selfChar);
    }

    private HandType getSelfEnum(char opponentChar, char mode) {
        HandType opponentType = HandType.findByLetter(opponentChar);

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

        throw new IllegalArgumentException("No matchup could be found for: " + opponentChar + " | " + mode);
    }
}
