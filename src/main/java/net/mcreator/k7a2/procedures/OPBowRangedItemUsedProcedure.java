package net.mcreator.k7a2.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.k7a2.potion.PotionOfK7A2DamPotionEffect;
import net.mcreator.k7a2.K7a2Mod;

import java.util.Map;

public class OPBowRangedItemUsedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				K7a2Mod.LOGGER.warn("Failed to load dependency entity for procedure OPBowRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(PotionOfK7A2DamPotionEffect.potion, (int) 200, (int) 1));
	}
}
