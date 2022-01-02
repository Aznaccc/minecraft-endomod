package net.aznac.endomod.block.entity;

import net.aznac.endomod.AznacMod;
import net.aznac.endomod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<InfusionBenchBlockEntity> INFUSION_BENCH_BLOCK_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(AznacMod.MOD_ID, "infusion_bench"),
                    FabricBlockEntityTypeBuilder.create(InfusionBenchBlockEntity ::new,
                            ModBlocks.INFUSION_BENCH_BLOCK).build(null));
}
