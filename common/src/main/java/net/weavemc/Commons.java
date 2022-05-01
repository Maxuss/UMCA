package net.weavemc;

import lombok.Getter;

public class Commons {
    @Getter
    private static String backendName;
    @Getter
    private static String version;
    @Getter
    private static String minecraftVersion;
    @Getter
    private static Backend backend;

    public void setBackend(Backend backend) {
        Commons.backend = backend;
        Commons.backendName = backend.getName();
        Commons.version = backend.getApiVersion();
        Commons.minecraftVersion = backend.getMinecraftVersion();
    }
}
