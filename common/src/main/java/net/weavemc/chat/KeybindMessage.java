package net.weavemc.chat;

import lombok.Getter;
import net.weavemc.Weave;

public class KeybindMessage extends BaseMessage {
    @Getter
    private final String key;

    public KeybindMessage(String key) {
        this.key = key;
    }

    @Override
    public String getString() {
        return Weave.getBackend().getMessageDispatcher().dispatch(this);
    }
}
