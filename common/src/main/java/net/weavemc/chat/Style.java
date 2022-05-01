package net.weavemc.chat;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class Style implements Cloneable {
    @Getter @Nullable
    private TextColor color;
    @Getter @NotNull
    private final HashMap<Formatting, Boolean> formattings = new HashMap<>();

    public static Style EMPTY = new Style();

    private Style() {

    }

    public Style stripColor() {
        Style clone = this.clone();
        clone.color = null;
        return clone;
    }

    public Style stripFormattings() {
        Style clone = this.clone();
        clone.formattings.clear();
        return clone;
    }

    public Style strip() {
        Style clone = this.clone();
        clone.color = null;
        clone.formattings.clear();
        return clone;
    }

    public Style colored(TextColor color) {
        Style clone = this.clone();
        clone.color = color;
        return clone;
    }

    public Style formatted(Formatting formatting) {
        return this.formatted(formatting, true);
    }

    public Style formatted(Formatting formatting, boolean flag) {
        Style clone = this.clone();
        clone.formattings.put(formatting, flag);
        return clone;
    }

    @Override
    public Style clone() {
        try {
            return (Style) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
