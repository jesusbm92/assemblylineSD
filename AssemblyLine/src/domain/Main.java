package domain;

import java.awt.Color;

public class Main {

	public static void main(String[] args) {

		Rules rules = new Rules();
		Warehouse wh = new Warehouse();
		
		Circle circle = new Circle();
		Rectangle rect = new Rectangle();
		rect.setColor(Color.RED);

		SimpleComponent wheel = new SimpleComponent(wh);
		SimpleComponent engine = new SimpleComponent(wh);
		
		wheel.setFigure(circle);
		engine.setFigure(rect);

		rules.addRule(wheel);
		rules.addRule(engine);
		rules.addRule(wheel);
		
		AssemblyLine assemblyLine = new AssemblyLine(rules);
		
		Panel p = new Panel(assemblyLine);
		p.repaint();

	}

}
