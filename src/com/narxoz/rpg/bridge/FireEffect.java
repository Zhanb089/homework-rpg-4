package com.narxoz.rpg.bridge;

public class FireEffect implements EffectImplementor {
    @Override
    public int computeDamage(int basePower) {
        return Math.max(0, (int) Math.round(basePower * 1.2));
    }

    @Override
    public void apply(int amount) {
        // Логика визуализации эффекта
        System.out.println("   [Effect] Сверхъестественный огонь обжигает цель на " + amount + " урона!");
    }

    @Override
    public String getEffectName() {
        return "Fire";
    }
}
