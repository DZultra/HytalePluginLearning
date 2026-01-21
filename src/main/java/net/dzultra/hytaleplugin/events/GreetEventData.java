package net.dzultra.hytaleplugin.events;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class GreetEventData {
    public String playerName;

    public static final BuilderCodec<GreetEventData> CODEC = BuilderCodec.builder(
            GreetEventData.class, GreetEventData::new
    ).append(
            new KeyedCodec<>("@Playername", Codec.STRING),
            (obj, val) -> obj.playerName = val,
            obj -> obj.playerName
    ).add().build();
}
