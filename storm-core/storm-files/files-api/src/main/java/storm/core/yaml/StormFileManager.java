package storm.core.yaml;

import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Consumer;

public class StormFileManager{


    private final JavaPlugin plugin;
    private final Reflections reflections;

    public StormFileManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.reflections = new Reflections(plugin.getClass().getPackageName());
    }

    /**
     * This method pretty much just scans the package for anything extending StormConfig and loads it.
     */
    @SneakyThrows
    public void loadAllConfigs() {
        reflections.getSubTypesOf(StormConfig.class)
                .forEach(aClass -> {
                    StormConfig config = null;
                    try {
                        config = aClass.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    Objects.requireNonNull(config).load(plugin);
                    config.write();
                });

    }
}
