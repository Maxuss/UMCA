package net.weavemc.chat;

import org.jetbrains.annotations.NotNull;

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

    public @NotNull String legacy() {
        return ChatUtil.LEGACY_FORMAT_STR + formatChar;
    }

    public @NotNull String asString() {
        return name().toLowerCase();
    }
}
