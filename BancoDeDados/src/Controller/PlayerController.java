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

/**
 *
 * @author gustavoribes
 */
public class PlayerController {

   MusicasDao playerdao = new MusicasDao();

    public void play(int id) throws SQLException, ClassNotFoundException {
        //ResultSet diretorio = playerdao.getMusica(id);
       // diretorio.getString(0);
        File musica = new File("C:\\Users\\gustavoribes\\Downloads\\Metallica - Enter Sandman [Official Music Video].MP3");//pode ser wav ou mp3
        Music track = new Music(musica);
        Play play = new Play(track);
        Thread newThrd = new Thread(play);
        newThrd.start();
       // newThrd.stop();
        
    }
}
