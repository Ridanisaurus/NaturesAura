package de.ellpeck.naturesaura.api.aura.type;

import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IWorld;
import net.minecraft.world.dimension.DimensionType;

import java.util.HashSet;
import java.util.Set;

public class BasicAuraType implements IAuraType {

    private final ResourceLocation name;
    private final int color;
    private final int priority;
    private final Set<ResourceLocation> dimensions = new HashSet<>();

    public BasicAuraType(ResourceLocation name, DimensionType dimension, int color, int priority) {
        this.name = name;
        this.color = color;
        this.priority = priority;
        if (dimension != null)
            this.dimensions.add(dimension.getRegistryName());
    }

    public BasicAuraType register() {
        NaturesAuraAPI.AURA_TYPES.put(this.name, this);
        return this;
    }

    @Override
    public ResourceLocation getName() {
        return this.name;
    }

    @Override
    public boolean isPresentInWorld(IWorld world) {
        return this.dimensions.isEmpty() || this.dimensions.contains(world.getDimension().getType().getRegistryName());
    }

    @Override
    public int getColor() {
        return this.color;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    public void addDimensionType(ResourceLocation typeName) {
        this.dimensions.add(typeName);
    }
}
