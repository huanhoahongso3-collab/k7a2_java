
package net.mcreator.k7a2.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ShearsItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.k7a2.itemgroup.K7A2ItemGroup;
import net.mcreator.k7a2.K7a2ModElements;

@K7a2ModElements.ModElement.Tag
public class K7A2ShearsItem extends K7a2ModElements.ModElement {
	@ObjectHolder("k7a2:k_7_a_2_shears")
	public static final Item block = null;

	public K7A2ShearsItem(K7a2ModElements instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShearsItem(new Item.Properties().group(K7A2ItemGroup.tab).maxDamage(56210)) {
			@Override
			public int getItemEnchantability() {
				return 25;
			}

			@Override
			public float getDestroySpeed(ItemStack stack, BlockState block) {
				return 56201f;
			}
		}.setRegistryName("k_7_a_2_shears"));
	}
}
