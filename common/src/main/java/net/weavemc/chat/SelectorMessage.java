package net.weavemc.chat;

import lombok.Getter;
import net.weavemc.Weave;

public class SelectorMessage extends BaseMessage {
    @Getter
    private final String selector;
    @Getter
    private final Message separator;

    public SelectorMessage(String selector, Message separator) {
        this.selector = selector;
        this.separator = separator;
    }

    @Override
    public String getString() {
        return Weave.getBackend().getMessageDispatcher().dispatch(this);
    }
}
