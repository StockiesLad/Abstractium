package net.feltmc.abstractium.mixin;

import me.fallenbreath.conditionalmixin.api.annotation.Condition;
import me.fallenbreath.conditionalmixin.api.annotation.Restriction;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Restriction(require = @Condition(value = "minecraft", versionPredicates = {
        "1.18.2",
        "1.19",
        "1.19.1",
        "1.19.2"
}))
@Mixin(RegistryKey.class)
public interface RegistryKeyAccessor {
    @Accessor(value = "registry") Identifier getRegistry();
}
