package org.example.core;

import org.example.util.Util;

import java.util.ArrayList;

public class Block {

    private int blockID;
    private String previousBlockHash;
    private int nonce;
    private ArrayList<Transaction> transactionList;

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    public int getBlockID() {
        return blockID;
    }

    public void setBlockID(int blockID) {
        this.blockID = blockID;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }


    public Block(int blockID, String previousBlockHash ,int nonce, ArrayList transactionList) {
        this.blockID = blockID;
        this.previousBlockHash = previousBlockHash;
        this.nonce = nonce;
        this.transactionList = transactionList;
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }
    
    public void getInfo() {
        System.out.println("------------------------");
        System.out.println("블록 번호" + getBlockID());
        System.out.println("이전 해시" + getPreviousBlockHash());
        System.out.println("채굴 변수 값" + getNonce());
        System.out.println("블록 데이터" + transactionList.size()+ "");
        for(int i = 0; i < transactionList.size();i++){
            System.out.println(transactionList.get(i).getInfo());
        }
        System.out.println("블록 해시: " + getBlockHash());
        System.out.println("------------------------");
    }

    public String getBlockHash() {
        String transactionInfo = "";
        for (Transaction transaction : transactionList) {
            transactionInfo += transaction.getInfo();
        }
        return Util.getHash(nonce + transactionInfo + previousBlockHash);
    }

    public void mine() {
        while(true) {
            if(getBlockHash().substring(0,4).equals("0000")) {
                System.out.println(blockID + "번째 블록의 채굴에 성공했습니다.");
                break;
            }
            nonce++;
        }
    }

}
