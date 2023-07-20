package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatosMoto {

    private File archivo;
    private DataOutputStream dos;
    private DataInputStream dis;
    private String mensaje;

    public DatosMoto() {
        archivo = new File("src/Modelo/Archivos/Motos.bin");
        if (!archivo.exists()) {
            try {
                dos = new DataOutputStream(new FileOutputStream(archivo));
                dos.close();
            } catch (IOException ex) {
                this.mensaje = ex.getMessage();
            }
        }
    }

    public boolean agregar(Moto unaMoto) {
        boolean agregado = false;
        this.mensaje = "";
        try {
            dos = new DataOutputStream(new FileOutputStream(archivo, true));
            String datosMoto = unaMoto.getPlaca() + ";"
                    + unaMoto.getMarca() + ";"
                    + unaMoto.getModelo() + ";"
                    + unaMoto.getColor() + "\n";
            dos.writeUTF(datosMoto);
            agregado = true;
        } catch (IOException ex) {
            this.mensaje = ex.getMessage();
        }
        return agregado;
    }

    public boolean existeMoto(String placa) throws IOException {
        boolean existe = false;
        try {
            dis = new DataInputStream(new FileInputStream(archivo));
            
            while (dis.available()>0) {
                String datosMoto = dis.readUTF();
                String[] campos = datosMoto.split(";");
                String placaMoto = campos[0];

                if (placaMoto.equals(placa)) {
                    existe = true;
                    break;
                }
            }
            dis.close();
        } catch (IOException ex) {
            this.mensaje = "Problemas al leer los datos del cliente";
        }
        return existe;
    }
}
