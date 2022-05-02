from net import get_json


def gen_blocktype_class():
    base = """package net.weavemc.block;

import lombok.Getter;
import net.weavemc.item.Material;
import net.weavemc.utils.Key;
import net.weavemc.utils.Producer;

import java.util.HashMap;
import java.util.List;

/**
 * This class was auto generated
 **/
public final class BlockType {
    @Getter
    private final short legacyId;
    @Getter
    private final String displayName;
    @Getter
    private final String name;
    @Getter
    private final Key resourceKey;
    @Getter
    private final float hardness;
    @Getter
    private final double resistance;
    @Getter
    private final short minStateId;
    @Getter
    private final short maxStateId;
    @Getter
    private final HashMap<Integer, Boolean> harvestable;
    @Getter
    private final short defaultState;
    @Getter
    private final boolean diggable;
    @Getter
    private final boolean transparent;
    @Getter
    private final int filteringLight;
    @Getter
    private final int emittingLight;
    @Getter
    private final Material baseMaterial;
    @Getter
    private final List<Key> tags;

    public BlockType(int legacyId,
                     String displayName,
                     String name,
                     double hardness,
                     double resistance,
                     int minStateId,
                     int maxStateId,
                     Producer<HashMap<Integer, Boolean>> harvestableProducer,
                     int defaultState,
                     boolean diggable,
                     boolean transparent,
                     int filteringLight,
                     int emittingLight,
                     Material baseMaterial,
                     List<Key> tags) {
        this.legacyId = (short) legacyId;
        this.displayName = displayName;
        this.name = name;
        this.resourceKey = Key.minecraft(name);
        this.hardness = (float) hardness;
        this.resistance = resistance;

        this.minStateId = (short) minStateId;
        this.maxStateId = (short) maxStateId;
        this.harvestable = harvestableProducer.produce();
        this.defaultState = (short) defaultState;
        this.diggable = diggable;
        this.transparent = transparent;
        this.filteringLight = filteringLight;
        this.emittingLight = emittingLight;
        this.baseMaterial = baseMaterial;
        this.tags = tags;
    }

"""

    j = get_json("blocks.json")
    for b in j:
        base += f"""    public static final BlockType {b["name"].upper()} = new BlockType({b["id"]}, "{b["displayName"]}", "{b["name"]}", {0 if b["hardness"] is None else b["hardness"]}, {b["resistance"]}, {b["minStateId"]}, {b["maxStateId"]}, {_build_map_producer(b)}, {b["defaultState"]}, {str(b["diggable"]).lower()}, {str(b["transparent"]).lower()}, {b["filterLight"]}, {b["emitLight"]}, Material.find("{b["name"]}"), {_build_material_list(b)});\n"""

    base += _build_lookup_tables(j)
    base += "\n}"
    f = open("BlockType.java", "w+")
    f.write(base)


def _build_lookup_tables(j) -> str:
    base = """    
    public static BlockType find(String name) {
        switch(name.toLowerCase()) {
    """
    for each in j:
        base += f"""            case "{each["name"].lower()}": return BlockType.{each["name"].upper()};\n"""
    base += """            default: return BlockType.AIR;
        }
    }
    """
    return base


def _build_map_producer(j: dict) -> str:
    if "harvestTools" not in j or len(j["harvestTools"]) <= 0:
        return "(Producer<HashMap<Integer, Boolean>>) () -> new HashMap<>()"
    b = "(Producer<HashMap<Integer, Boolean>>) () -> { HashMap<Integer, Boolean> map = new HashMap<>(); "
    harvest = j["harvestTools"]
    for each in harvest:
        harvestable = harvest[each]
        b += f"map.put({each}, {str(harvestable).lower()}); "
    b += "return map; }"
    return b


def _build_material_list(j) -> str:
    b = "List.of("
    split = j["material"].split(";")
    for each in split:
        b += f"Key.minecraft(\"{each}\"), "
    b += ")"
    b = b.replace(", )", ")")
    return b
