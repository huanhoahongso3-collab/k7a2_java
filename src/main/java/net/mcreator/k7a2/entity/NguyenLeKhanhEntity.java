
package net.mcreator.k7a2.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.ReturnToVillageGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.OpenDoorGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.CreatureAttribute;

import net.mcreator.k7a2.item.ThienLyOiItem;
import net.mcreator.k7a2.entity.renderer.NguyenLeKhanhRenderer;
import net.mcreator.k7a2.K7a2ModElements;

@K7a2ModElements.ModElement.Tag
public class NguyenLeKhanhEntity extends K7a2ModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(0.6f, 1.95f)).build("nguyen_le_khanh").setRegistryName("nguyen_le_khanh");

	public NguyenLeKhanhEntity(K7a2ModElements instance) {
		super(instance, 13);
		FMLJavaModLoadingContext.get().getModEventBus().register(new NguyenLeKhanhRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("nguyen_le_khanh_spawn_egg"));
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("k7a2:k_7_a_2_biome").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("ocean").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("plains").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("desert").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("mountains").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("taiga").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("swamp").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("river").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("nether_wastes").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("the_end").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("frozen_ocean").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("frozen_river").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("snowy_tundra").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("snowy_mountains").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("mushroom_fields").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("mushroom_field_shore").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("beach").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("desert_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("wooded_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("taiga_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("mountain_edge").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("jungle").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("jungle_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("jungle_edge").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("deep_ocean").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("stone_shore").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("snowy_beach").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("birch_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("birch_forest_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("dark_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("snowy_taiga").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("snowy_taiga_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("giant_tree_taiga").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("giant_tree_taiga_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("wooded_mountains").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("savanna").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("savanna_plateau").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("badlands").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("wooded_badlands_plateau").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("badlands_plateau").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("warm_ocean").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("lukewarm_ocean").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("cold_ocean").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("deep_warm_ocean").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("deep_lukewarm_ocean").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("deep_cold_ocean").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("deep_frozen_ocean").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("sunflower_plains").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("desert_lakes").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("gravelly_mountains").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("flower_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("taiga_mountains").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("swamp_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("ice_spikes").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("modified_jungle").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("modified_jungle_edge").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("tall_birch_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("tall_birch_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("dark_forest_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("snowy_taiga_mountains").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("giant_spruce_taiga").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("giant_spruce_taiga_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("modified_gravelly_mountains").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("shattered_savanna").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("shattered_savanna_plateau").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("eroded_badlands").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("modified_wooded_badlands_plateau").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("modified_badlands_plateau").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("bamboo_jungle").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("bamboo_jungle_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("small_end_islands").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("end_midlands").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("end_highlands").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("end_barrens").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("the_void").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("soul_sand_valley").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("crimson_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("warped_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("basalt_deltas").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		event.getSpawns().getSpawner(EntityClassification.AMBIENT).add(new MobSpawnInfo.Spawners(entity, 20, 4, 4));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
	}

	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 20);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
			ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends VillagerEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.DIAMOND_HELMET));
			this.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
			this.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
			this.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(Items.DIAMOND_BOOTS));
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(3, new SwimGoal(this));
			this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));
			this.goalSelector.addGoal(5, new BreakDoorGoal(this, e -> true));
			this.goalSelector.addGoal(6, new OpenDoorGoal(this, false));
			this.goalSelector.addGoal(7, new OpenDoorGoal(this, true));
			this.goalSelector.addGoal(8, new ReturnToVillageGoal(this, 0.6, false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(ThienLyOiItem.block));
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("k7a2:khanh"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}
	}
}
