package bleach.hack.event.events;

import java.util.List;

import bleach.hack.event.Event;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.OrderedText;

public class EventDrawTooltip extends Event {

	public Screen screen;
	public MatrixStack matrix;
	public List<? extends OrderedText> text;
	public int x;
	public int y;
	public int mouseX;
	public int mouseY;

	public EventDrawTooltip(MatrixStack matrix, List<? extends OrderedText> text, int x, int y, int mouseX, int mouseY) {
		this.matrix = matrix;
		screen = MinecraftClient.getInstance().currentScreen;
		this.text = text;
		this.x = x;
		this.y = y;
		this.mouseX = mouseX;
		this.mouseY = mouseY;
	}

}
