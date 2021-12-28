package storm.core.store;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @param <F>
 *
 *     Every storm store must have its own file, how this will work is it will take that file and write to it.
 *     These stores can only be used once for each file.
 */
public class StormStore<F extends File> {

    private final Gson gson;
    private final F file;
    private final JsonObject loaded, loader;

    public StormStore(F file) {
        this.loaded = new JsonObject();
        this.loader = new JsonObject();
        this.file = file;
        this.gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

    }

    public F getFile() {
        return file;
    }

    public JsonObject getLoaded() {
        return loaded;
    }

    public JsonObject getLoader() {
        return loader;
    }

    public Gson getGson() {
        return gson;
    }

    public void saveObject(JsonObject obj, String saveAs) {
        getLoader().add(saveAs, obj);
        getLoaded().add("storm-store", getLoader());

        try {
            getFile().delete();
            getFile().createNewFile();
            FileWriter writer = new FileWriter(getFile());
            writer.write(getGson().toJson(getLoaded()));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JsonElement getObject(String savedAs) {
        return getLoader().get(savedAs);
    }
}
