
package net.mcreator.k7a2.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.k7a2.itemgroup.K7A2ItemGroup;
import net.mcreator.k7a2.K7a2ModElements;

import java.util.List;

@K7a2ModElements.ModElement.Tag
public class HanhKhucCBHItem extends K7a2ModElements.ModElement {
	@ObjectHolder("k7a2:hanh_khuc_cbh")
	public static final Item block = null;

	public HanhKhucCBHItem(K7a2ModElements instance) {
		super(instance, 58);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, K7a2ModElements.sounds.get(new ResourceLocation("k7a2:flashmobcbh")),
					new Item.Properties().group(K7A2ItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("hanh_khuc_cbh");
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Het ciu"));
		}
	}
}
