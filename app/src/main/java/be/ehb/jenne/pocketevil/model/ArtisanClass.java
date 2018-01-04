package be.ehb.jenne.pocketevil.model;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Jenne on 29/12/2017.
 * Based on HeroClass structure
 */

public enum ArtisanClass {
    BLACKSMITH("blacksmith"),
    JEWELER("jeweler"),
    MYSTIC("mystic");

    private String className;

    private static final Map<String, ArtisanClass> ENUM_MAP;

    ArtisanClass(String className){this.className = className;}

    public String getClassName() {return className;}

    static {
        Map<String, ArtisanClass> map = new ConcurrentHashMap<String, ArtisanClass>();
        for(ArtisanClass instance : ArtisanClass.values()) {
            map.put(instance.getClassName(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static ArtisanClass get (String className) { return ENUM_MAP.get(className); }
}
