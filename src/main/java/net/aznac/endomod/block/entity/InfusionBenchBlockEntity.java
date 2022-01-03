package net.aznac.endomod.block.entity;

import net.aznac.endomod.item.ModItems;
import net.aznac.endomod.item.inventory.ImplementedInventory;
import net.aznac.endomod.screen.InfusionBenchScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class InfusionBenchBlockEntity extends BlockEntity implements  NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(5, ItemStack.EMPTY);

    public InfusionBenchBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.INFUSION_BENCH_BLOCK_ENTITY, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Infusion Bench");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new InfusionBenchScreenHandler(syncId, inv, this);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;

    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
    }

    public static void tick(World world, BlockPos pos, BlockState state, InfusionBenchBlockEntity entity) {
        if(hasRecipe(entity) && hasNotReachedStackLimit(entity)) {
            craftItem(entity);

            }
        }

    private static void craftItem(InfusionBenchBlockEntity entity) {
        entity.removeStack(0, 1);
        entity.removeStack(1, 1);
        entity.removeStack(2, 1);
        entity.removeStack(3, 1);

        entity.setStack(4, new ItemStack(ModItems.STRENGTH_ONE_AXE, entity.getStack(3).getCount() + 1));
    }

    private static boolean hasRecipe(InfusionBenchBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == ModItems.GLADIER_AXE;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == Items.BLAZE_POWDER;
        boolean hasItemInThirdSlot = entity.getStack(2).getItem() == Items.BLAZE_POWDER;
        boolean hasItemInFourthSlot = entity.getStack(3).getItem() == Items.NETHER_WART;

        return hasItemInFirstSlot && hasItemInSecondSlot && hasItemInThirdSlot && hasItemInFourthSlot;
    }

    private static boolean hasNotReachedStackLimit(InfusionBenchBlockEntity entity) {
        return entity.getStack(4).getCount() < entity.getStack(4).getMaxCount();
    }

}
