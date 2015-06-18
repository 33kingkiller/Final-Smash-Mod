package am.dx._33kingkiller_hub.entity.passive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderSmashCube extends RenderLiving {

	//Defines the location of entity textures.
	private static final ResourceLocation smashcubeTextures = new ResourceLocation("finalsmash:textures/entity/smashcube.png");

	//Constructor.
    public RenderSmashCube(RenderManager p_i46187_1_, ModelBase p_i46187_2_, float p_i46187_3_) {
        super(p_i46187_1_, p_i46187_2_, p_i46187_3_);
    }

    //Setter for entity texture locations.
    protected ResourceLocation func_180572_a(EntitySmashCube entity) {
        return smashcubeTextures;
    }
    
    //Getter for entity texture locations.
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.func_180572_a((EntitySmashCube) entity);
    }

}
