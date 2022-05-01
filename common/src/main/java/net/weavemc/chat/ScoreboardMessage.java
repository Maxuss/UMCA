package net.weavemc.chat;

import lombok.Getter;
import net.weavemc.Weave;

public class ScoreboardMessage extends BaseMessage {
    @Getter
    private final String name;
    @Getter
    private final String objective;
    @Getter
    private final String value;

    public ScoreboardMessage(String name, String objective, String value) {
        this.name = name;
        this.objective = objective;
        this.value = value;
    }

    @Override
    public String getString() {
        return Weave.getBackend().getMessageDispatcher().dispatch(this);
    }
}
