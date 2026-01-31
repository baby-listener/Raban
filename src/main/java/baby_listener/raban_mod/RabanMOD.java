package baby_listener.raban_mod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RabanMOD implements ModInitializer {
	public static final String MOD_ID = "raban_mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//レジストリへの登録手順
	//レジストリ登録用のキーを作成（オブジェクトの種類と識別子を指定）
	public static RegistryKey<Item> SHIRATAMA_KEY;

	//キー情報を持つアイテムオブジェクトを作成
	public static Item SHIRATAMA;
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		SHIRATAMA_KEY = RegistryKey.of(
				RegistryKeys.ITEM,
				Identifier.of(MOD_ID, "shiratama")
		);
		SHIRATAMA = new Item(
				new Item.Settings().registryKey(SHIRATAMA_KEY)
		);
		//レジストリにアイテム、管理用キー、アイテム（メタデータ）を登録
		Registry.register(Registries.ITEM, SHIRATAMA_KEY, SHIRATAMA);
		//クリエイティブの戦闘タブに追加
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
			content.add(SHIRATAMA); 
		});
		LOGGER.info("Hello Fabric world!");
	}
}