package storm.core;

import org.bukkit.plugin.java.JavaPlugin;
import storm.core.controllers.ModuleController;

public class StormTest extends JavaPlugin {

    @Override
    public void onEnable() {
        new ModuleController("storm.core.modules", this).loadAllModules(StormModule.ModulePolicy.DEV);
    }
}
