package example.globalshutdown.bukkit;

import java.io.DataInputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import tk.playerforcehd.network.api.NetworkCommand;

public class CMD_shutdown extends NetworkCommand {

	public CMD_shutdown(String subchannel) {
		super(subchannel);
	}

	@Override
	public void onRun(DataInputStream arg0) {
		String password = "";
		try {
			//Reading the stream...
			password = arg0.readUTF();
		} catch (IOException e) {
		}
		if(password.equals("Password123")){
			new BukkitRunnable() {
				
				@Override
				public void run() {
					//Because the password is right, the server stops!
					Bukkit.shutdown();
				}
			}.runTaskLater(Main.plugin, 20);
		}
	}

}
