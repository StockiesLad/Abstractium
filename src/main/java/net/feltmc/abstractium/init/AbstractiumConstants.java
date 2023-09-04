package net.feltmc.abstractium.init;

import net.feltmc.abstractium.util.console.ChainLogger;

import java.util.List;

public interface AbstractiumConstants {
    String MOD_NAME = "Abstractium";
    String MOD_ID = MOD_NAME.toLowerCase();
    ChainLogger LOGGER = new ChainLogger(MOD_NAME);
    List<String> INTERNAL_MOD_IDS = List.of(MOD_ID + "_1182");
}
