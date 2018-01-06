package be.ehb.jenne.pocketevil.model;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.realm.RealmObject;

/**
 * Created by Jenne on 29/12/2017.
 * accepted anwser from Darrel Teague, based on Joshua Bloch's pattern.
 * https://stackoverflow.com/questions/604424/lookup-enum-by-string-value
 */

public enum HeroClass {
    BARBARIAN("barbarian"),
    CRUSADER("crusader"),
    DEMONHUNTER("demon-hunter"),
    MONK("monk"),
    NECROMANCER("necromancer"),
    WITCHDOCTOR("witch-doctor"),
    WIZARD("wizard");

    private String className;

    private static final Map<String, HeroClass> ENUM_MAP;

    HeroClass(String className){
        this.className = className;
    }

    public String getClassName(){
        return className;
    }

    static {
        Map<String, HeroClass> map = new ConcurrentHashMap<String, HeroClass>();
        for(HeroClass instance : HeroClass.values()) {
            map.put(instance.getClassName(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static HeroClass get (String className) {
        return ENUM_MAP.get(className);
    }
}

