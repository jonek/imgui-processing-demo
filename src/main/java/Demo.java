import org.ice1000.jimgui.JImGui;
import org.ice1000.jimgui.NativeInt;
import org.ice1000.jimgui.cpp.DeallocatableObjectManager;
import org.ice1000.jimgui.util.JniLoader;

import processing.core.PApplet;

public class Demo extends PApplet {

	static NativeInt boxHeight;
	static NativeInt boxWidth;
	
	public static void main(String... args) {
		PApplet.main(Demo.class.getName());

		JniLoader.load();
		
		try (
				JImGui imGui = new JImGui(400, 400, "jimgui");
				DeallocatableObjectManager manager = initValues();
			) {
			imGui.initBeforeMainLoop();
			while (!imGui.windowShouldClose()) {
				imGui.initNewFrame();
				imGui.sliderInt("height", boxHeight, 30, 60, "%d");
				imGui.sliderInt("width", boxWidth, 50, 100, "%d");
				imGui.render();
			}
		}
	}

	private static DeallocatableObjectManager initValues() {
		boxHeight = new NativeInt();
		boxHeight.modifyValue(40);
		boxWidth = new NativeInt();
		boxWidth.modifyValue(50);
		DeallocatableObjectManager manager = new DeallocatableObjectManager(15);
		manager.add(boxHeight);
		manager.add(boxWidth);
		
		return manager;
	}

	public void settings() {
		size(300, 300);
	}

	public void setup() {
		rectMode(CENTER);
		surface.setTitle("Processing");
		Object nativeWindow = surface.getNative();
		println(nativeWindow.getClass().getName());
	}

	public void draw() {
		fill(200, 200, 200);
		rect(width / 2, height / 2, width, height);
		fill(120, 50, 240);
		if (boxWidth != null && boxHeight != null) {
			int w = boxWidth.intValue();
			int h = boxHeight.intValue();
			rect(width / 2, height / 2, w * 2, h * 2);
		}
	}

}