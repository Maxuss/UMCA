package net.weavemc.block;

import net.weavemc.utils.Pos;

public interface Block {
    Pos getPos();
    BlockType getType();
}
