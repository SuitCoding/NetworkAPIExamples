package example.globalshutdown.bukkit;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import tk.playerforcehd.network.api.NetworkAPI;
import tk.playerforcehd.network.connection.NetworkManager;

public class Main extends JavaPlugin {

	public static Main plugin;
	public static NetworkAPI api;
	public static NetworkManager manager;
	
	@Override
	public void onEnable(){
		plugin = this;
		api = NetworkAPI.getNetworkAPI();
		/*
		 * Here you must register a manager, this manager recieve the plugin message
		 * 
		 * The Channel MUST be the same with the BungeeCord version
		 */
		manager = api.addNetworkManager("Shutdown", "BungeeCord");
		
		/**
		 * This registers the Network Command
		 * You can use the same way in BungeeCord to recieve messages!
		 */
		api.addCommand(new CMD_shutdown("restart"));
		
		getLogger().log(Level.INFO, "Enabled...");
	}
	
}
