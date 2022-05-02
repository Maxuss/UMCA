import json
from net import get_json


def gen_material_class():
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
    
    public static final Material AIR = new Material(Key.minecraft("air"), "", (byte) 0, (short) -1);
"""
    j = get_json("items.json")
    for each in j:
        base += f"""    public static final Material {each["name"].upper()} = new Material(Key.minecraft("{each["name"]}"), "{each["name"]}", "{each["displayName"]}", (byte) {each["stackSize"]}, (short) {each["id"]});\n"""
    base += _build_lookup_tables(j)
    base += "\n}"
    f = open("Material.java", "w+")
    f.write(base)


def _build_lookup_tables(j) -> str:
    base = """    
    public static Material find(String name) {
        switch(name.toLowerCase()) {
    """
    for each in j:
        base += f"""            case "{each["name"].lower()}": return Material.{each["name"].upper()};\n"""
    base += """            default: return Material.AIR;
        }
    }
    """
    return base
