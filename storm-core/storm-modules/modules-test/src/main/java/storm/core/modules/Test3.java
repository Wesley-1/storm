package storm.core.modules;

import storm.core.StormModule;
import storm.core.StormTest;
import storm.core.annotations.Module;

@Module(moduleName = "Test3", version = "1.0.0", author = "Wesley", policy = Module.ModulePolicy.TEST)

public class Test3 extends StormModule<StormTest> {

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
