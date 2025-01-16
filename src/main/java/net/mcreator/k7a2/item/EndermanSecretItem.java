
package net.mcreator.k7a2.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import net.mcreator.k7a2.itemgroup.K7A2ItemGroup;
import net.mcreator.k7a2.K7a2ModElements;

@K7a2ModElements.ModElement.Tag
public class EndermanSecretItem extends K7a2ModElements.ModElement {
	@ObjectHolder("k7a2:enderman_secret")
	public static final Item block = null;

	public EndermanSecretItem(K7a2ModElements instance) {
		super(instance, 213);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, K7a2ModElements.sounds.get(new ResourceLocation("k7a2:endermansecret")),
					new Item.Properties().group(K7A2ItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("enderman_secret");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
