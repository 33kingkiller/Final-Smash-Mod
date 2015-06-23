package am.dx._33kingkiller_hub.entity;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import am.dx._33kingkiller_hub.entity.passive.EntitySmashCube;
import am.dx._33kingkiller_hub.main.Smash;

public class EntitySmashRegistry {

	//Referred to by the Smash.java.
	public static void EntityRegistry() {
		RegisterEntity();
	}
	
	//Registers entities.
	public static void RegisterEntity() {
		CreateEntity(EntitySmashCube.class, "SmashCube", 27);
		CreateEntity(EntitySmashEgg.class, "SmashEgg", 28);
		CreateEntity(EntityZeldaArrow.class, "ZeldaArrow", 29);
		CreateEntity(EntityPitArrow.class, "PitArrow", 30);
		CreateEntity(EntityBlast.class, "MegamanBlast", 31);
		
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
			if (BiomeGenBase.getBiomeGenArray() != null) {
				EntityRegistry.addSpawn(EntitySmashCube.class, 399, 1, 1, EnumCreatureType.CREATURE, BiomeGenBase.getBiome(1));
			}
		}
	}
	//Creates/tracks entities.
	@SuppressWarnings("unchecked")
	public static void CreateEntity(@SuppressWarnings("rawtypes") Class entityClass, String entityName, int entityID) {
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, Smash.modInstance, 64, 1, true);
	}
	
}
