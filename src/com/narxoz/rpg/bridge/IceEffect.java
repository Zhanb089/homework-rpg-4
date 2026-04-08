package com.narxoz.rpg.bridge;

public class IceEffect implements EffectImplementor {
    @Override
    public int computeDamage(int basePower) {
        return Math.max(0, (int) Math.round(basePower * 1.1));
    }

    @Override
    public void apply(int amount) {
        System.out.println("   [Effect] Ледяная корка сковывает цель, нанося " + amount + " урона холодом!");
    }

    @Override
    public String getEffectName() {
        return "Ice";
    }
}
