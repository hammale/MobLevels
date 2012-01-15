package me.hammale.MobLevels;

import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MobLevels extends JavaPlugin {
	
	public Logger log = Logger.getLogger("Minecraft");
	
	protected void logMessage (String msg) {
		log.info("[MoreMobs]" + msg);
	}
	public FileConfiguration config;
	
	  private final MobEntityListener entityListener = new MobEntityListener(this);
	  
	  public void onEnable() {	
		  //loadConfiguration();
	        PluginManager pm = getServer().getPluginManager();
	        pm.registerEvent(Event.Type.ENTITY_TARGET, this.entityListener, Event.Priority.Normal, this);
	        log.info("[MobLevels] Enabled!");
	  }
	  
	public void onDisable() {
	    log.info("[MobLevels] Disabled!");
	}
}