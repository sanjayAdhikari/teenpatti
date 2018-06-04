package com.backspace.teenpatti.game;

/**
 * Created by Backspace on 11/12/2016.
 */
public class CurrentGame {
    private int userBid=0;
    private int bot1Bid=0;
    private int bot2Bid=0;
    private int bot3Bid=0;


    private static int winnerIndex; //0 for bot3,1 for bot2,2 for bot1 and 3 for user
    private static String ReasonOfWon; //can be like Pair,double run etc



    public static int getWinnerIndex() {
        return winnerIndex;
    }

    public static void setWinnerIndex(int winnerIndex) {
        CurrentGame.winnerIndex = winnerIndex;
    }

    public static String getReasonOfWon() {
        return ReasonOfWon;
    }

    public static void setReasonOfWon(String reasonOfWon) {
        ReasonOfWon = reasonOfWon;
    }



    public  int getBot1Bid() {
        return bot1Bid;
    }

    public  void setBot1Bid(int bot1Bid) {
        this.bot1Bid = bot1Bid;
    }

    public  int getBot2Bid() {
        return bot2Bid;
    }

    public  void setBot2Bid(int bot2Bid) {
        this.bot2Bid = bot2Bid;
    }

    public  int getBot3Bid() {
        return bot3Bid;
    }

    public  void setBot3Bid(int bot3Bid) {
        this.bot3Bid = bot3Bid;
    }

    public  void setUserBid(int userBid) {
        this.userBid = userBid;
    }

    public  int getUserBid() {
        return userBid;
    }
}
