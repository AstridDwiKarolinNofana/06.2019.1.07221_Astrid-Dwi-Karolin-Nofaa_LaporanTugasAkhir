package Astrid07221_View;
import Astrid07221_Controller.Astrid07221_AllObjectModel;
import Astrid07221_Controller.Astrid07221_PelangganController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Astrid07221_PetugasGUI {
    private static Astrid07221_PelangganController pelanggan = new Astrid07221_PelangganController();
    JFrame petugas = new JFrame();
    JTable tabelpelanggan = new JTable();
    JScrollPane scrollpetugas = new JScrollPane(tabelpelanggan);
    JButton back,verif,hapus;
    JLabel admin,idlabel,namalabel;
    JTextField idtext,namatext;
     public Astrid07221_PetugasGUI(){
        petugas.setSize(1500,700);
        petugas.setLayout(null);
        petugas.getContentPane().setBackground(Color.ORANGE);
        
        admin = new JLabel("Petugas");
        admin.setBounds(600, 30, 800, 50);
        admin.setFont(new Font("Timer New Roman",Font.BOLD,40));
        petugas.add(admin);
        
        scrollpetugas.setBounds(50, 100, 1200, 200);
        tabelpelanggan.setModel(pelanggan.daftarpel());
        petugas.add(scrollpetugas);
        
        idlabel = new JLabel("Id");
        idlabel.setBounds(450, 320, 100, 30);
        petugas.add(idlabel);
        idtext = new JTextField();
        idtext.setBounds(450, 350, 100, 30);
        petugas.add(idtext);
        
        namalabel = new JLabel("Nama");
        namalabel.setBounds(600, 320, 100, 30);
        petugas.add(namalabel);
        namatext = new JTextField();
        namatext.setBounds(600, 350, 100, 30);
        petugas.add(namatext);
        
        verif = new JButton("verif");
        verif.setBounds(750, 350, 100, 30);
        verif.setBackground(Color.GRAY);
        petugas.add(verif);
        
        back = new JButton("back");
        back.setBounds(450, 410, 100, 30);
        back.setBackground(Color.GRAY);
        petugas.add(back);
        
        hapus = new JButton("Hapus");
        hapus.setBounds(750, 410, 100, 30);
        hapus.setBackground(Color.GRAY);
        petugas.add(hapus);
        
        petugas.setLocationRelativeTo(null);
        petugas.setVisible(true);
        petugas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                petugas.dispose();
                Astrid07221_GUI men = new Astrid07221_GUI();//nama objek men
            }
        });
        
        verif.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk verifikasi id, dan nama
                String id = idtext.getText();
                String nama = namatext.getText();
                int index = Astrid07221_AllObjectModel.daftarPelangganmodel.cekData(id, nama); //dicek
                Astrid07221_Allobjctrl.petugas.updateIsVerified(index, Astrid07221_Allobjctrl.Pelanggan.showDaftarPelanggan(index)
                        .getIndexCamera(),Astrid07221_Allobjctrl.Pelanggan.showDaftarPelanggan(index).getPelanggan());
                tabelpelanggan.setModel(pelanggan.daftarpel());
            }
        });
        
        hapus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk verifikasi id, dan nama
                String id = idtext.getText();
                String nama = namatext.getText();
                int index=Astrid07221_AllObjectModel.daftarPelangganmodel.cekData(id, nama);
                Astrid07221_AllObjectModel.daftarPelangganmodel.hapusPelangganModel(index); //dicek
                tabelpelanggan.setModel(pelanggan.daftarpel());
            }
        });
        
        tabelpelanggan.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){  //method
                int i = tabelpelanggan.getSelectedRow();
                idtext.setText(Astrid07221_Allobjctrl.Pelanggan.daftarpel().getValueAt(i, 0).toString());
                namatext.setText(Astrid07221_Allobjctrl.Pelanggan.daftarpel().getValueAt(i, 1).toString());
            }
        });
     }
}
