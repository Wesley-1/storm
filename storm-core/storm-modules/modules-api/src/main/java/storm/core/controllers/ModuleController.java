package storm.core.controllers;

import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import storm.core.StormModule;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static storm.core.StormModule.ModulePolicy.DEV;
import static storm.core.StormModule.ModulePolicy.TEST;

public class ModuleController {

    private final String classPath;
    private final JavaPlugin plugin;
    private final Reflections reflections;
    private final LinkedHashMap<StormModule.ModulePolicy, StormModule> storedModules;

    public ModuleController(String classPath, JavaPlugin plugin) {
        this.classPath = classPath;
        this.plugin = plugin;

        reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(this.classPath)));

        storedModules = new LinkedHashMap<>();
    }

    @SneakyThrows
    public void loadAllModules(StormModule.ModulePolicy policy) {
        for (Class<? extends StormModule> stormModules : reflections.getSubTypesOf(StormModule.class)) {
            StormModule module = stormModules.newInstance();

            switch (policy) {
                case DEV, TEST, PROD -> storedModules.put(module.getPolicy(), module);
            }

            if (policy.equals(module.getPolicy())) {

                File moduleDir = new File(plugin.getDataFolder() + "/modules/" + module.getModuleName());

                if (!moduleDir.exists()) {
                    moduleDir.mkdirs();
                }

                module.onEnable();
            }
        }
    }

    @SneakyThrows
    public void disableAllModules(StormModule.ModulePolicy policy) {
        for (Map.Entry<StormModule.ModulePolicy, StormModule> module : storedModules.entrySet()) {
            StormModule.ModulePolicy modulePolicy = module.getKey();
            StormModule stormModule = module.getValue();

            if (modulePolicy == policy) {
                stormModule.onDisable();
            }
        }
    }
}
