package com.narxoz.rpg.battle;

import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.CombatNode;
import java.util.Random;

public class RaidEngine {
    private Random random = new Random(1L);

    public RaidEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public RaidResult runRaid(CombatNode teamA, CombatNode teamB, Skill skillA, Skill skillB) {
        RaidResult result = new RaidResult();
        
        if (teamA == null || teamB == null || !teamA.isAlive() || !teamB.isAlive()) {
            result.setWinner("None");
            result.addLine("Battle cannot start. Teams are missing or dead.");
            return result;
        }

        int round = 1;
        result.addLine("Raid Start: " + teamA.getName() + " vs " + teamB.getName());

        while (teamA.isAlive() && teamB.isAlive() && round <= 50) {
            result.addLine("--- Round " + round + " ---");

            result.addLine(teamA.getName() + " uses " + skillA.getSkillName());
            skillA.cast(teamB);

            if (teamB.isAlive()) {
                result.addLine(teamB.getName() + " counters with " + skillB.getSkillName());
                skillB.cast(teamA);
            }
            round++;
        }

        result.setRounds(round - 1);
        String winner = teamA.isAlive() ? teamA.getName() : (teamB.isAlive() ? teamB.getName() : "Draw");
        result.setWinner(winner);
        result.addLine("VICTORY: " + winner);
        
        return result;
    }
}
