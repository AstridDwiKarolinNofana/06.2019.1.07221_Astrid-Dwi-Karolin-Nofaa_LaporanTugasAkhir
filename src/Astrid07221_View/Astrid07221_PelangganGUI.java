package Astrid07221_View;
import Astrid07221_Entity.Astrid07221_CameraEntity;
import Astrid07221_Entity.Astrid07221_DaftarPelangganEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
public class Astrid07221_PelangganGUI {
    JFrame Pelanggan = new JFrame();
    JButton back,daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri,daftarcamera;
    JComboBox pilcamera = new JComboBox(Astrid07221_CameraEntity.merk);
    int cek = Astrid07221_Allobjctrl.Pelanggan.cekDaftarPelanggan
        (Astrid07221_Allobjctrl.Pelanggan.getData().getId());
    
    public Astrid07221_PelangganGUI(){
        Pelanggan.setSize(800, 700);
        Pelanggan.setLayout(null);
        Pelanggan.getContentPane().setBackground(Color.ORANGE);
        
        datadiri = new JLabel("Data Pelanggan");
        datadiri.setFont(new Font("Timer New Roman",Font.BOLD,30));
        datadiri.setBounds(30, 40, 400, 40);
        Pelanggan.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        Pelanggan.add(area);
        
        daftarcamera = new JLabel("Daftar Camera");
        daftarcamera.setBounds(450, 40, 400, 40);
        daftarcamera.setFont(new Font("Times New Roman",Font.BOLD,30));
        Pelanggan.add(daftarcamera);
        pilcamera.setBounds(450, 90, 230, 30);
        Pelanggan.add(pilcamera);
        
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GRAY);
        Pelanggan.add(daftarbtn);
        
        back = new JButton("Back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.GRAY);
        Pelanggan.add(back);
        
        Pelanggan.setVisible(true);
        Pelanggan.setLocationRelativeTo(null);
        Pelanggan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(cek==-1){ //cek data, apabila kita belum daftar praktkum
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Camera", "Information", JOptionPane.INFORMATION_MESSAGE);        
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null,"Anda Belum Daftar Camera", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datapelanggan());
        }
        daftarbtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
            int indexcamera = pilcamera.getSelectedIndex();
            Astrid07221_Allobjctrl.Pelanggan.Astrid07221_DaftarCamera
            (indexcamera,Astrid07221_Allobjctrl.Pelanggan.getData(), false);
            area.setText(datapelanggan());
        }
        });
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Pelanggan.dispose();
                Astrid07221_GUI men = new Astrid07221_GUI(); //nama objek menu
            }
        });
    }
    
    String datapelanggan(){
        int cek = Astrid07221_Allobjctrl.Pelanggan.cekDaftarPelanggan
        (Astrid07221_Allobjctrl.Pelanggan.getData().getId());
        String cekverif; //untuk verivikasi data berdasarkan id
        if(Astrid07221_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).isIsVerified()==false){
            cekverif = "belum diverifikasi";
        }else{
            cekverif = "sudah diverifikasi";
        }
         String text = "Id = "+Astrid07221_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getId()+"\n"
                +"Nama = "+Astrid07221_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnama()+"\n"
                +"Alamat = "+Astrid07221_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getalamat()+"\n"
                +"No Identitas = "+Astrid07221_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnoIdentitas()+"\n"
                +"No Telp = "+Astrid07221_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnotelp()+"\n"
                +"Tanggal Sewa = "+new SimpleDateFormat("dd-MM-yyyy").format(Astrid07221_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getTgl_sewa())+"\n"
                +"Tanggal Kembali = "+new SimpleDateFormat("dd-MM-yyyy").format(Astrid07221_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getTgl_kembali())+"\n"
                +"Verifikasi = "+cekverif+"\n"
                +"camera = "+Astrid07221_CameraEntity.merk[Astrid07221_Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getIndexCamera()];
        return text;
     
    }
}
    
