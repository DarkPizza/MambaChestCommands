package com.gmail.filoghost.chestcommands.bridge.bungee;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import com.gmail.filoghost.chestcommands.ChestCommands;

public class BungeeCordUtils {

	public static boolean connect(Player player, String server) {
		
		try {
			
			if (server.length() == 0) {
				player.sendMessage("�cO servidor de destino era \"\" (nome vazio), portanto nao foi possivel conectar-se a ele.");
				return false;
			}
		
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
			DataOutputStream out = new DataOutputStream(byteArray);
		 
			out.writeUTF("Connect");
			out.writeUTF(server); // Target Server.
		    
			player.sendPluginMessage(ChestCommands.getInstance(), "BungeeCord", byteArray.toByteArray());
			
		} catch (Exception ex) {
			player.sendMessage(ChatColor.RED + "Erro desconhecido! Por favor, informe algum staff do servidor sobre isso.");
			ex.printStackTrace();
			ChestCommands.getInstance().getLogger().warning("Nao foi possivel conectar o player \"" + player.getName() + "\" ao servidor \"" + server + "\".");
			return false;
		}
		
		return true;
	}
	
}
