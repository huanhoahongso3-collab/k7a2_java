
package net.mcreator.k7a2.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.k7a2.itemgroup.K7A2ItemGroup;
import net.mcreator.k7a2.K7a2ModElements;

@K7a2ModElements.ModElement.Tag
public class BattleGoldenAxeItem extends K7a2ModElements.ModElement {
	@ObjectHolder("k7a2:battle_golden_axe")
	public static final Item block = null;

	public BattleGoldenAxeItem(K7a2ModElements instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 5500;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 18.5f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 25;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SuperK7A2IngotItem.block));
			}
		}, 1, -2.75f, new Item.Properties().group(K7A2ItemGroup.tab)) {
		}.setRegistryName("battle_golden_axe"));
	}
}
