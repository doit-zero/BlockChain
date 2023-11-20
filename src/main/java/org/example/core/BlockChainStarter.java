package org.example.core;

import org.example.util.Util;

import java.util.ArrayList;

public class BlockChainStarter {
    public static void main(String[] args) {

        Block block1 = new Block(1,null,12,new ArrayList<>());
        block1.mine();
        block1.getInfo();

        Block block2 = new Block(2, block1.getPreviousBlockHash(), 0,new ArrayList<>());
        block2.addTransaction(new Transaction("유재준","나동빈",3));
        block2.addTransaction(new Transaction("최성실","유재준",2));
        block2.getInfo();

        Block block3 = new Block(3, block2.getPreviousBlockHash(), 0,new ArrayList<>());
        block3.addTransaction(new Transaction("준","빈",55));
        block3.addTransaction(new Transaction("최","준",22));
        block3.getInfo();



    }
}
