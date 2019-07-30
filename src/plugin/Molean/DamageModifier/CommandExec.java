package plugin.Molean.DamageModifier;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.plugin.Plugin;

public class CommandExec implements CommandExecutor {

	
	
	private Plugin plugin;
	//	private String[] DamageList = BLOCK_EXPLOSION,CONTACT,CRAMMING,CUSTOM,DRAGON_BREATH,DROWNING,DRYOUT,ENTITY_ATTACK,ENTITY_EXPLOSION,ENTITY_SWEEP_ATTACK,FALL,FALLING_BLOCK,FIRE,FIRE_TICK,FLY_INTO_WALL,HOT_FLOOR,LAVA,LIGHTNING,MAGIC,MELTING,POISON,PROJECTILE,STARVATION,SUFFOCATION,SUICIDE,THORNS,VOID,WITHER;
	private DamageCause[] DamageType = DamageCause.values();
			
	CommandExec(Plugin plugin) {
		super();
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		if(args.length == 0) {
			showHelp(s);
			return true;
			
			
		}else if(args.length == 1) {

			if(args[0].equals("list")) {
				showDamageInfo(s);
				return true;	
				}
			else if(args[0].equalsIgnoreCase("reload")) {
				doReload();
				s.sendMessage(ChatColor.GREEN + "成功重载配置!");
				return true;
			}
			else {
				forHelp(s);
				return true;
			}
			
			
		}else if(args.length == 2) {
			if(Arrays.asList(DamageType).contains(args[0])) {
				if(args[1].equalsIgnoreCase("on")) {
					on(args[0]);
					return true;
				}else if(args[1].equalsIgnoreCase("off")){
					off(args[0]);
					return true;
				}else {
					s.sendMessage("§3用法/dm <damageType> §c[on|off]");
					return true;
				}
			}else {
				s.sendMessage(ChatColor.RED + args[1] + "不是一种伤害类型!");
				return true;
			}
		}else if(args.length == 3) {
			 if(Arrays.asList(DamageType).contains(args[0])){
					
					return true;	
					}
		return true;
		}else if(args.length == 4) {
			if(args[0].equalsIgnoreCase("set")) {				
				if(Arrays.asList(DamageType).contains(args[1])) {
					if(args[2].equalsIgnoreCase("extra")) {
						setExtra(args[1],args[3]);
						s.sendMessage(ChatColor.GREEN + args[1]+ " 类型伤害的  Extra 值成功设置为"+ args[3]);
						return true;
					}else if(args[2].equalsIgnoreCase("multiply")) {
						setMultiply(args[1],args[3]);
						s.sendMessage(ChatColor.GREEN + args[1]+ " 类型伤害的  Multiply 值成功设置为"+ args[3]);
						return true;
					}else if(args[2].equalsIgnoreCase("percentage")) {
						setPercentage(args[1],args[3]);
						s.sendMessage(ChatColor.GREEN + args[1]+ " 类型伤害的  Percentage 值成功设置为"+ args[3]);
						return true;
					}else {
						s.sendMessage("§3用法:/dm set <damageType> §c[extra|multiply|percentage] §3<index>");
						return true;
					}
					
				}else {
					s.sendMessage(ChatColor.RED + args[1] + "不是一种伤害类型!");
				}
			}
		return true;
		}else {
			showHelp(s);
			return true;
		}
		
	
	}


	private void doReload() {
		plugin.saveConfig();
		plugin.reloadConfig();
	}

	private void off(String damageType) {
		// TODO Auto-generated method stub
		
	}

	private void on(String damageType) {
		// TODO Auto-generated method stub
		
	}

	private void setPercentage(String damageType, String string) {
		
	}

	private void setMultiply(String damageType, String string) {
		
	}

	private void setExtra(String damageType, String string) {
		
		
	}

	private void showDamageInfo(CommandSender s) {
		s.sendMessage("§6-----DamageInfoList-----");
		s.sendMessage("§bNAME  |  §bE  |  §bM  |  §bP  |    §bSTATUS");
		s.sendMessage("§3FALL   §71.00   §7X2    §70.5     §aENABLE");
		
	}

	private void showHelp(CommandSender s) {
		  	s.sendMessage("§3[DamageModifier] "+"v"+ this.plugin.getDescription().getVersion() + " §cBy Molean");
		  	s.sendMessage("§3/dm reload §7- §7重新加载配置文件");
		  	s.sendMessage("§3/dm <damageType> [on|off] §7- §7开启或关闭某种伤害的更改");
		    s.sendMessage("§3/dm info §7- §7显示所有伤害详细配置");
		    s.sendMessage("§3/dm set <damageType> [extra|multiply|percentage] <index> §7- §7设置某种伤害值");
	}
	private void forHelp(CommandSender s) {
		s.sendMessage("§6未知命令,输入 §3/dm §6查询帮助");
	}
}
