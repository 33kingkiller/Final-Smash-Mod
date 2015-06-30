package am.dx._33kingkiller_hub.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class EntityFXGoldDiamond extends EntityFX {
	
	private static final ResourceLocation particleTextures = new ResourceLocation("finalsmash:textures/entity/particles/gold_diamond.png");

	public EntityFXGoldDiamond(World worldIn, double xCoordIn, double yCoordIn,
			double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
		setGravity(-0.5F);
	}
	
	@Override
	public void func_180434_a(WorldRenderer rend, Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
		Minecraft.getMinecraft().renderEngine.bindTexture(particleTextures);
		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
		rend.startDrawingQuads();
		rend.setBrightness(getBrightnessForRender(f));
		float scale = 0.1F*particleScale;
		float x = (float)(prevPosX + (posX - prevPosX) * f - interpPosX);
		float y = (float)(prevPosY + (posY - prevPosY) * f - interpPosY);
		float z = (float)(prevPosZ + (posZ - prevPosZ) * f - interpPosZ);
		rend.addVertexWithUV(x - f1 * scale - f4 * scale, y - f2 * scale, z - f3 * scale - f5 * scale, 0, 0);
		rend.addVertexWithUV(x - f1 * scale + f4 * scale, y + f2 * scale, z - f3 * scale + f5 * scale, 1, 0);
		rend.addVertexWithUV(x + f1 * scale + f4 * scale, y + f2 * scale, z + f3 * scale + f5 * scale, 1, 1);
		rend.addVertexWithUV(x + f1 * scale - f4 * scale, y - f2 * scale, z + f3 * scale - f5 * scale, 0, 1);
		rend.finishDrawing();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
	}
	
	@Override
	public int getFXLayer() {
		//TODO may need to be changed to 3.
		return 1;
	}
	
	public EntityFXGoldDiamond setMaxAge(int par) {
		particleMaxAge = par;
		return this;
	}
	
	public EntityFXGoldDiamond setGravity(float par) {
		particleGravity = par;
		return this;
	}
	
	public EntityFXGoldDiamond setScale(float par) {
		particleScale = par;
		return this;
	}

}
