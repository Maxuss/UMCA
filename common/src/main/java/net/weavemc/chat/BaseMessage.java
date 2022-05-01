package net.weavemc.chat;

import com.google.common.base.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

abstract class BaseMessage implements Message, Cloneable {
    protected Style style = Style.EMPTY;

    @Override
    public @NotNull Message style(Style style) {
        BaseMessage clone = (BaseMessage) this.clone();
        clone.style = style;
        return clone;
    }

    @Override
    public Style getStyle() {
        return style.clone();
    }

    @Override
    public @NotNull String toString() {
        return this.getClass().getSimpleName() + "('" + getString() + "')";
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseMessage that = (BaseMessage) o;
        return Objects.equal(style, that.style);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(style);
    }

    @Override
    public Message clone() {
        try {
            return (Message) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
