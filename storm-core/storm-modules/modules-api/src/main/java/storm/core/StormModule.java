package storm.core;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public abstract class StormModule {

    @Getter private final String author, moduleName, version;
    @Getter private final ModulePolicy policy;
    @Getter private final JavaPlugin mainPlugin;

    protected StormModule(String author, String moduleName, String version, ModulePolicy policy, JavaPlugin mainPlugin) {
        this.author = author;
        this.moduleName = moduleName;
        this.version = version;
        this.policy = policy;
        this.mainPlugin = mainPlugin;
    }

    public abstract void onEnable();
    public abstract void onDisable();

    public File getModuleFolder() {
        return new File(mainPlugin.getDataFolder() + "/modules/" + moduleName);
    }

    public enum ModulePolicy {
        DEV,
        TEST,
        PROD
    }
}
