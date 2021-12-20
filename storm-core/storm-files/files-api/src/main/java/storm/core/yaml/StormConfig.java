package storm.core.yaml;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.function.Consumer;

public abstract class StormConfig {

    @Getter
    private final String fileName;

    @Getter
    private final String path;

    @Getter
    public static FileConfiguration fileConfiguration;

    @Getter
    private final Consumer<FileConfiguration> writer;

    /**
     * This is the hashmap that stores all configs.
     */
    @Getter
    protected HashMap<String, FileConfiguration> loadedConfigs = new HashMap<>();

    /**
     *
     * @param fileName This is for the files name
     * @param path This is the path for the config to laod to
     * @param writer This is what will be written to it
     */
    protected StormConfig(String fileName, String path, Consumer<FileConfiguration> writer) {
        this.fileName = fileName;
        this.path = path;
        this.writer = writer;
    }

    /**
     *
     * @param plugin This is the JavaPlugin param
     *
     * This is method is for loading a new file.
     *
     */
    public void load(JavaPlugin plugin) {

        File file = new File(path, fileName);

        if (!file.exists()){
            plugin.saveResource(fileName, false);
        }
        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
        loadedConfigs.put(fileName, this.fileConfiguration);
    }

    public void write() {
        writer.accept(loadedConfigs.get(fileName));
    }
}