package com.github.doodlez.bukkit.globalquest;

import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.event.Event.Type;

/**
 * User: YBogomolov
 * Date: 11.08.11
 * Time: 14:10
 */
public class WrenchPlugin extends JavaPlugin {
    private WrenchPlayerListener playerListener = new WrenchPlayerListener();

    public static ArrayList<Integer> industrialMachines = new ArrayList<Integer>();
    public static int wrenchMaterialId;

    @Override
    public void onDisable() {
        System.out.print("[WrenchPlugin] Plugin disabled.");
    }

    @Override
    public void onEnable() {
        readConfiguration();
        System.out.print("[WrenchPlugin] Plugin enabled.");

        PluginManager manager = getServer().getPluginManager();

        manager.registerEvent(Type.PLAYER_INTERACT, playerListener, Priority.Normal, this);
    }

    private void readConfiguration() {
        wrenchMaterialId = getConfiguration().getInt("WrenchPlugin.WrenchMaterialId", 30159);

        List<Object> icMachines = getConfiguration().getList("WrenchPlugin.ICMachines");

        for (Object rawMachineId : icMachines) {
            WrenchPlugin.industrialMachines.add(Integer.parseInt(rawMachineId.toString()));
        }
    }
}
