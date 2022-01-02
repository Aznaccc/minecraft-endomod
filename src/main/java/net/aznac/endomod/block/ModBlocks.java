package net.aznac.endomod.block;

import net.aznac.endomod.AznacMod;
import net.aznac.endomod.block.custom.InfusionBenchBlock;
import net.aznac.endomod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block GLADIER_ORE = registerBlock("gladier_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.0f)
                    .breakByTool(FabricToolTags.PICKAXES, 3).requiresTool()));

    public static final Block GLADIER_BLOCK = registerBlock("gladier_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.0f)
                    .breakByTool(FabricToolTags.PICKAXES, 3).requiresTool()));

    public static final Block INFUSION_BENCH_BLOCK = registerBlock("infusion_bench",
            new InfusionBenchBlock(FabricBlockSettings.of(Material.METAL)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(AznacMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(AznacMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.GLADIER)));
    }

    public static void registerModBlocks() {
        System.out.println("Registering ModBlocks for " + AznacMod.MOD_ID);
    }
}
