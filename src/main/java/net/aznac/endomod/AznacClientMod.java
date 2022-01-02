package net.aznac.endomod;


import net.aznac.endomod.screen.InfusionBenchScreen;
import net.aznac.endomod.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class AznacClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.INFUSION_BENCH_SCREEN_HANDLER, InfusionBenchScreen::new);
    }
}
