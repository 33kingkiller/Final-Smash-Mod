package am.dx._33kingkiller_hub.entity;

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
		CreateEntity(EntitySmashCube.class, "SmashCube", 27);
	}
	//Creates/tracks entities.
	@SuppressWarnings("unchecked")
	public static void CreateEntity(@SuppressWarnings("rawtypes") Class entityClass, String entityName, int entityID) {
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, Smash.modInstance, 64, 1, true);
	}
	
}
