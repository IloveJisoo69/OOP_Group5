/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ignacio
 */
public class Font {
    private String FontFamily;
    private int FontSize;

    public Font() {
    }

    public String getFontFamily() {
        return FontFamily;
    }

    public int getFontSize() {
        return FontSize;
    }

    public void setFontFamily(String FontFamily) {
        this.FontFamily = FontFamily;
    }

    public void setFontSize(int FontSize) {
        this.FontSize = FontSize;
    } 
}
