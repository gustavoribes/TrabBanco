/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
/*
 Implementação direta do codigo retirado de http://www.guj.com.br/18348-tocar-arquivo-mp3-em-java
 Autor : Bruno
 */

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JOptionPane;

public class Play implements Runnable {

    private boolean waiting = false;
    private SourceDataLine line;
    private AudioInputStream din;
    private AudioFormat decodeFormat;

    public Play(Music track) {
        this.line = track.getLine();
        this.din = track.getDin();
        this.decodeFormat = track.getDecodeFormat();

    }

    //metodo para pausar a thread.. a propria thread deve se parar, e não uma thread externa  
    public synchronized void aguardar() {
        waiting = true;
    }

    //metodo para reiniciar uma thread  
    public void continuar() {
        waiting = false;
        synchronized (this) {
            this.notify();
        }
    }

    //aqui executa a musica  
    public void run() {
        try {
            if (line != null) {
                line.open(decodeFormat);
                byte[] data = new byte[4096];
                // Start  
                line.start();
                int nBytesRead;
                //toca enquanto a musica não acaba  
                while ((nBytesRead = din.read(data, 0, data.length)) != -1) {
                    //se for solicitado para para  a propria thread para  
                    while (waiting) {
                        synchronized (this) {
                            wait(); //Note que essa thread mesmo chama o wait  
                        }
                    }
                    line.write(data, 0, nBytesRead);
                }
                // Stop  
                line.drain();
                line.stop();
                line.close();
                din.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
        }
    }
}
