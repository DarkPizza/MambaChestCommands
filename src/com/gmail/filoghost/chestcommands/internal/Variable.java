package com.gmail.filoghost.chestcommands.internal;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.filoghost.chestcommands.bridge.EconomyBridge;
import com.gmail.filoghost.chestcommands.bridge.PlayerPointsBridge;

public enum Variable {
	
	PLAYER("{player}") {
		public String getReplacement(Player executor) {
			return executor.getName();
		}
	},
	
	XP("{xp_level}") {
		public String getReplacement(Player executor) {
			return String.valueOf(executor.getExpToLevel());
		}
	},
	
	ONLINE("{online}") {
		public String getReplacement(Player executor) {
			return String.valueOf(CachedGetters.getOnlinePlayers());
		}
	},
	
	MAX_PLAYERS("{max_players}") {
		public String getReplacement(Player executor) {
			return String.valueOf(Bukkit.getMaxPlayers());
		}
	},
	
	MONEY("{money}") {
		public String getReplacement(Player executor) {
			if (EconomyBridge.hasValidEconomy()) {
				return EconomyBridge.formatMoney(EconomyBridge.getMoney(executor));
			} else {
				return "[NENHUM PLUGIN DE ECONOMIA ENCONTRADO]";
			}
		}
	},
	
	POINTS("{points}") {
		public String getReplacement(Player executor) {
			if (PlayerPointsBridge.hasValidPlugin()) {
				return String.valueOf(PlayerPointsBridge.getPoints(executor));
			} else {
				return "[yPoints n�o est� instalado.]";
			}
		}
	},
	
	WORLD("{world}") {
		public String getReplacement(Player executor) {
			return executor.getWorld().getName();
		}
	};
	
	private String text;
	
	private Variable(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public abstract String getReplacement(Player executor);
}
