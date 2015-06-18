package am.dx._33kingkiller_hub.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import am.dx._33kingkiller_hub.entity.EntitySmashRegistry;
import am.dx._33kingkiller_hub.item.ItemSmashBall;

import com.webs.kingkillersModCore.item.ItemCore;

@Mod(modid = Smash.MODID, version = Smash.VERSION, name = Smash.NAME)
public class Smash {
	
	//FML important variables. DO NOT CHANGE "MODID."
    public static final String MODID = "FinalSmash";
    public static final String VERSION = "pre1.0";
    public static final String NAME = "Final Smash Mod";
    
    //Defines proxy classes.
    @SidedProxy(clientSide = "am.dx._33kingkiller_hub.main.ClientSidedProxy", serverSide = "am.dx._33kingkiller_hub.main.ServerSidedProxy")
    public static ServerSidedProxy proxy;
    
    //Creates item variables.
    public static Item itemSmashBall;
    
    //Creates a custom creative tab.
    public static CreativeTabs tabSmash = new CreativeTabs("FinalSmash") {
		@Override
		public Item getTabIconItem() {
			return itemSmashBall;
		}
    };
    
    //Runs before the FML starts.
    @EventHandler
    public void preinit(FMLPreInitializationEvent e) {
    	Item();
    	Crafting();
    	Credit();
    }
    
    //Runs while FML is starting
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	//Registers item models/textures.
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemSmashBall, 0, new ModelResourceLocation("finalsmash:FinalSmashitem.itemSmashBall", "inventory"));
    	
    	//Enables the custom entity registry/renderer.
    	EntitySmashRegistry.EntityRegistry();
    	proxy.RegisterRenderer();
    }
    
    //Registers and defines items.
    public void Item() {
    	//Defines item variables.
    	itemSmashBall = new ItemSmashBall().setUnlocalizedName("itemSmashBall").setCreativeTab(tabSmash);
    	
    	//Registers items.
    	ItemCore.RegisterItemVariable(itemSmashBall, MODID);
    }
    
    //Registers crafting recipes.
    public void Crafting() {
    	
    }
    
    //Prints credits to the console.
    public void Credit() {
    	System.out.println("Final Smash Mod - 33kingkiller & hayhay01em03");
    }
}
