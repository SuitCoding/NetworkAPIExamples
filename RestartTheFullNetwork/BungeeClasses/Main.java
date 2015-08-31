package example.globalshutdown.bungee;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class Main extends Plugin {

	@SuppressWarnings("static-access")
	@Override
	public void onEnable(){
		PluginManager pm = getProxy().getInstance().getPluginManager();
		pm.registerCommand(this, new CommandShutdown("grestart"));
	}
	
}
