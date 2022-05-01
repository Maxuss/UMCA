package net.weavemc.chat;

public enum Formatting {
    OBFUSCATED('k'),
    BOLD('l'),
    STRIKETHROUGH('m'),
    UNDERLINE('n'),
    ITALIC('o'),
    RESET('r')

    ;
    private final char formatChar;

    Formatting(char format) {
        this.formatChar = format;
    }

    public String legacy() {
        return ChatUtil.LEGACY_FORMAT_STR + formatChar;
    }

    public String asString() {
        return name().toLowerCase();
    }
}
