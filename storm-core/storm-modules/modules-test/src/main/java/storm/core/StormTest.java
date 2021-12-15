package storm.core;

import org.bukkit.plugin.java.JavaPlugin;
import storm.core.annotations.Module;
import storm.core.controllers.CommonController;

public class StormTest extends JavaPlugin {

    @Override
    public void onEnable() {
        CommonController.loadAllModules("storm.core.modules", Module.ModulePolicy.DEV);
    }
}
