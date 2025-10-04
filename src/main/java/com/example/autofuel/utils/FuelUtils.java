package com.example.autofuel.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FuelUtils {
    
    public static boolean isFuel(Material material) {
        switch (material) {
            case COAL:
            case CHARCOAL:
            case COAL_BLOCK:
            case LAVA_BUCKET:
            case BLAZE_ROD:
            case WOOD:
                return true;
            default:
                return false;
        }
    }
}
