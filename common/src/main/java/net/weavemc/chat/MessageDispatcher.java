package net.weavemc.chat;

public interface MessageDispatcher {
    String dispatch(TranslatableMessage msg);
    String dispatch(ScoreboardMessage msg);
    String dispatch(SelectorMessage msg);
    String dispatch(KeybindMessage msg);
}
