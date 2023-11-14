import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo3 extends Thread {
    Ventana p;
    public int contador = 0;
    int dado = 0;
    int tiro = 0;
    public Hilo3(Ventana p) {
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
                 if(tiro==3)
                     break;                
                    p.jTextPane3.setText(p.jTextPane3.getText() + "Tirada " + tiro + " : " +"\n"+"ResultadoDado :"+ dado + "\n");                
                }               
             }           
        }
    }
    public void tirada() {
        dado = tirarDado();
    }
    public int tirarDado() {   
        dado = (int) (Math.random() * 6) + 1;
        return dado;
    }
}
