package net.weavemc.chat;

public final class TextMessage extends BaseMessage {
    private final String text;

    public TextMessage(String txt) {
        this.text = txt;
    }

    @Override
    public String getString() {
        return text;
    }
}
