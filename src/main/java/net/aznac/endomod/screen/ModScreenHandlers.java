package net.aznac.endomod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.aznac.endomod.AznacMod;

public class ModScreenHandlers {
    public static ScreenHandlerType<InfusionBenchScreenHandler> INFUSION_BENCH_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(AznacMod.MOD_ID, "infusion_bench"),
                    InfusionBenchScreenHandler::new);
}