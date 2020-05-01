
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class DAO {
    private int jmlData;
    private Connection koneksi;
    private Statement statement;
    
    public DAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/film";
            koneksi = DriverManager.getConnection(url, "root", "");
            statement = koneksi.createStatement();
            JOptionPane.showMessageDialog(null, "Koneksi berhasil");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class Not Found : "+ex);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "SQL Exception : "+ ex);
        }
    }
    
    public void Insert(Model model){
        try {
            String query = "INSERT INTO data_film VALUES ('25','"+model.getJudul()+"','"+model.getTipe()+"','"+model.getEpisode()+"','"+model.getGenre()+"','"+model.getStatus()+"','"+model.getRating()+"')";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public void Update(Model model) {
        try {
            String query = "UPDATE data_film SET judul= '" + model.getJudul() +  "', tipe = '" + model.getTipe() + "', episode = '" + model.getEpisode() + "', genre = '" + model.getGenre() + "', status = '" + model.getStatus() + "', rating = '" + model.getRating() + "' WHERE judul = '" + model.getJudul() + "'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil di update");
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void Delete(Model model) {
        try {
            String query = "DELETE FROM data_film WHERE judul= '" + model.getJudul() + "'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    
    //untuk mengambil data dari database dan mengatur ke dalam tabel
    public String[][] read(){
        try {
            int jmlData = 0;//Menampung jumlah data
            int k=0;
            //baris sejumlah data,kolom nya ada 3
            String data[][]= new String[getJmldata()][8];
            //pengambilan data dalam java dari database
            String query = "SELECT * FROM data_film";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){ //lanjut ke data selanjutnta jmlData bertambah
                k = jmlData+1;
                String nourut = Integer.toString(k);
                data[jmlData][0] = nourut; // kolom nama harus sama
                data[jmlData][1] = resultSet.getString("id");// besar kecil nya dengan database
                data[jmlData][2] = resultSet.getString("judul");// 
                data[jmlData][2] = resultSet.getString("tipe");
                data[jmlData][2] = resultSet.getString("episode");
                data[jmlData][2] = resultSet.getString("genre");
                data[jmlData][2] = resultSet.getString("status");
                data[jmlData][2] = resultSet.getString("rating");
                jmlData++;
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getJmldata(){
        int jmlData = 0;
        try {
            //pengambilan data kedalam java dari database
            String query = "SELECT *FROM data_film";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ //lanjut kedata selanjutnya, jmlData bertambah
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    
}
