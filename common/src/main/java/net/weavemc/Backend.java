package net.weavemc;

public interface Backend {
    String getName();
    String getApiVersion();
    String getMinecraftVersion();
    boolean isClient();
    boolean isServer();
}
