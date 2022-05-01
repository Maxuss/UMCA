package net.weavemc.chat;

import lombok.Getter;
import net.weavemc.Weave;

import java.util.HashMap;

public final class TranslatableMessage extends BaseMessage {
    @Getter
    private final String key;
    @Getter
    private final HashMap<String, Message> placeholders;

    public TranslatableMessage(String key, HashMap<String, Message> placeholders) {
        this.key = key;
        this.placeholders = placeholders;
    }

    @Override
    public String getString() {
        return Weave.getBackend().getMessageDispatcher().dispatch(this);
    }
}
