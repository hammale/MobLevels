package me.hammale.MobLevels;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.AppearanceManager;

public class MobEntityListener extends EntityListener {

    public final MobLevels plugin;
	
	public MobEntityListener(MobLevels plugin)
	{
		this.plugin = plugin;
	}
	
	public void onEntityTarget(EntityTargetEvent e)
	{
		LivingEntity le = (LivingEntity) e.getEntity();
		if(!(le instanceof Player)){
			if(e.getReason() != TargetReason.FORGOT_TARGET || e.getReason() != TargetReason.TARGET_DIED){
				if(e.getTarget() instanceof Player){
					Player p = (Player) e.getTarget();
					if(p.getLocation().distance(e.getEntity().getLocation()) <= 20){
						setTitle(le);
					}
				}
			}else{
				hideTitle(le);
			}
		}
	}
	
	  public void setTitle(LivingEntity e) {
	        AppearanceManager sm = SpoutManager.getAppearanceManager();	       
	        sm.setGlobalTitle(e, "Level" + " §410");
	  }	
	  
	  public void hideTitle(LivingEntity e) {
	        AppearanceManager sm = SpoutManager.getAppearanceManager();	       
	        sm.hideGlobalTitle(e);
	  }		  
}