package de.rfeoi.openterminal;

import com.google.gson.Gson;
import de.rfeoi.openterminal.webApi.WebAPI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;

import java.io.IOException;

@Mod(modid = OpenTerminal.MOD_ID, name = OpenTerminal.NAME, version = OpenTerminal.VERSION)
public class OpenTerminal {
    public static final String MOD_ID = "openterminal", VERSION = "0.1", NAME = "Open Terminal";
    public static Gson GSON = new Gson();
    private WebAPI webAPI;

    @Mod.EventHandler
    public void onServerStart(FMLServerStartedEvent event) {
        try {
            //TODO read port from config
            webAPI = new WebAPI(25566);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
