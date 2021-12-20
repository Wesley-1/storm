package storm.core;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import storm.core.yaml.StormConfig;
import storm.core.yaml.StormFileManager;

import java.util.function.Consumer;

public class StormFilesTest extends JavaPlugin {

    @Override
    public void onEnable() {
        new StormFileManager(this).loadAllConfigs();

        Test.getFileConfiguration().getString("");
    }

    public class Test extends StormConfig {

        /**
         * @param fileName This is for the files name
         * @param path     This is the path for the config to laod to
         * @param writer   This is what will be written to it
         */
        protected Test(String fileName, String path, Consumer<FileConfiguration> writer) {
            super(fileName, path, writer);
        }
    }
}
