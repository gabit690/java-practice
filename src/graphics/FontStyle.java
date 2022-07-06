package graphics;

import java.awt.Color;
import java.awt.Font;

public class FontStyle {

	private String _name;
	
	private int _style;
	
	private int _size;
	
	private Color _color;
	
	public FontStyle(String name, int style, int size, Color color) {
		
		this._name = name;
		
		this._style = style;
		
		this._size = size;
		
		this._color = color;
	}
	
	public void setName(String name) {
		
		this._name = name;
	}
	
	public void setStyle(int style) {
		
		this._style = style;
	}
	
	public void setSize(int size) {
		
		this._size = size;
	}
	
	public void setColor(Color color) {
		
		this._color = color;
	}
	
	public String getName() {
		
		return this._name;
	}
	
	public int getStyle() {
		
		return this._style;
	}
	
	public int getSize() {
		
		return this._size;
	}
	
	public Color getColor() {
		
		return this._color;
	}
}
