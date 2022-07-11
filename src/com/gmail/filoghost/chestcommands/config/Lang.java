package com.gmail.filoghost.chestcommands.config;

import com.gmail.filoghost.chestcommands.config.yaml.PluginConfig;
import com.gmail.filoghost.chestcommands.config.yaml.SpecialConfig;

public class Lang extends SpecialConfig {
	
	public String no_open_permission = "&cVoc� n�o tem permiss�o (&e{permission}&c) para utilizar este menu.";
	public String default_no_icon_permission = "&cVoc� n�o tem permiss�o para usar este bot�o.";
	public String no_required_item = "&cVoc� precisa de &e{amount}x {material}&c para poder fazer isso.";
	public String no_money = "&cVoc� precisa de {money}$ para poder fazer isso.";
	public String no_points = "&cVoc� precisa de {points} pontos para poder fazer isso.";
	public String no_exp = "&cVoc� precisa de {levels} n�veis de XP para poder fazer isso.";
	public String menu_not_found = "&cMenu n�o encontrado! Por favor informe este erro a um Staff.";
	public String open_menu = "&aAbrindo menu \"{menu}\".";
	public String open_menu_others = "&aAbrindo menu \"{menu}\" para o player {player}.";
	public String any = "0"; // Used in no_required_item when data value is not restrictive.

	public Lang(PluginConfig config) {
		super(config);
	}
}
