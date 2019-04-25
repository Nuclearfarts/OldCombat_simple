package com.nuclearfarts.simpleoldcombat;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

import static org.objectweb.asm.Opcodes.*;

import net.minecraft.launchwrapper.IClassTransformer;

public class SOCTransformer implements IClassTransformer {

	
	public SOCTransformer() {
		System.out.println("transformer initialized");
	}
	
	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass) {
		if(name.equals("avx")) {
			return transformEntityPlayer(basicClass);
		}
		return basicClass;
	}
	
	private byte[] transformEntityPlayer(byte[] basicClass) {
		System.out.println("EntityPlayer/avx");
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(basicClass);
		classReader.accept(classNode, 0);
		
		for(MethodNode m : classNode.methods) {
			System.out.println(m.name);
			if(m.name.equals("s") && m.desc.equals("(F)F")) {
				System.out.println("found method");
				m.instructions.clear();
				m.instructions.add(new InsnNode(FCONST_1));
				m.instructions.add(new InsnNode(FRETURN));
			}
		}
		
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		classNode.accept(writer);
		return writer.toByteArray();
	}

}
