package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaFighter;

public class HealCommand implements ActionCommand {
    private final ArenaFighter target;
    private final int healAmount;
    private int actualHealApplied;

    public HealCommand(ArenaFighter target, int healAmount) {
        this.target = target;
        this.healAmount = healAmount;
    }

    @Override
    public void execute() {
        int initialHealth = target.getHealth();
        target.heal(healAmount);
        actualHealApplied = target.getHealth() - initialHealth;
        if (actualHealApplied > 0) {
            System.out.println("[Heal] Restored " + actualHealApplied + " health! Potions left: " + target.getHealPotions());
        } else {
            System.out.println("[Heal] No potions left!");
        }
    }

    @Override
    public void undo() {
        if (actualHealApplied > 0) {
            target.takeDamage(actualHealApplied);
            System.out.println("[Heal Undo] Removed " + actualHealApplied + " health!");
        }
    }

    @Override
    public String getDescription() {
        return "Heal for " + healAmount + " health";
    }
}