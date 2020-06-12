package net.immortalrealms.players.stats;

import java.util.Optional;

public enum KillStreak {
    FIVE(5, 10),
    TEN(10, 20),
    FIFTEEN(15, 30),
    TWENTY(20, 40),
    TWNTY_FIVE(25, 50),
    THIRTY(30, 60),
    THIRTY_FIVE(35, 70),
    FOURTY(40, 80),
    FOURTY_FIVE(45, 90),
    FIFTY(50, 100);

    public int getActualInteger() {
        return actualInteger;
    }

    private final int actualInteger;

    public int getBonusExperience() {
        return bonusExperience;
    }

    private final int bonusExperience;

    KillStreak(int actualInteger, int bonusExperience) {
        this.actualInteger = actualInteger;
        this.bonusExperience = bonusExperience;
    }
}