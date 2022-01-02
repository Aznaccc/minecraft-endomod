package net.aznac.endomod.item;

import net.aznac.endomod.AznacMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup GLADIER = FabricItemGroupBuilder.build(new Identifier(AznacMod.MOD_ID, "gladier"),
            () -> new ItemStack(ModItems.GLADIER));
    public static final ItemGroup EFFECTED_GLADIER = FabricItemGroupBuilder.build(new Identifier(AznacMod.MOD_ID, "effected_gladier"),
            () -> new ItemStack(ModItems.GLADIER));
}
