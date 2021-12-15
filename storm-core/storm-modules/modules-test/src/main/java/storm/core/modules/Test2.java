package storm.core.modules;

import storm.core.StormModule;
import storm.core.StormTest;
import storm.core.annotations.Module;


@Module(moduleName = "Test2", version = "1.0.0", author = "Wesley", policy = Module.ModulePolicy.DEV)
public class Test2 extends StormModule<StormTest> {

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
