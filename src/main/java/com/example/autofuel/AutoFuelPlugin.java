package com.example.autofuel;

import org.bukkit.plugin.java.JavaPlugin;

public class AutoFuelPlugin extends JavaPlugin {
    
    private static AutoFuelPlugin instance;
    
    @Override
    public void onEnable() {
        instance = this;
        
        // 保存默认配置文件
        saveDefaultConfig();
        
        // 注册事件监听器
        getServer().getPluginManager().registerEvents(new FurnaceListener(), this);
        
        // 注册命令
        getCommand("autofuel").setExecutor(new AutoFuelCommand());
        
        getLogger().info("AutoFuel 插件已启用!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("AutoFuel 插件已禁用!");
    }
    
    public static AutoFuelPlugin getInstance() {
        return instance;
    }
    
    public void reloadPluginConfig() {
        reloadConfig();
        getLogger().info("配置已重新加载!");
    }
}
