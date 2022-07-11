package com.gmail.filoghost.chestcommands.bridge;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.gmail.filoghost.chestcommands.util.Utils;
import com.ystoreplugins.ypoints.api.yPointsAPI;import com.ystoreplugins.ypoints.models.PlayerPoints;

// PlayerPoints minimum version: 2.0
public class PlayerPointsBridge {
	
	//private static yPointsAPI pointsAPI;
	
	public static boolean setupPlugin() {
		 Plugin pointsPlugin = Bukkit.getPluginManager().getPlugin("yPoints");
				 
		 if (pointsPlugin == null) {
			 return false;
	     }
		 return true;
	}
	
	public static boolean hasValidPlugin() {
		return yPointsAPI.ypointsapi != null;
	}
	
	public static double getPoints(Player player) {
		if (!hasValidPlugin()) throw new IllegalStateException("O plugin yPoints nao foi encontrado!");
		return yPointsAPI.ypointsapi.getPlayer(player).getPoints();
	}
	
	public static boolean hasPoints(Player player, double playerPointsPrice) {
		if (!hasValidPlugin()) throw new IllegalStateException("O plugin yPoints nao foi encontrado!");
		if (playerPointsPrice < 0) throw new IllegalArgumentException("Quantia de pontos invalida: " + playerPointsPrice);
		
		return yPointsAPI.ypointsapi.getPlayer(player).has(playerPointsPrice);
	}
	
	/**
	 * @return true if the operation was successful.
	 */
	public static boolean takePoints(Player player, double playerPointsPrice) {
		if (!hasValidPlugin()) throw new IllegalStateException("O plugin yPoints nao foi encontrado!");
		if (playerPointsPrice < 0) throw new IllegalArgumentException("Quantia de pontos invalida: " + playerPointsPrice);
		
//		boolean result = pointsAPI.getPlayer(player).setPoints(points);
//		
//		Utils.refreshMenu(player);
		

		boolean transacao = false;
		
		try { 
		yPointsAPI.ypointsapi.getPlayer(player).setPoints(getPoints(player) - playerPointsPrice);
		transacao = true;
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}

		Utils.refreshMenu(player);
		
		
		return transacao;
	}
	
	
	public static void givePoints(Player player, int points) {
		if (!hasValidPlugin()) throw new IllegalStateException("O plugin yPoints nao foi encontrado!");
		if (points < 0) throw new IllegalArgumentException("Quantia de pontos invalida: " + points);
		

		yPointsAPI.ypointsapi.getPlayer(player).setPoints(getPoints(player) + points);

		Utils.refreshMenu(player);
		
		
		return;
	}
	
}
