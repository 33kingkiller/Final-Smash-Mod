package am.dx._33kingkiller_hub.entity.passive;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSmashCube extends RenderLiving {

	//Defines the location of entity textures.
	private static final ResourceLocation smashcubeTextures = new ResourceLocation("finalsmash:textures/entity/smashcube.png");

	//Constructor.
    public RenderSmashCube(ModelBase p_i46187_2_, float p_i46187_3_) {
        super(Minecraft.getMinecraft().getRenderManager(), p_i46187_2_, p_i46187_3_);
    }

    //Setter for entity texture locations.
    protected ResourceLocation func_180572_a(EntitySmashCube entity) {
        return smashcubeTextures;
    }
    
    //Getter for entity texture locations.
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.func_180572_a((EntitySmashCube) entity);
    }

}
