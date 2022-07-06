package graphics;

import java.awt.Color;

public class ShapeColor {

	private Color _inner;
	
	private Color _outer;
	
	public ShapeColor(Color inner, Color outer) {
		
		this._inner = inner;
		
		this._outer = outer;
	}
	
	public void setInner(Color inner) {
		
		this._inner = inner;;
	}
	
	public void setOuter(Color outer) {
		
		this._outer = outer;
	}
	
	public Color getInner() {
		
		return this._inner;
	}
	
	public Color getOuter() {
		
		return this._outer;
	}
}
