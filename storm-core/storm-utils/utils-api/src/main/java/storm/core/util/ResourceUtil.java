package storm.core.util;

import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.io.InputStream;

public class ResourceUtil<J extends JavaPlugin> {

    private final J javaPlugin;

    public ResourceUtil(J javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    public J getJavaPlugin() {
        return javaPlugin;
    }

    public @Nullable InputStream getResourceAsStream(String path) {
        return getJavaPlugin().getResource(path.replaceAll("\\\\", "/"));
    }
}
