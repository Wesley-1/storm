package storm.core.annotations;

import org.reflections.Reflections;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.LinkedHashMap;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Module {
    /**
     * This enum is for the modules policy, it'll check if the policy is one of the ones below and if it is then it'll see which one
     * the module is and then it'll compile under that policy type.
     */
    enum ModulePolicy {
        DEV,
        PROD,
        TEST
    }

    /**
     * @return This is where you'll setup the modules name and how it'll be identified.
     */
    String moduleName();

    /**
     * @return This will return the author of that specific module.
     */
    String author() default "Wesley";

    /**
     * @return This will just return the modules version.
     */
    String version() default "1.0.0";

    /**
     * @return This will return the modules policy, what this means is it'll only compile when it's that specific policy.
     */
    ModulePolicy policy();

    /**
     * This class is used to process the annotation for certain packages.
     */
}


