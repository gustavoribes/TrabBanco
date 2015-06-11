/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.MusicasDao;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavoribes
 */
public class PlayerController {

    static MusicasDao playerdao = new MusicasDao();
    static int id;
    static Thread newThrd = null;

    public static void play(int id) throws SQLException, ClassNotFoundException {
        PlayerController.id = id;
        // ResultSet diretorio = playerdao.getMusica(id);
        // diretorio.getString(0);
        if (null != newThrd) {
            newThrd.stop();
        }
        File musica = new File("C:\\Users\\gustavoribes\\Downloads\\Metallica - Enter Sandman [Official Music Video].MP3");//pode ser wav ou mp3
        Music track = new Music(musica);
        Play play = new Play(track);
        PlayerController.newThrd = new Thread(play);
        PlayerController.newThrd.start();
    }

    public static void pause() {
        newThrd.stop();
    }

    public static void next() {
        try {
            PlayerController.play(PlayerController.id + 1);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void previous() {
        try {
            PlayerController.play(PlayerController.id - 1);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
