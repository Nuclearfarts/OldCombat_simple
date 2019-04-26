package com.nuclearfarts.simpleoldcombat;

import java.util.Arrays;

import net.minecraft.launchwrapper.Launch;

public class ServerMain {

	
	
	public static void main(String[] args) {
		Statics.isServer = true;
		String[] newArgs = Arrays.copyOf(args, args.length + 2);
		newArgs[newArgs.length - 2] = "--tweakClass";
		newArgs[newArgs.length - 1] = "com.nuclearfarts.simpleoldcombat.SimpleOldCombatTweaker";
		Launch.main(newArgs);
	}

}
