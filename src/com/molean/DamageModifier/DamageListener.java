package com.molean.DamageModifier;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {
	
	FileConfiguration config = null;
	
	public DamageListener(FileConfiguration config) {
		this.config = config;
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof LivingEntity)) return;
		LivingEntity entity = (LivingEntity)e.getEntity();
		
		String Cause = e.getCause().toString();
		
		if(!config.getBoolean(Cause + ".enable")) return;
		
		double damage = config.getDouble(Cause + ".extra") +
						entity.getMaxHealth() * config.getDouble(Cause + ".percentage") +
						e.getDamage() * config.getDouble(Cause + ".multiply");
		e.setDamage(damage);
	}
}
