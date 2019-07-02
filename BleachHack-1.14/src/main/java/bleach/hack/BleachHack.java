package bleach.hack;

import bleach.hack.command.CommandManager;
import bleach.hack.module.ModuleManager;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;

@Mod("bleachhack")
public class BleachHack {
	
    public BleachHack() {
        MinecraftForge.EVENT_BUS.register(this);
    }
    
	@SubscribeEvent
    public void onTick(WorldTickEvent event) {
    	try { ModuleManager.onUpdate();
    	}catch(Exception e){ /* World Not Loaded */ }
    }
    
    @SubscribeEvent
    public void onRender(RenderWorldLastEvent event) {
    	ModuleManager.onRender();
    }
    
    @SubscribeEvent
    public void onKeyPress(KeyInputEvent event) {
    	try { ModuleManager.onKeyPressed(event.getKey());
    	}catch(Exception e){ /* World Not Loaded */ }
    }
    
    @SubscribeEvent
    public void onChatMsg(ClientChatEvent event) {
    	if(event.getMessage().startsWith(".")) {
    		CommandManager cmd = new CommandManager();
    		cmd.callCommand(event.getMessage().substring(1));
    		event.setCanceled(true);
    	}
    }
}