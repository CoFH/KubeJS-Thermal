package dev.latvian.mods.kubejs.thermal;

import cofh.lib.fluid.FluidIngredient;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.latvian.mods.kubejs.fluid.FluidStackJS;
import dev.latvian.mods.kubejs.item.ingredient.IngredientStackJS;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import net.minecraftforge.fluids.FluidStack;

/**
 * @author LatvianModder
 */
public abstract class ThermalRecipeJS extends RecipeJS {
	@Override
	public JsonElement serializeIngredientStack(IngredientStackJS in) {
		JsonObject o = new JsonObject();
		o.addProperty("count", in.getCount());
		o.add("value", in.ingredient.toJson());
		return o;
	}

	public ThermalRecipeJS energy(int e) {
		json.addProperty("energy", e);
		save();
		return this;
	}

	public ThermalRecipeJS energyMod(float e) {
		json.addProperty("energy_mod", e);
		save();
		return this;
	}

	public FluidIngredient fluidFrom(FluidStackJS fs) {
		return FluidIngredient.of(new FluidStack(fs.getFluid(), (int) fs.getAmount(), fs.getNbt()));
	}
}
