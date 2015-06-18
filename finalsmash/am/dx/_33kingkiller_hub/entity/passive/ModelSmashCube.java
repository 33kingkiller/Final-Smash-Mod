package am.dx._33kingkiller_hub.entity.passive;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSmashCube extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
  
  public ModelSmashCube()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(-3F, 0F, -3F, 7, 7, 7);
      Shape1.setRotationPoint(0F, 0F, 0F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 29, 0);
      Shape2.addBox(-3F, 0F, -3F, 9, 5, 5);
      Shape2.setRotationPoint(-1F, 1F, 1F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 29, 11);
      Shape3.addBox(-3F, 0F, -3F, 5, 9, 5);
      Shape3.setRotationPoint(1F, -1F, 1F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, Entity e)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, e);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
  }

}