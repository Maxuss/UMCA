package net.weavemc;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class Weave {
    @Getter
    private static String backendName;
    @Getter
    private static String version;
    @Getter
    private static String minecraftVersion;
    @Getter
    private static Backend backend;

    public void setBackend(@NotNull Backend backend) {
        Weave.backend = backend;
        Weave.backendName = backend.getName();
        Weave.version = backend.getApiVersion();
        Weave.minecraftVersion = backend.getMinecraftVersion();
    }
}
