
package net.mcreator.k7a2.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.k7a2.itemgroup.K7A2ItemGroup;
import net.mcreator.k7a2.K7a2ModElements;

import java.util.List;
import java.util.Collections;

@K7a2ModElements.ModElement.Tag
public class DHPhucPlanksBlock extends K7a2ModElements.ModElement {
	@ObjectHolder("k7a2:dh_phuc_planks")
	public static final Block block = null;

	public DHPhucPlanksBlock(K7a2ModElements instance) {
		super(instance, 179);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(K7A2ItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(10f, 10.871694955165434f).setLightLevel(s -> 0)
					.harvestLevel(0).harvestTool(ToolType.AXE).setRequiresTool());
			setRegistryName("dh_phuc_planks");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 25;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
