/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Willian Kelvin Nata - 123180004
 */
public class Model { 
    private String judul,tipe,episode, genre, status, rating,cari;
    
    public void setModel(String njudul, String ntipe, String nepisode,String ngenre, String nstatus, String nrating, String ncari){
//        this.no = nno;
//        this.id = nid;
        this.judul = njudul;
        this.tipe = ntipe;
        this.episode = nepisode;
        this.genre = ngenre;
        this.status = nstatus;
        this.rating = nrating;
        this.cari = ncari;
    }
//    public String getNo(){
//        return no;
//    }
//    public void setNo(String no){
//        this.no = no;
//    }
//    
//    public String getId(){
//        return id;
//    }
//    public void setId(String id){
//        this.id = id;
//    }
    
    public String getJudul(){
        return judul;
    }
    public void setJudul(String judul){
        this.judul = judul;
    }
    
    public String getTipe(){
        return tipe;
    }
    public void setTipe(String tipe){
        this.tipe = tipe;
    }
    
    public String getEpisode(){
        return episode;
    }
    public void setEpisode(String episode){
        this.episode = episode;
    }
    
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getRating(){
        return rating;
    }
    public void setRating(String rating){
        this.rating = rating;
    }
    
     public String getCari(){
        return cari;
    }
    public void setCari(String cari){
        this.cari = cari;
    }
    
}
