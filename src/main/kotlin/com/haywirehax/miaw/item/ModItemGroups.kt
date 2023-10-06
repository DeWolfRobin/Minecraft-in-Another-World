package com.haywirehax.miaw.item

import com.haywirehax.miaw.MinecraftinAnotherWorld
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

class ModItemGroups {

    companion object {
        val RUBY_GROUP: ItemGroup = Registry.register(Registries.ITEM_GROUP,
                Identifier(MinecraftinAnotherWorld.MOD_ID, "ruby"),
                FabricItemGroup.builder().displayName(Text.translatable("itemgroup.miaw"))
                        .icon{ItemStack(ModItems.RUBY)}
                        .entries{displayContext, entries ->
                            entries.add(ModItems.RUBY)

                            entries.add(Items.BOOK)
                        }.build())
        private fun registerItem(name: String, item: Item): Item {
            return Registry.register(Registries.ITEM, Identifier(MinecraftinAnotherWorld.MOD_ID, name), item)
        }
        fun registerModItemGroups() {
            MinecraftinAnotherWorld.LOGGER.info("Registering Item Groups for " + MinecraftinAnotherWorld.MOD_ID)

        }
    }
}