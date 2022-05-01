package net.weavemc;

import net.weavemc.chat.MessageDispatcher;

public interface Backend {
    String getName();
    String getApiVersion();
    String getMinecraftVersion();
    MessageDispatcher getMessageDispatcher();
    boolean isClient();
    boolean isServer();
}
