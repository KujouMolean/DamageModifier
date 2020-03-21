package com.molean.DamageModifier;

import com.molean.DamageModifier.DamageListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginCommand("dm").setExecutor(new CommandExec(this));
        Bukkit.getPluginManager().registerEvents(new DamageListener(getConfig()), this);
        getLogger().info("§a[DamageModifier] 插件成功加载！");
        super.onEnable();
    }
    @Override
    public void onDisable() {
        saveDefaultConfig();
        getLogger().info("[DamageModifier] 插件成功关闭！");
        super.onDisable();
    }
}
