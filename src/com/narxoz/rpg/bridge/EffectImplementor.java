package com.narxoz.rpg.bridge;

public interface EffectImplementor {
    int computeDamage(int basePower);
    void apply(int amount);
    String getEffectName();
}
