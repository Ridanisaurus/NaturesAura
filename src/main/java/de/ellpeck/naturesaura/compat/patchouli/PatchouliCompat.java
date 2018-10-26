package de.ellpeck.naturesaura.compat.patchouli;

import de.ellpeck.naturesaura.NaturesAura;
import net.minecraft.util.ResourceLocation;
import vazkii.patchouli.client.book.BookPage;
import vazkii.patchouli.client.book.ClientBookRegistry;

public final class PatchouliCompat {

    public static final ResourceLocation GUI_ELEMENTS = new ResourceLocation(NaturesAura.MOD_ID, "textures/gui/patchouli/elements.png");

    public static void initClient() {
        addPatchouliPage("altar", PageAltar.class);
        addPatchouliPage("tree_ritual", PageTreeRitual.class);
    }

    private static void addPatchouliPage(String name, Class<? extends BookPage> page) {
        ClientBookRegistry.INSTANCE.pageTypes.put(NaturesAura.MOD_ID + ":" + name, page);
    }
}