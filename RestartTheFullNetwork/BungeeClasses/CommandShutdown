package example.globalshutdown.bungee;

import java.util.Collection;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import tk.playerforcehd.network.api.NetworkAPI;
import tk.playerforcehd.network.connection.NetworkManager;

public class CommandShutdown extends Command {

	public CommandShutdown(String name) {
		super(name);
	}

	/**
	 * By executing the command, the api send a message to all sub servers
	 */
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer){
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if(p.hasPermission("proxy.restart.all")){
				for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()){
					all.disconnect(new TextComponent("§4The Network is going down for reboot NOW!"));
				}
				Collection<ServerInfo> servers = ProxyServer.getInstance().getServers().values();
				for(ServerInfo currentServer : servers){
					NetworkAPI api = NetworkAPI.getNetworkAPI();
					NetworkManager manager = null;
					try {
						manager = api.addNetworkManager("Shutdown", "BungeeCord");
						manager.sendMessageToServer(currentServer, "restart", "Password123");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				ProxyServer.getInstance().stop();
			}
		} else {
			
		}
	}

}
