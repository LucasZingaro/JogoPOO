/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.dao;

import java.sql.SQLException;
import jogo.Main;
import jogo.modelo.Game;
import jogo.modelo.Market;
import jogo.modelo.Player;
import jogo.modelo.StatusEnum;

/**
 *
 * @author MukaFelix
 */
public class Savegame {
    
    
    public static boolean save() throws SQLException{
        Game gaming = Main.game;
        ActionDAO actionDao = new ActionDAO();
        GameDAO gamedao = new GameDAO();
        LoanDAO loanDao = new LoanDAO();
        MarketDAO marketDao = new MarketDAO();
        PlayerDAO playerDao = new PlayerDAO();
        
        Market market = gaming.getMarket();
        marketDao.alterar( market);
        
        Player player = gaming.getPlayer();
        playerDao.alterar(player);
        
        gamedao.alterar(gaming);
        
        /*Loan loan = gaming.getPlayer().getLoanList()
        loanDao.alterar();*/
        
        actionDao.saveAlter(gaming.getMarket().getMarketListActions());
        //actionDao.alterarPurchaseOrderList(gaming.getMarket().getMarketListActions(), 0);
        
        return true;
    }
    
    public static boolean load() throws SQLException{
        
        
        
        return true;
    }
}
