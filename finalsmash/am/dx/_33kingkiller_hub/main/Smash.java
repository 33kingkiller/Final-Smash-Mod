package am.dx._33kingkiller_hub.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import am.dx._33kingkiller_hub.entity.EntitySmashRegistry;
import am.dx._33kingkiller_hub.item.ItemMarthSword;
import am.dx._33kingkiller_hub.item.ItemPitBow;
import am.dx._33kingkiller_hub.item.ItemSmashEgg;
import am.dx._33kingkiller_hub.item.ItemZeldaBow;

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
    
    @Instance(Smash.MODID)
    public static Smash modInstance;
    
    //Creates item variables.
    public static Item eggSmashCube;
    public static Item zeldaBow;
    public static Item itemZeldaArrow;
    public static Item marthSword;
    public static Item pitBow;
    
    //Tool Enums.
    public static ToolMaterial materialMarth;
    
    //Creates a custom creative tab.
    public static CreativeTabs tabSmash = new CreativeTabs("FinalSmash") {
		@Override
		public Item getTabIconItem() {
			return eggSmashCube;
		}
    };
    
    //Runs before the FML starts.
    @EventHandler
    public void preinit(FMLPreInitializationEvent e) {
    	Enums();
    	Item();
    	Crafting();
    	Credit();
    }
    
    //Runs while FML is starting
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	//Registers item models/textures.
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(eggSmashCube, 0, new ModelResourceLocation("finalsmash:FinalSmashitem.eggSmashCube", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemZeldaArrow, 0, new ModelResourceLocation("finalsmash:FinalSmashitem.itemZeldaArrow", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(marthSword, 0, new ModelResourceLocation("finalsmash:FinalSmashitem.marthSword", "inventory"));
    	
    	if(event.getSide().isClient()) {
            ModelBakery.addVariantName(zeldaBow, new String[] {MODID + ":FinalSmashitem.zeldaBow", MODID + ":FinalSmashitem.zeldaBow_pulling_0", MODID + ":FinalSmashitem.zeldaBow_pulling_1", MODID + ":FinalSmashitem.zeldaBow_pulling_2"});

            registerItem(zeldaBow, 0, MODID + ":FinalSmashitem.zeldaBow");
            registerItem(zeldaBow, 1, MODID + ":FinalSmashitem.zeldaBow_pulling_0");
            registerItem(zeldaBow, 2, MODID + ":FinalSmashitem.zeldaBow_pulling_1");
            registerItem(zeldaBow, 3, MODID + ":FinalSmashitem.zeldaBow_pulling_2");
            
            ModelBakery.addVariantName(pitBow, new String[] {MODID + ":FinalSmashitem.pitBow", MODID + ":FinalSmashitem.pitBow_pulling_0", MODID + ":FinalSmashitem.pitBow_pulling_1", MODID + ":FinalSmashitem.pitBow_pulling_2"});

            registerItem(pitBow, 0, MODID + ":FinalSmashitem.pitBow");
            registerItem(pitBow, 1, MODID + ":FinalSmashitem.pitBow_pulling_0");
            registerItem(pitBow, 2, MODID + ":FinalSmashitem.pitBow_pulling_1");
            registerItem(pitBow, 3, MODID + ":FinalSmashitem.pitBow_pulling_2");
        }
    	
    	//Enables the custom entity registry/renderer.
    	EntitySmashRegistry.EntityRegistry();
    	proxy.RegisterRenderer();
    }
    
    //Registers and defines items.
    public void Item() {
    	//Defines item variables.
    	eggSmashCube = new ItemSmashEgg().setUnlocalizedName("eggSmashCube");
    	zeldaBow = new ItemZeldaBow().setUnlocalizedName("zeldaBow").setCreativeTab(tabSmash);
    	itemZeldaArrow = new Item().setUnlocalizedName("itemZeldaArrow").setCreativeTab(tabSmash);
    	marthSword = new ItemMarthSword(materialMarth).setUnlocalizedName("marthSword").setCreativeTab(tabSmash);
    	pitBow = new ItemPitBow().setUnlocalizedName("pitBow").setCreativeTab(tabSmash);
    	
    	//Registers items.
    	ItemCore.RegisterItemVariable(eggSmashCube, MODID);
    	ItemCore.RegisterItemVariable(zeldaBow, MODID);
    	ItemCore.RegisterItemVariable(itemZeldaArrow, MODID);
    	ItemCore.RegisterItemVariable(marthSword, MODID);
    	ItemCore.RegisterItemVariable(pitBow, MODID);
    }
    
    //Registers enums such as tool materials.
    public void Enums() {
    	materialMarth = EnumHelper.addToolMaterial("MARTH", 3, 1, 12.0F, 60.0F, 0);
    }
    
    //Registers crafting recipes.
    public void Crafting() {
    	
    }
    
    //Registers models for items.
    @SideOnly(Side.CLIENT)
    public static void registerItem(Item item, int metadata, String itemName) {
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        mesher.register(item, metadata, new ModelResourceLocation(itemName, "inventory"));
    }
    
    //Prints credits to the console.
    public void Credit() {
    	System.out.println("Final Smash Mod - 33kingkiller & hayhay01em03");
    }
}
