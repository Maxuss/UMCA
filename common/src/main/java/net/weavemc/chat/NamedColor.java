package net.weavemc.chat;

public enum NamedColor implements TextColor {
    DARK_RED('r', 0xAA0000),
    RED('c', 0xFF5555),
    GOLD('6', 0xFFAA00),
    YELLOW('e', 0xFFFF55),
    DARK_GREEN('2', 0x00AA00),
    GREEN('a', 0x55FF55),
    AQUA('b', 0x55FFFF),
    DARK_AQUA('3', 0x00AAAA),
    DARK_BLUE('1', 0x0000AA),
    BLUE('9', 0x5555FF),
    LIGHT_PURPLE('d', 0xFF55Ff),
    DARK_PURPLE('5', 0xAA00AA),
    WHITE('f', 0xFFFFFF),
    GRAY('7', 0xAAAAAA),
    DARK_GRAY('8', 0x555555),
    BLACK('0', 0x000000)
    ;
    private final int value;
    private final char legacy;

    NamedColor(char legacy, int hex) {
        this.value = hex;
        this.legacy = legacy;
    }

    @Override
    public int value() {
        return value;
    }

    @Override
    public String asString() {
        return name().toLowerCase();
    }

    @Override
    public String legacy() {
        return ChatUtil.LEGACY_FORMAT_STR + legacy;
    }
}
