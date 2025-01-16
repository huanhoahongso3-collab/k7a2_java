
package net.mcreator.k7a2.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.k7a2.block.BlockofK7A2Block;
import net.mcreator.k7a2.K7a2ModElements;

@K7a2ModElements.ModElement.Tag
public class K7A2BuildingBlockItemGroup extends K7a2ModElements.ModElement {
	public K7A2BuildingBlockItemGroup(K7a2ModElements instance) {
		super(instance, 220);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabk_7_a_2_building_block") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlockofK7A2Block.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
