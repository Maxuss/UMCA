package net.weavemc.chat;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public interface Message extends Cloneable {
    String getString();
    Style getStyle();
    Message style(Style style);

    static @NotNull TextMessage text(String text) {
        return new TextMessage(text);
    }

    static @NotNull TranslatableMessage translate(String key) {
        return new TranslatableMessage(key, new HashMap<>());
    }

    static @NotNull TranslatableMessage translate(String key, HashMap<String, Message> placeholders) {
        return new TranslatableMessage(key, placeholders);
    }

    static @NotNull SelectorMessage selector(String selector) {
        return new SelectorMessage(selector, null);
    }

    static @NotNull SelectorMessage selector(String selector, Message separator) {
        return new SelectorMessage(selector, separator);
    }

    static @NotNull ScoreboardMessage score(String score, String objective) {
        return new ScoreboardMessage(score, objective, null);
    }

    static @NotNull ScoreboardMessage score(String score, String objective, String extra) {
        return new ScoreboardMessage(score, objective, extra);
    }

    static @NotNull KeybindMessage key(String key) {
        return new KeybindMessage(key);
    }
}
