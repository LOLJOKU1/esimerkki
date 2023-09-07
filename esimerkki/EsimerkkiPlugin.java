package net.runelite.client.plugins.esimerkki;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Esimerkki",
	description = "",
	tags = {"esimerkki"},
	hidden = false,
	enabledByDefault = false
)
public class EsimerkkiPlugin extends Plugin
{
	protected static final String CONFIG_GROUP = "esimerkki";

	@Inject
	private Client client;

	@Inject
	private EsimerkkiConfig config;

	@Override
	protected void startUp() throws Exception
	{
		client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Esimerkki aloitettu.", null);
	}

	@Override
	protected void shutDown() throws Exception
	{
		client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Esimerkki lopetettu.", null);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
	}

	@Provides
	EsimerkkiConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(EsimerkkiConfig.class);
	}
}
