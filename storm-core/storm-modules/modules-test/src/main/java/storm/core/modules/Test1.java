package storm.core.modules;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.plugin.java.JavaPlugin;
import storm.core.StormModule;
import storm.core.StormTest;

import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class Test1 extends StormModule {

    protected Test1() {
        super(
                "Zlurpy",
                "Test1",
                "1.0.0",
                ModulePolicy.DEV,
                StormTest.getPlugin(StormTest.class)
        );
    }

    @Override
    public void onEnable() {

        Arrays.asList(
                "....................................",
                super.getModuleName() + " Loaded!",
                "...................................."
                ).forEach(System.out::println);

    }

    @Override
    public void onDisable() {

    }

}
