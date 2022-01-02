package net.aznac.endomod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.aznac.endomod.AznacMod;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;


public class ModItems {


    public static final Item GLADIER = registerItem("gladier",
            new Item(new FabricItemSettings().group(ModItemGroup.GLADIER)));

    public static final Item GLADIER_CHUNK = registerItem("gladier_chunk",
            new Item(new FabricItemSettings().group(ModItemGroup.GLADIER)));

    public static Item GLADIER_PICKAXE = registerItem("gladier_pickaxe",
            new CustomPickaxeItem(ToolMaterialGladier.INSTANCE, -3, -2.8F, new Item.Settings().group(ModItemGroup.GLADIER)));

    public static Item HASTE_PICKAXE = registerItem("haste_pickaxe",
            new HastePickaxeItem(ToolMaterialGladier.INSTANCE, -3, -2.8F, new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

    public static Item GLADIER_AXE = registerItem("gladier_axe",
            new CustomAxeItem(ToolMaterialGladier.INSTANCE, 1, -2.8F, new Item.Settings().group(ModItemGroup.GLADIER)));

    public static Item STRENGTH_TWO_AXE = registerItem("strength_two_axe",
            new StrengthTwoAxeItem(ToolMaterialGladier.INSTANCE, 1, -2.8F, new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

    public static Item STRENGTH_ONE_AXE = registerItem("strength_one_axe",
            new StrengthOneAxeItem(ToolMaterialGladier.INSTANCE, 1, -2.8F, new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

    public static Item HASTE_AXE = registerItem("haste_axe",
            new HasteAxeItem(ToolMaterialGladier.INSTANCE, 1, -2.8F, new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));


    public static Item GLADIER_SWORD = registerItem("gladier_sword",
            new CustomSwordItem(ToolMaterialGladier.INSTANCE, -1, -2.8F, new Item.Settings().group(ModItemGroup.GLADIER)));

    public static Item STRENGTH_TWO_SWORD = registerItem("strength_two_sword",
            new StrengthTwoSwordItem(ToolMaterialGladier.INSTANCE, -1, -2.8F, new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

    public static Item STRENGTH_ONE_SWORD = registerItem("strength_one_sword",
            new StrengthOneSwordItem(ToolMaterialGladier.INSTANCE, -1, -2.8F, new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));


    public static Item GLADIER_SHOVEL = registerItem("gladier_shovel",
            new CustomShovelItem(ToolMaterialGladier.INSTANCE, -5, -2.8F, new Item.Settings().group(ModItemGroup.GLADIER)));

    public static Item HASTE_SHOVEL = registerItem("haste_shovel",
            new HasteShovelItem(ToolMaterialGladier.INSTANCE, -5, -2.8F, new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));


    public static Item GLADIER_HOE = registerItem("gladier_hoe",
            new CustomHoeItem(ToolMaterialGladier.INSTANCE, -5, -2.8F, new Item.Settings().group(ModItemGroup.GLADIER)));

    public static Item STRENGTH_HOE = registerItem("strength_hoe",
            new StrengthTenHoeItem(ToolMaterialGladier.INSTANCE, -5, -2.8F, new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

    public static Item HASTE_HOE = registerItem("haste_hoe",
            new HasteHoeItem(ToolMaterialGladier.INSTANCE, -5, -2.8F, new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));


    public static class CustomPickaxeItem extends PickaxeItem {
        public CustomPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class CustomHoeItem extends HoeItem {
        public CustomHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class CustomAxeItem extends AxeItem {
        public CustomAxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class StrengthTwoAxeItem extends AxeItem {
        public StrengthTwoAxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
        {
            LivingEntity player = (LivingEntity) entity;
            ItemStack equippedMain = player.getMainHandStack();

            if(stack.equals(equippedMain))
            {
                if(entity instanceof PlayerEntity)
                {
                    StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.STRENGTH, 20, 1, false, true);

                    player.addStatusEffect(effect);
                }
            }

        }
    }

    public static class HasteAxeItem extends AxeItem {
        public HasteAxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
        {
            LivingEntity player = (LivingEntity) entity;
            ItemStack equippedMain = player.getMainHandStack();

            if(stack.equals(equippedMain))
            {
                if(entity instanceof PlayerEntity)
                {
                    StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.HASTE, 20, 1, false, true);

                    player.addStatusEffect(effect);
                }
            }

        }
    }

    public static class HastePickaxeItem extends PickaxeItem {
        public HastePickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
        {
            LivingEntity player = (LivingEntity) entity;
            ItemStack equippedMain = player.getMainHandStack();

            if(stack.equals(equippedMain))
            {
                if(entity instanceof PlayerEntity)
                {
                    StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.HASTE, 20, 1, false, true);

                    player.addStatusEffect(effect);
                }
            }

        }
    }

    public static class HasteShovelItem extends ShovelItem {
        public HasteShovelItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
        {
            LivingEntity player = (LivingEntity) entity;
            ItemStack equippedMain = player.getMainHandStack();

            if(stack.equals(equippedMain))
            {
                if(entity instanceof PlayerEntity)
                {
                    StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.HASTE, 20, 1, false, true);

                    player.addStatusEffect(effect);
                }
            }

        }
    }

    public static class HasteHoeItem extends HoeItem {
        public HasteHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
        {
            LivingEntity player = (LivingEntity) entity;
            ItemStack equippedMain = player.getMainHandStack();

            if(stack.equals(equippedMain))
            {
                if(entity instanceof PlayerEntity)
                {
                    StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.HASTE, 20, 1, false, true);

                    player.addStatusEffect(effect);
                }
            }

        }
    }

    public static class StrengthTwoSwordItem extends SwordItem {
        public StrengthTwoSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
        {
            LivingEntity player = (LivingEntity) entity;
            ItemStack equippedMain = player.getMainHandStack();

            if(stack.equals(equippedMain))
            {
                if(entity instanceof PlayerEntity)
                {
                    StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.STRENGTH, 20, 1, false, true);

                    player.addStatusEffect(effect);
                }
            }

        }
    }

    public static class StrengthTenHoeItem extends HoeItem {
        public StrengthTenHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
        {
            LivingEntity player = (LivingEntity) entity;
            ItemStack equippedMain = player.getMainHandStack();

            if(stack.equals(equippedMain))
            {
                if(entity instanceof PlayerEntity)
                {
                    StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.STRENGTH, 20, 9, false, true);

                    player.addStatusEffect(effect);
                }
            }

        }
    }

    public static class StrengthOneAxeItem extends AxeItem {
        public StrengthOneAxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
        {
            LivingEntity player = (LivingEntity) entity;
            ItemStack equippedMain = player.getMainHandStack();

            if(stack.equals(equippedMain))
            {
                if(entity instanceof PlayerEntity)
                {
                    StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.STRENGTH, 20, 0, false, true);

                    player.addStatusEffect(effect);
                }
            }

        }
    }

    public static class CustomShovelItem extends ShovelItem {
        public CustomShovelItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class StrengthOneSwordItem extends SwordItem {
        public StrengthOneSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
        {
            LivingEntity player = (LivingEntity) entity;
            ItemStack equippedMain = player.getMainHandStack();

            if(stack.equals(equippedMain))
            {
                if(entity instanceof PlayerEntity)
                {
                    StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.STRENGTH, 20, 0, false, false);

                    player.addStatusEffect(effect);
                }
            }

        }




        public static final Item GLADIER_HELMET = registerItem("gladier_helmet",
                new ModArmorItemChestplate(ModArmorMaterial.GLADIER, EquipmentSlot.HEAD,
                        new Item.Settings().group(ModItemGroup.GLADIER)));

        public static final Item GLADIER_CHESTPLATE = registerItem("gladier_chestplate",
                new ArmorItem(ModArmorMaterial.GLADIER, EquipmentSlot.CHEST,
                        new Item.Settings().group(ModItemGroup.GLADIER)));


        public static final Item GLADIER_LEGGINGS = registerItem("gladier_leggings",
                new ArmorItem(ModArmorMaterial.GLADIER, EquipmentSlot.LEGS,
                        new Item.Settings().group(ModItemGroup.GLADIER)));

        public static final Item GLADIER_BOOTS = registerItem("gladier_boots",
                new ArmorItem(ModArmorMaterial.GLADIER, EquipmentSlot.FEET,
                        new Item.Settings().group(ModItemGroup.GLADIER)));

        public static final Item INVIS_BOOTS = registerItem("invis_boots",
                new ModArmorItemBoots(InvisArmorMaterial.INVIS, EquipmentSlot.FEET,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item SPEED_BOOTS = registerItem("speed_boots",
                new ModArmorItemBoots(SpeedArmorMaterial.SPEED, EquipmentSlot.FEET,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item SPEEDTWO_BOOTS = registerItem("speedtwo_boots",
                new ModArmorItemBootsLVLTWO(SpeedTwoArmorMaterial.SPEEDTWO, EquipmentSlot.FEET,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item JUMP_BOOTS = registerItem("jump_boots",
                new ModArmorItemBoots(JumpBoostArmorMaterial.JUMP, EquipmentSlot.FEET,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item JUMPTWO_BOOTS = registerItem("jumptwo_boots",
                new ModArmorItemBootsLVLTWO(JumpBoostTwoArmorMaterial.JUMPTWO, EquipmentSlot.FEET,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item REGEN_LEGGINGS = registerItem("regen_leggings",
                new ModArmorItemLeggings(RegenArmorMaterial.REGEN, EquipmentSlot.LEGS,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item REGEN_CHESTPLATE = registerItem("regen_chestplate",
                new ModArmorItemChestplate(RegenArmorMaterial.REGEN, EquipmentSlot.CHEST,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item REGENTWO_CHESTPLATE = registerItem("regentwo_chestplate",
                new ModArmorItemChestplateLVLTWO(RegenTwoArmorMaterial.REGENTWO, EquipmentSlot.CHEST,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item REGENTWO_LEGGINGS = registerItem("regentwo_leggings",
                new ModArmorItemLeggingsLVLTWO(RegenTwoArmorMaterial.REGENTWO, EquipmentSlot.LEGS,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item FIRERES_LEGGINGS = registerItem("fireres_leggings",
                new ModArmorItemLeggings(FireResArmorMaterial.FIRERES, EquipmentSlot.LEGS,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item FIRERES_CHESTPLATE = registerItem("fireres_chestplate",
                new ModArmorItemChestplate(FireResArmorMaterial.FIRERES, EquipmentSlot.CHEST,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item WATER_BREATHING_HELMET = registerItem("water_breathing_helmet",
                new ModArmorItemHelmet(WaterBreathingArmorMaterial.WATERBREATHING, EquipmentSlot.HEAD,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));

        public static final Item NIGHT_VISION_HELMET = registerItem("night_vision_helmet",
                new ModArmorItemHelmet(NightVisionArmorMaterial.NIGHTVISION, EquipmentSlot.HEAD,
                        new Item.Settings().group(ModItemGroup.EFFECTED_GLADIER)));
    }


    public static class CustomSwordItem extends SwordItem {
        public CustomSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AznacMod.MOD_ID, name), item);
    }


    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + "TutorialMod.MOD_ID");
    }
}
