package fomerca;

import fomerca.view.SplashScreen;
import fomerca.view.VentanaInicio;
import java.awt.Window;

/**
 *
 * @author Adonis
 */
public class Fomerca {

    public static void main(String[] args) {
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.setVisible(true);
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setVisible(true);
        splashScreen.setVisible(false);
    }
}
