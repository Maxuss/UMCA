package net.weavemc.chat;

import net.weavemc.utils.Triple;

public interface TextColor {
    int value();

    default Triple<Integer, Integer, Integer> rgb() {
        int value = value();
        int r = (value >> 16) & 0xFF;
        int g = (value >> 8) & 0xFF;
        int b = value & 0xFF;
        return new Triple<>(r, g, b);
    }

    default String legacy() {
        return ChatUtil.LEGACY_FORMAT_STR + 'x' + asString().substring(1);
    }

    default String asString() {
        int value = value();
        int r = (value >> 16) & 0xFF;
        int g = (value >> 8) & 0xFF;
        int b = value & 0xFF;
        return String.format("#%02X%02X%02X", r, g, b);
    }
}
