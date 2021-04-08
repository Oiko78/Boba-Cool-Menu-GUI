import java.awt.Color;

public class ColorPicker{
  public final static Color yellow() {
    return new Color(0xF9DB81);
  }
  public final static Color yellowDarker(int type) {
    if(type == 0) return new Color(0xFDD251);
    if(type == 1) return new Color(0xFDC622);
    return new Color(0xBD8E02);
  }
  public final static Color blueDark() {
    return new Color(0x243875);
  }
  public final static Color blueLight() {
    return new Color(0xB5E4E6);
  }
  public final static Color brown() {
    return new Color(0x8C645C);
  }
  public final static Color red() {
    return new Color(0xE93079);
  }
}
