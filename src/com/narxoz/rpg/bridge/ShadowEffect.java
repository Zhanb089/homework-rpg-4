package com.narxoz.rpg.bridge;

public class ShadowEffect implements EffectImplementor {
    @Override
    public int computeDamage(int basePower) {
        return Math.max(0, (int) Math.round(basePower * 1.3));
    }

    @Override
    public void apply(int amount) {
        System.out.println("   [Effect] Темная энергия поглощает жизненные силы цели на " + amount + " единиц!");
    }

    @Override
    public String getEffectName() {
        return "Shadow";
    }
}
