
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Willian Kelvin Nata - 123180004
 */
public class Controller {
    MenuView menuview;
    Model model;
    DAO dao;
    
    public Controller(final MenuView menuview, final Model model, final DAO dao){
        this.menuview = menuview;
        this.model = model;
        this.dao = dao;
        
        if (dao.getJmldata() != 0) {//disini untuk mengecek apakah database berisi data atau tidak
            String datafilm[][] = dao.read();
            menuview.tabel.setModel((new JTable(datafilm, menuview.namaKolom)).getModel());
        } else {
            //Kalau tidak ada maka muncul pop up
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        menuview.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mousePressed(e);
                int baris = menuview.tabel.getSelectedRow();
                int kolom = menuview.tabel.getSelectedColumn();
                
                String judul = menuview.tabel.getValueAt(baris, 2).toString();
                menuview.txjudul.setText(judul);
                String tipe = menuview.tabel.getValueAt(baris, 3).toString();
                menuview.txtipe.setText(tipe);
                String episode = menuview.tabel.getValueAt(baris, 4).toString();
                menuview.txepisode.setText(episode);
                String genre = menuview.tabel.getValueAt(baris, 5).toString();
                menuview.txgenre.setText(genre);
                String rating = menuview.tabel.getValueAt(baris, 7).toString();
                menuview.txrating.setText(rating);
           }
        });
        
        menuview.brefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dataFilm[][] = dao.read();
                menuview.tabel.setModel((new JTable(dataFilm, menuview.namaKolom)).getModel());
            }
        });
        
        menuview.bcreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String no = menuview.getNo();
//                String id = menuview.getId();
                String judul = menuview.getJudul();
                String tipe = menuview.getTipe();
                String episode = menuview.getEpisode();
                String genre = menuview.getGenre();
                String status = menuview.getStatus();
                String rating = menuview.getRating();
                String cari = menuview.getCari();
                
                if (judul.isEmpty() || tipe.isEmpty() || episode.isEmpty()|| genre.isEmpty()|| status.isEmpty()|| rating.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Harap Mengisi Semua Field");
                } else {
                    //memasukkan data kedalam model
                    model.setModel(judul, tipe, episode,status, genre, rating,cari);
                    //menjalankan perintah insert di DAO
                    dao.Insert(model);

                    String dataFilm[][] = dao.read();
                    menuview.tabel.setModel((new JTable(dataFilm, menuview.namaKolom)).getModel());
                }
            }
        });
        
        menuview.bupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = menuview.getJudul();
                String tipe = menuview.getTipe();
                String episode = menuview.getEpisode();
                String genre = menuview.getGenre();
                String status = menuview.getStatus();
                String rating = menuview.getRating();
                String cari = menuview.getCari();
                if(judul.isEmpty() || tipe.isEmpty() || episode.isEmpty() || genre.isEmpty() || status.isEmpty() || rating.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Harap Isi Semua Field");
               }else{
                    model.setModel(judul, tipe, episode,genre, status, rating,cari);
                    dao.Update(model);
                    
                    String dataFilm[][] = dao.read();
                    menuview.tabel.setModel((new JTable(dataFilm,menuview.namaKolom)).getModel());
                }
            }
        });
        
        menuview.bdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = menuview.getJudul();
                String tipe = menuview.getTipe();
                String episode =menuview.getEpisode();
                String genre = menuview.getGenre();
                String status = menuview.getStatus();
                String rating = menuview.getRating();
                String cari = menuview.getCari();
                if(judul.isEmpty() || tipe.isEmpty() || episode.isEmpty() || genre.isEmpty() || status.isEmpty() || rating.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Harap Isi Semua Field");
               }else{
                    model.setModel(judul, tipe, episode,genre, status, rating,cari);
                    dao.Delete(model);
                    
                    String dataFilm[][] = dao.read();
                    menuview.tabel.setModel((new JTable(dataFilm,menuview.namaKolom)).getModel());
                }
            }
        });
        menuview.bexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Terima Kasih");
                System.exit(0);
            }
        });
        
        menuview.bsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = menuview.getJudul();
                String tipe = menuview.getTipe();
                String episode = menuview.getEpisode();
                String genre = menuview.getGenre();
                String status = menuview.getStatus();
                String rating = menuview.getRating();
                String cari = menuview.getCari();
                if(cari.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Harap Isi Data yang Ingin Dicari");
               }else{
                    model.setModel(judul, tipe, episode, genre, status, rating, cari);
                    dao.Search(model);
                }
            }
        });
        
    }
}
