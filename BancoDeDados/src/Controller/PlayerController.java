/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.PlayerDao;
import java.io.File;
import java.sql.SQLException;

/**
 *
 * @author gustavoribes
 */
public class PlayerController {

    PlayerDao playerdao = new PlayerDao();

    public void play(int id) throws SQLException, ClassNotFoundException {
        String diretorio = playerdao.selectmusic(id);
        File musica = new File(diretorio);//pode ser wav ou mp3
        Music track = new Music(musica);
        Play play = new Play(track);
        Thread newThrd = new Thread(play);
        newThrd.start();
    }

    public void next() {

    }
}
