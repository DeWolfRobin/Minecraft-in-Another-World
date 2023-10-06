package com.haywirehax.miaw

import com.haywirehax.miaw.item.ModItemGroups
import com.haywirehax.miaw.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object MinecraftinAnotherWorld : ModInitializer {
	val MOD_ID = "miaw"
	val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		ModItemGroups.registerModItemGroups()

		ModItems.registerModItems()
	}
}