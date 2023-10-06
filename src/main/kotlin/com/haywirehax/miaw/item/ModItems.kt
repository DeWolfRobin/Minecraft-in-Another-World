package com.haywirehax.miaw.item

import com.haywirehax.miaw.MinecraftinAnotherWorld
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

class ModItems {

    companion object {
        val RUBY: Item = registerItem("ruby", Item(FabricItemSettings()))

        private fun addItemsToIngredientItemGroup(entries: FabricItemGroupEntries) {
            entries.add(RUBY)
        }

        private fun registerItem(name: String, item: Item): Item {
            return Registry.register(Registries.ITEM, Identifier(MinecraftinAnotherWorld.MOD_ID, name), item)
        }
        fun registerModItems() {
            MinecraftinAnotherWorld.LOGGER.info("Registering Mod Items for " + MinecraftinAnotherWorld.MOD_ID)

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup)
        }
    }
}