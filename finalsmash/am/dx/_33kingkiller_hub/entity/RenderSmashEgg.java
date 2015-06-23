package am.dx._33kingkiller_hub.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderSmashEgg extends Render {
	
	private static final ResourceLocation eggTextures = new ResourceLocation("finalsmash:textures/entity/smashegg.png");

	//Constructor.
	public RenderSmashEgg() {
		super(Minecraft.getMinecraft().getRenderManager());
	}

	//Setter for entity texture locations.
    protected ResourceLocation func_180572_a(EntitySmashEgg entity) {
        return eggTextures;
    }
    
    //Getter for entity texture locations.
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.func_180572_a((EntitySmashEgg) entity);
    }

}
