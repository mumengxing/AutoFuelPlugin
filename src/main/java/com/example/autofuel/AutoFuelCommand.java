package com.example.autofuel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AutoFuelCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("autofuel.reload")) {
                sender.sendMessage("§c你没有权限使用此命令!");
                return true;
            }
            
            AutoFuelPlugin.getInstance().reloadPluginConfig();
            sender.sendMessage("§aAutoFuel 配置已重新加载!");
            return true;
        }
        
        sender.sendMessage("§6AutoFuel 插件 §7- §f版本 1.0.0");
        sender.sendMessage("§7用法: §f/autofuel reload");
        return true;
    }
}
