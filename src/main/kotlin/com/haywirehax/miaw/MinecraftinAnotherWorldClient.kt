package com.haywirehax.miaw

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.block.Block
import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import net.minecraft.entity.Entity
import net.minecraft.text.Text
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import org.lwjgl.glfw.GLFW


class MinecraftinAnotherWorldClient: ClientModInitializer {
    override fun onInitializeClient() {
        val interactBinding: KeyBinding = KeyBindingHelper.registerKeyBinding(KeyBinding("key.miaw.interact", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F, "key.category.miaw"))

        ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick { client: MinecraftClient ->
            while (interactBinding.wasPressed()) {
                val hit = client.crosshairTarget

                when (hit!!.type) {
                    HitResult.Type.MISS -> {}
                    HitResult.Type.BLOCK -> {
                        val blockHit = hit as BlockHitResult
                        val blockPos = blockHit.blockPos
                        val blockState = client.world!!.getBlockState(blockPos)
                        val block: Block = blockState.block
                        client.player!!.sendMessage(Text.literal("Hit block: " + block.name), false)
                    }

                    HitResult.Type.ENTITY -> {
                        val entityHit = hit as EntityHitResult
                        val entity: Entity = entityHit.entity
                        client.player!!.sendMessage(Text.literal("This is a " + entity.type.toString().split(".").lastOrNull()), false)
                    }
                }
            }
        })


    }
}