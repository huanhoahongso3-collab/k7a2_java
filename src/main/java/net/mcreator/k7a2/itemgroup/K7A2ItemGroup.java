
package net.mcreator.k7a2.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.k7a2.item.K7A2ingotItem;
import net.mcreator.k7a2.K7a2ModElements;

@K7a2ModElements.ModElement.Tag
public class K7A2ItemGroup extends K7a2ModElements.ModElement {
	public K7A2ItemGroup(K7a2ModElements instance) {
		super(instance, 88);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabk_7_a_2") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(K7A2ingotItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
