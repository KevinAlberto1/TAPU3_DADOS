import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo2 extends Thread {
    Ventana p;
    Hilo3 jugador3;
    public int contador = 0;
    int dado = 0;
    int tiro = 0;
    public void tirada() {
        dado = tirarDado();
    }
    public int tirarDado() {
        dado = (int) (Math.random() * 6) + 1;
        return dado;
    } 
    public Hilo2(Ventana p) {
        
        this.p = p;     
    }
    public void setJugador3(Hilo3 jugador3) {
        this.jugador3 = jugador3;
    }
    @Override
    public void run() { 
        while (true) {
            try {   
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(true){
                if (contador == 0) {
                  tiro++;
                 tirada();
                 if(tiro==3){
                      try {
                          jugador3.join();
                      } catch (InterruptedException ex) {
                          Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
                      }
                     break;}
                 
                   p.jTextPane2.setText(p.jTextPane2.getText() + "Tirada " + tiro + " : " +"\n"+"ResultadoDado :"+ dado + "\n");               
                }                
             }           
        }
    }
    
}
