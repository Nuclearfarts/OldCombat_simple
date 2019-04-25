package com.nuclearfarts.simpleoldcombat;

import java.util.Arrays;

import net.minecraft.launchwrapper.Launch;

public class FixYourLauncherMojang {

	/**
	 * So, some people (myself included) still use launcher 1.6.89-j from forever
	 * ago. There's a bug in this launcher, where it assumes GSON will read a field
	 * that doesn't exist as null. But, when said field is an array, it doesn't. It
	 * reads an empty array. This is compounded by another bug in the launcher,
	 * where if the array of conditions on an argument is empty, it will not use the
	 * argument. There are workarounds for this, but for some reason the launcher
	 * re-saves the JSON when it downloads libraries. When it does this, it messes
	 * it up again. So here we are.
	 */
	public static void main(String[] args) {
		String[] newArgs = Arrays.copyOf(args, args.length + 2);
		newArgs[newArgs.length - 2] = "--tweakClass";
		newArgs[newArgs.length - 1] = "com.nuclearfarts.simpleoldcombat.SimpleOldCombatTweaker";
		Launch.main(newArgs);
	}
}
