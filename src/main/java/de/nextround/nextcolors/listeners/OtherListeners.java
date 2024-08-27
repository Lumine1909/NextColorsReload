package de.nextround.nextcolors.listeners;

/*
 *
 *
 *    █▀▀▄ █▀▀ █ █ ▀▀█▀▀ ░█▀▀█ █▀▀█ █   █▀▀█ █▀▀█ █▀▀
 *    █  █ █▀▀ ▄▀▄   █   ░█    █  █ █   █  █ █▄▄▀ ▀▀█
 *    ▀  ▀ ▀▀▀ ▀ ▀   ▀   ░█▄▄█ ▀▀▀▀ ▀▀▀ ▀▀▀▀ ▀ ▀▀ ▀▀▀
 *
 *    Project: nextColors
 *    Author: Nicole Scheitler (nextRound)
 *    Copyright - GNU GPLv3 (C) Nicole Scheitler
 *
 *
 */

import de.nextround.nextcolors.NextColors;
import de.nextround.nextcolors.utils.FileManager;
import de.nextround.nextcolors.utils.NCPlayer;
import de.nextround.nextcolors.utils.inventories.MainInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import java.util.Objects;

public class OtherListeners implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        FileManager.createDefaultPlayerConfigFile(player.getUniqueId());
        if (Objects.requireNonNull(NCPlayer.getNCPlayer(player.getUniqueId(), true)).getConfigVersion() != NextColors.configVersion) {
            FileManager.resetPlayerConfigFile(player.getUniqueId());
        }
    }

    @EventHandler
    public void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("nextcolors.interact.use")) {
            if (Objects.requireNonNull(event.getOffHandItem()).getType() == Material.CLAY_BALL) {
                event.setCancelled(true);
                new MainInventory(player).openInventory();
            }
        }
    }
}
