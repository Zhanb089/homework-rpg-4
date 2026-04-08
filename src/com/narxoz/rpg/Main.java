package com.narxoz.rpg;

import com.narxoz.rpg.battle.RaidEngine;
import com.narxoz.rpg.battle.RaidResult;
import com.narxoz.rpg.bridge.AreaSkill;
import com.narxoz.rpg.bridge.FireEffect;
import com.narxoz.rpg.bridge.IceEffect;
import com.narxoz.rpg.bridge.SingleTargetSkill;
import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.EnemyUnit;
import com.narxoz.rpg.composite.HeroUnit;
import com.narxoz.rpg.composite.PartyComposite;
import com.narxoz.rpg.composite.RaidGroup;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 4: Bridge + Composite ===");

        HeroUnit warrior = new HeroUnit("Warrior", 150, 30);
        HeroUnit mage = new HeroUnit("Mage", 100, 45);

        EnemyUnit boss = new EnemyUnit("Dragon", 400, 55);
        EnemyUnit Goblin = new EnemyUnit("Goblin", 40, 10);
        EnemyUnit orc = new EnemyUnit("Orc", 40, 10);

        PartyComposite heroes = new PartyComposite("Hero Squad");
        heroes.add(warrior);
        heroes.add(mage);

        PartyComposite enemyes = new PartyComposite("Enemy group");
        enemyes.add(Goblin);
        enemyes.add(orc);

        RaidGroup enemyRaid = new RaidGroup("Epic Boss Encounter");
        enemyRaid.add(boss);
        enemyRaid.add(enemyes); 

        System.out.println("--- Battle Setup ---");
        heroes.printTree("");
        enemyRaid.printTree("");

        Skill iceArrow = new SingleTargetSkill("Ice Arrow", 35, new IceEffect());
        Skill fireRain = new AreaSkill("Fire Rain", 25, new FireEffect());

        RaidEngine engine = new RaidEngine().setRandomSeed(777L);
        RaidResult result = engine.runRaid(heroes, enemyRaid, iceArrow, fireRain);

        System.out.println("--- Battle Log ---");
        for (String line : result.getLog()) {
            System.out.println(line);
        }
        System.out.println("Winner: " + result.getWinner() + " (Rounds: " + result.getRounds() + ")");
    }
}
