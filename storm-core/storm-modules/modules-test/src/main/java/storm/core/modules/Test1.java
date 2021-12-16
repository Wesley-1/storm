package storm.core.modules;

import org.bukkit.plugin.java.JavaPlugin;
import storm.core.StormModule;
import storm.core.StormTest;

public class Test1 extends StormModule {


    protected Test1() {
        super("Zlurpy", "Test1", "1.0.0", ModulePolicy.DEV, StormTest.getPlugin(StormTest.class));
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
