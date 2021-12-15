package storm.core.controllers;

import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import storm.core.StormModule;
import storm.core.annotations.Module;

import java.io.File;
import java.util.LinkedHashMap;

public class CommonController {

    static LinkedHashMap<Module.ModulePolicy, Module> registeredModules = new LinkedHashMap<>();

    @SneakyThrows
    public static void loadAllModules(JavaPlugin plugin,
                                      String classPath,
                                      Module.ModulePolicy policy) {

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(classPath)));

        for (Class<?> cl : reflections.getTypesAnnotatedWith(Module.class)) {
            Module module = cl.getAnnotation(Module.class);

            switch (module.policy()) {
                case DEV, TEST, PROD -> registeredModules.put(module.policy(), module);
            }

            if (policy.equals(module.policy())) {

                File moduleDir = new File(plugin.getDataFolder() + "/modules/" + module.moduleName() + "_" + module.version());

                if(!moduleDir.exists()) {
                    moduleDir.mkdirs();
                }

                cl.getMethod("onEnable").invoke(cl.newInstance());
            }
        }
    }
}