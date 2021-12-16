package storm.core.controllers;

import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import storm.core.StormModule;

import java.io.File;
import java.util.*;

import static storm.core.StormModule.ModulePolicy.DEV;
import static storm.core.StormModule.ModulePolicy.TEST;

public class ModuleController {

    private final JavaPlugin plugin;
    private final Reflections reflections;
    private final LinkedHashMap<StormModule.ModulePolicy, List<StormModule>> storedModules;

    public ModuleController(String classPath, JavaPlugin plugin) {
        this.plugin = plugin;

        reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(classPath)));

        storedModules = new LinkedHashMap<>();
    }

    @SneakyThrows
    public void loadAllModules(StormModule.ModulePolicy policy) {
        List<StormModule> loadedModules = new ArrayList<>();
        for (Class<? extends StormModule> stormModules : reflections.getSubTypesOf(StormModule.class)) {
            StormModule module = stormModules.newInstance();

            if (policy.equals(module.getPolicy())) {

                loadedModules.add(module);
                File moduleDir = new File(plugin.getDataFolder() + "/modules/" + module.getModuleName());

                if (!moduleDir.exists()) {
                    moduleDir.mkdirs();
                }

                module.onEnable();
            }
        }
        storedModules.put(policy, loadedModules);
    }

    @SneakyThrows
    public void disableAllModules(StormModule.ModulePolicy policy) {
        for (Map.Entry<StormModule.ModulePolicy, List<StormModule>> module : storedModules.entrySet()) {

            StormModule.ModulePolicy modulePolicy = module.getKey();
            List<StormModule> stormModule = module.getValue();

            if (modulePolicy == policy) {
                stormModule.forEach(StormModule::onDisable);
                storedModules.remove(policy);
            }
        }
    }
}
