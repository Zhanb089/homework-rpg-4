package com.narxoz.rpg.bridge;

public class PhysicalEffect implements EffectImplementor {
    @Override
    public int computeDamage(int basePower) {
        return Math.max(0, basePower);
    }

    @Override
    public void apply(int amount) {
        System.out.println("   [Effect] Прямой физический удар сокрушает защиту, нанося " + amount + " урона!");
    }

    @Override
    public String getEffectName() {
        return "Physical";
    }
}
