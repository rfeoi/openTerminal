package de.rfeoi.openterminal;

import com.google.gson.Gson;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = OpenTerminal.MOD_ID, name = OpenTerminal.NAME, version = OpenTerminal.VERSION)
public class OpenTerminal {
    public static final String MOD_ID = "openterminal", VERSION = "0.1", NAME = "Open Terminal";
    public static Gson GSON = new Gson();
}
