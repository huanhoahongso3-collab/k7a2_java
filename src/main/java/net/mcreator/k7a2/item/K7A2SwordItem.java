
package net.mcreator.k7a2.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.k7a2.itemgroup.K7A2ItemGroup;
import net.mcreator.k7a2.K7a2ModElements;

@K7a2ModElements.ModElement.Tag
public class K7A2SwordItem extends K7a2ModElements.ModElement {
	@ObjectHolder("k7a2:k_7_a_2_sword")
	public static final Item block = null;

	public K7A2SwordItem(K7a2ModElements instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 5610;
			}

			public float getEfficiency() {
				return 56201f;
			}

			public float getAttackDamage() {
				return 8.5f;
			}

			public int getHarvestLevel() {
				return 7;
			}

			public int getEnchantability() {
				return 25;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SuperK7A2IngotItem.block));
			}
		}, 3, -2.25f, new Item.Properties().group(K7A2ItemGroup.tab)) {
		}.setRegistryName("k_7_a_2_sword"));
	}
}
