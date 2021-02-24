package fr.laybraid.layspawner.listeners;

import fr.laybraid.layspawner.events.SpawnerBreakEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onSpawnerBreak(org.bukkit.event.block.BlockBreakEvent e){
        Block blockBroken = e.getBlock();
        if (blockBroken.getType().equals(Material.SPAWNER) && e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Bukkit.getServer().getPluginManager().callEvent(new SpawnerBreakEvent(e.getPlayer(), blockBroken));
        }else if(blockBroken.getType().equals(Material.SPAWNER) && e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH )){
            e.getPlayer().sendMessage(ChatColor.GRAY + "Tu ne possède pas l'enchantement 'Silk Touch' donc tu n'as pas récupéré ce spawner.");
        }
    }

}

