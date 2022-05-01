package net.weavemc.chat;

import java.util.HashMap;

public interface Message extends Cloneable {
    String getString();
    Style getStyle();
    Message style(Style style);

    static TextMessage text(String text) {
        return new TextMessage(text);
    }

    static TranslatableMessage translate(String key) {
        return new TranslatableMessage(key, new HashMap<>());
    }

    static TranslatableMessage translate(String key, HashMap<String, Message> placeholders) {
        return new TranslatableMessage(key, placeholders);
    }

    static SelectorMessage selector(String selector) {
        return new SelectorMessage(selector, null);
    }

    static SelectorMessage selector(String selector, Message separator) {
        return new SelectorMessage(selector, separator);
    }

    static ScoreboardMessage score(String score, String objective) {
        return new ScoreboardMessage(score, objective, null);
    }

    static ScoreboardMessage score(String score, String objective, String extra) {
        return new ScoreboardMessage(score, objective, extra);
    }

    static KeybindMessage key(String key) {
        return new KeybindMessage(key);
    }
}
