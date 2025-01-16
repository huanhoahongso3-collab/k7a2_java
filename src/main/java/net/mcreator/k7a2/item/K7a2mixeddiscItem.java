
package net.mcreator.k7a2.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.k7a2.itemgroup.K7A2ItemGroup;
import net.mcreator.k7a2.K7a2ModElements;

@K7a2ModElements.ModElement.Tag
public class K7a2mixeddiscItem extends K7a2ModElements.ModElement {
	@ObjectHolder("k7a2:k_7a_2mixeddisc")
	public static final Item block = null;

	public K7a2mixeddiscItem(K7a2ModElements instance) {
		super(instance, 64);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, K7a2ModElements.sounds.get(new ResourceLocation("k7a2:k7a2_mixed_voice")),
					new Item.Properties().group(K7A2ItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("k_7a_2mixeddisc");
		}
	}
}
