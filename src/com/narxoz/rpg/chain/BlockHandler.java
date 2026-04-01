package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class BlockHandler extends DefenseHandler {
    private final double blockPercent;

    public BlockHandler(double blockPercent) {
        this.blockPercent = blockPercent;
    }

    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        int blocked = (int)(incomingDamage * blockPercent);
        int remaining = incomingDamage - blocked;
        
        if (blocked > 0) {
            System.out.println("[Block] Blocked " + blocked + " damage!");
        }
        
        if (remaining > 0) {
            passToNext(remaining, target);
        } else {
            System.out.println("[Block] All damage was blocked!");
        }
    }
}