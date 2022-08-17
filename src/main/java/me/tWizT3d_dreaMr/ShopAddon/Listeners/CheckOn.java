package me.tWizT3d_dreaMr.ShopAddon.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.snowgears.shop.event.PlayerInitializeShopEvent;
import com.snowgears.shop.shop.AbstractShop;

import me.tWizT3d_dreaMr.ShopAddon.CreationCheck;
import me.tWizT3d_dreaMr.ShopAddon.Format;
import me.tWizT3d_dreaMr.ShopAddon.main;


public class CheckOn implements Listener {

	 @EventHandler
	    public void onShopCreate(PlayerInitializeShopEvent  event) {
	    	CreationCheck ItemList= main.getCreationCheck();
	    	AbstractShop shop=event.getShop();
	    	String type=ItemList.testfor(event.getPlayer().getInventory().getItemInMainHand(), shop.getPrice(), shop.getAmount(),shop.getType());
	    	if(!type.equals("none")) {
	    		event.setCancelled(true);
	    		shop.delete();
	    		Player player=event.getPlayer();
	    		String message=Format.format(main.getCon().getString("Interaction."+type));
	    		
	    		player.sendMessage(message);
	    	}
	 }

   

}
