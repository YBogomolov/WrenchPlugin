package com.github.doodlez.bukkit.globalquest;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;

/**
 * User: YBogomolov
 * Date: 11.08.11
 * Time: 14:17
 */
public class WrenchPlayerListener extends PlayerListener {
    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().getTypeId() == WrenchPlugin.wrenchMaterialId) {
                Block targetBlock = player.getTargetBlock(null, 10);
                if (WrenchPlugin.industrialMachines.contains(targetBlock.getTypeId())) {
                    targetBlock.setType(Material.AIR);
                    ItemStack machine = new ItemStack(targetBlock.getType(), 1);
                    player.getWorld().dropItemNaturally(targetBlock.getLocation(), machine);
                }
            }
        }
    }
}
