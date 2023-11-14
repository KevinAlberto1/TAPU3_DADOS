import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread {
    Ventana p;
    Hilo2 jugador2;
    public int contador = 0;
    int dado = 0;
    int tiro = 0;
    public Hilo(Ventana p) {
      this.p = p;      
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
                    try {
                        jugador2.join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 if(tiro==3){                
                     break;}
                    p.jTextPane1.setText(p.jTextPane1.getText() + "Tirada " + tiro + " : " +"\n"+"ResultadoDado :"+ dado + "\n");
                 
                }
                
             }           
        }
    }
    public void setJugador2(Hilo2 jugador2) {
        this.jugador2 = jugador2;
    }  
    public void tirada() {
        dado = tirarDado();
    }
    public int tirarDado() {
        dado = (int) (Math.random() * 6) + 1;
        return dado;
    }
}
