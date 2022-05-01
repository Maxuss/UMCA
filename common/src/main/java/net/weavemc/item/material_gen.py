import json

def generator():
    base = """
package net.weavemc.item;

import lombok.Getter;
import net.weavemc.utils.Key;

/**
    This class was auto-generated
**/
public class Material {
    @Getter
    private final Key resourceKey;
    @Getter
    private final short legacyId;
    @Getter
    private final byte stackSize;
    @Getter
    private final String displayName;
    @Getter
    private final String name;

    public Material(Key key, String name, String displayName, byte stackSize) {
        this.resourceKey = key;
        this.legacyId = -1;
        this.name = name;
        this.displayName = displayName;
        this.stackSize = stackSize;
    }

    private Material(Key key, String name, String displayName, byte stackSize, short legacyId) {
        this.resourceKey = key;
        this.name = name;
        this.stackSize = stackSize;
        this.displayName = displayName;
        this.legacyId = legacyId;
    }

"""
    j = json.load(open("items.json"))
    for each in j:
        base += f"""    public static final Material {each["name"].upper()} = new Material(Key.minecraft("{each["name"]}"), "{each["name"]}", "{each["displayName"]}", (byte) {each["stackSize"]}, (short) {each["id"]});\n"""

    base += "\n}"
    f = open("Material.java", "w+")
    f.write(base)

if __name__ == "__main__":
    generator()