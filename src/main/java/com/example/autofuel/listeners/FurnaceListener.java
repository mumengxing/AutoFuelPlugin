package com.example.autofuel.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;
import com.example.autofuel.AutoFuelPlugin;

public class FurnaceListener implements Listener {
    
    private final AutoFuelPlugin plugin;
    
    public FurnaceListener() {
        this.plugin = AutoFuelPlugin.getInstance();
    }
    
    @EventHandler
    public void onFurnaceBurn(FurnaceBurnEvent event) {
        Furnace furnace = (Furnace) event.getBlock().getState();
        FurnaceInventory inventory = furnace.getInventory();
        ItemStack fuel = inventory.getFuel();
        
        // 检查燃料是否不足
        if (fuel == null || fuel.getType() == Material.AIR || fuel.getAmount() < 3) {
            tryRefuelFurnace(furnace);
        }
    }
    
    private void tryRefuelFurnace(Furnace furnace) {
        Block furnaceBlock = furnace.getBlock();
        
        if (plugin.getConfig().getBoolean("debug")) {
            plugin.getLogger().info("检测到熔炉需要燃料: " + furnaceBlock.getLocation());
        }
        
        // 简化实现 - 在实际版本中这里会搜索附近箱子
        plugin.getLogger().info("熔炉燃料不足，应该搜索附近箱子补充燃料");
    }
}
