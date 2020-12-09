package Astrid07221_Entity;
import java.text.SimpleDateFormat;
import java.util.Date;
public abstract class Astrid07221_AbstractRentalCamera { //keyword, berubah otomatis menjadi class abstract, untuk inheritance/pewarisan
    protected String id,nama,alamat,noIdentitas,notelp; //atribut
    
public Astrid07221_AbstractRentalCamera(String id,String nama, //konstruktor,parameter
    String alamat, String noIdentitas,String notelp){
    this.id=id;
    this.nama=nama;
    this.alamat=alamat;
    this.noIdentitas=noIdentitas;
    this.notelp=notelp;
}
    public String getId() {
        return id;
    }
 
    public void setid(String id) {
        this.id = id;
    }

    public String getnama() {
        return nama;
    }
    public void setnama(String nama) {
        this.nama = nama;
    }
    public String getalamat() {
        return alamat;
    }
    public void setalamat(String alamat) {
        this.alamat = alamat;
    }
    public String getnoIdentitas() {
        return noIdentitas;
    }
    public void setnoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
    }
    public String getnotelp() {
        return notelp;
    }
    public void setnotelp(String notelp) {
        this.notelp = notelp;
    }  
    
}


