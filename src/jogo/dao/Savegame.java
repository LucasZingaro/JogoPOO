/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.dao;

import java.sql.SQLException;
import jogo.Main;
import jogo.modelo.Game;

/**
 *
 * @author MukaFelix
 */
public class Savegame {
    
    
    public static boolean save() throws SQLException{
        Game gaming = Main.game;
        ActionDAO actionDao = new ActionDAO();
        LoanDAO loanDao = new LoanDAO();
        MarketDAO marketDao = new MarketDAO();
        PlayerDAO playerDao = new PlayerDAO();
        
        actionDao.save(gaming.getMarket().getMarketListActions(),gaming.getId());
        
        
        
        return true;
    }
    
    public static boolean load() throws SQLException{
        
        
        
        return true;
    }
}
