package fr.laybraid.layspawner.listeners;

import fr.laybraid.layspawner.events.SpawnerBreakEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import java.util.Random;

public class LayListener implements Listener {

    @EventHandler
    public void spawnerBreak(SpawnerBreakEvent e){

        CreatureSpawner cs = (CreatureSpawner) e.getSpawner().getState();

        ItemStack spawner_to_give = new ItemStack(Material.SPAWNER);
        BlockStateMeta meta = (BlockStateMeta) spawner_to_give.getItemMeta();
        CreatureSpawner css = (CreatureSpawner) meta.getBlockState();

        css.setSpawnedType(cs.getSpawnedType());
        meta.setBlockState(css);
        spawner_to_give.setItemMeta(meta);

        int random = new Random().nextInt(2);
        if(random == 1){
            e.getBreaker().sendMessage(ChatColor.GRAY + "Vous avez récupéré ce spawner, bravo !");
            e.getBreaker().getInventory().addItem(spawner_to_give);
        }
    }

}
