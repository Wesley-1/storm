package storm.core;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public abstract class StormModule<T extends JavaPlugin> {

    private T plugin;

    public abstract void onEnable();
    public abstract void onDisable();

    public File getDataFolder() {
        return plugin.getDataFolder();
    }
}
