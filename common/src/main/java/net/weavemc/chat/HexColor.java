package net.weavemc.chat;

import com.google.common.base.Objects;

public record HexColor(int value) implements TextColor {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HexColor hexColor = (HexColor) o;
        return value == hexColor.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
