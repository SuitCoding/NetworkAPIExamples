package Test;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import tk.playerforcehd.network.api.NetworkAPI;
import tk.playerforcehd.network.connection.NetworkManager;

public class Example extends JavaPlugin implements Listener {

    public static NetworkAPI api;
    public static Example example;
    public static NetworkManager manager;
   
    @Override
    public void onEnable(){
        example = this;
        api = NetworkAPI.getNetworkAPI();
        manager = api.addNetworkManager("DeathManager", "BungeeCord");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);
        System.out.println("Enabled the example plugin!");
    }
   
    /**
    *If a player died, the death message get broadcastet around the network to everybody who has the permission on every server!
    */
    @EventHandler(priority=EventPriority.NORMAL)
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        String deathMessage = e.getDeathMessage();
        manager.executeBroadcast(p, "test.permission", deathMessage);
    }
   
}
