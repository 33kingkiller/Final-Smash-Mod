package am.dx._33kingkiller_hub.entity;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import am.dx._33kingkiller_hub.entity.passive.EntitySmashCube;
import am.dx._33kingkiller_hub.main.Smash;

public class EntitySmashRegistry {

	//Referred to by the Smash.java.
	public static void EntityRegistry() {
		RegisterEntity();
	}
	
	//Registers entities to eggs.
	public static void RegisterEntity() {
		CreateEntity(EntitySmashCube.class, "SmashCube", 0x4800FF, 0xFFB600, 27);
	}
	//Creates/tracks entities.
	@SuppressWarnings("unchecked")
	public static void CreateEntity(@SuppressWarnings("rawtypes") Class entityClass, String entityName, int solidColour, int spotColour, int entityID) {
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, Smash.modInstance, 64, 1, true);
		
		CreateEgg(entityClass, entityName, entityID, solidColour, spotColour);
	}
	
	//Creates entity eggs.
	@SuppressWarnings("rawtypes")
	public static void CreateEgg(Class entityClass, String entityName, int entityID, int solidColour, int spotColour) {
		EntityList.addMapping(entityClass, entityName, entityID, solidColour, spotColour);
	}
	
}
