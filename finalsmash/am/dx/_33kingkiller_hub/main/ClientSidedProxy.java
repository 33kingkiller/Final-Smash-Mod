package am.dx._33kingkiller_hub.main;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import am.dx._33kingkiller_hub.entity.passive.*;
import am.dx._33kingkiller_hub.entity.*;

public class ClientSidedProxy extends ServerSidedProxy {

	//Registers proxy stuff for the client side.
	@Override
	public void RegisterRenderer() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySmashCube.class, new RenderSmashCube(new ModelSmashCube(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmashEgg.class, new RenderSmashEgg());
		RenderingRegistry.registerEntityRenderingHandler(EntityZeldaArrow.class, new RenderZeldaArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityPitArrow.class, new RenderPitArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlast.class, new RenderBlast());
	}
	
}
