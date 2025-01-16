
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

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.OpenDoorGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AgeableEntity;

import net.mcreator.k7a2.item.K7A2ingotItem;
import net.mcreator.k7a2.entity.renderer.DangTuanMinhRenderer;
import net.mcreator.k7a2.K7a2ModElements;

@K7a2ModElements.ModElement.Tag
public class DangTuanMinhEntity extends K7a2ModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
			.size(1.4f, 0.9f)).build("dang_tuan_minh").setRegistryName("dang_tuan_minh");

	public DangTuanMinhEntity(K7a2ModElements instance) {
		super(instance, 22);
		FMLJavaModLoadingContext.get().getModEventBus().register(new DangTuanMinhRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("dang_tuan_minh_spawn_egg"));
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
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 30);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 20);
			ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends AnimalEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(4, new BreedGoal(this, 1));
			this.goalSelector.addGoal(5, new FollowParentGoal(this, 0.8));
			this.goalSelector.addGoal(6, new MeleeAttackGoal(this, 1.2, false) {
				@Override
				protected double getAttackReachSqr(LivingEntity entity) {
					return (double) (4.0 + entity.getWidth() * entity.getWidth());
				}
			});
			this.targetSelector.addGoal(7, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(8, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(9, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(10, new SwimGoal(this));
			this.goalSelector.addGoal(11, new OpenDoorGoal(this, true));
			this.goalSelector.addGoal(12, new OpenDoorGoal(this, false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(K7A2ingotItem.block));
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("k7a2:dangminh"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
			CustomEntity retval = (CustomEntity) entity.create(serverWorld);
			retval.onInitialSpawn(serverWorld, serverWorld.getDifficultyForLocation(new BlockPos(retval.getPosition())), SpawnReason.BREEDING,
					(ILivingEntityData) null, (CompoundNBT) null);
			return retval;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (K7A2ingotItem.block == stack.getItem())
				return true;
			return false;
		}
	}
}
