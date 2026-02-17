package org.example;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Plugin is Enable");
        //命令注册
        getCommand("example").setExecutor(new ExampleCommand());
        //事件注册
        Bukkit.getPluginManager()
                .registerEvent(
                    Event.Type.PLAYER_JOIN, //事件类型
                    new PluginEvent(), //监听类
                    Event.Priority.Normal, //事件优先级
                    this //Plugin
                );
        /// 因为以前的Bukkit没有 registerEvents这个接口，所以注册得这样
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Plugin is Disable");
    }
}
