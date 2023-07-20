package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatosCliente {

    private File archivo;
    private DataOutputStream dos;
    private DataInputStream dis;
    private BufferedReader br;
    private BufferedWriter bw;
    private String mensaje;

    public DatosCliente() {
        archivo = new File("src/Modelo/Archivos/Clientes.bin");
        if (!archivo.exists()) {
            try {
                dos = new DataOutputStream(new FileOutputStream(archivo));
                dos.close();
            } catch (IOException ex) {
                this.mensaje = ex.getMessage();
            }
        }
    }

    public boolean agregar(Cliente unCliente) {
        boolean agregado = false;
        this.mensaje = "";
        try {
            dos = new DataOutputStream(new FileOutputStream(archivo, true));
            String textoCliente = unCliente.getCedula() + ";"
                    + unCliente.getNombre() + ";"
                    + unCliente.getApellido() + ";"
                    + unCliente.getCorreo() + ";"
                    + unCliente.getCelular() + "\n";
            dos.writeUTF(textoCliente);
            dos.close();
            agregado = true;
        } catch (IOException ex) {
            this.mensaje = ex.getMessage();
        }
        return agregado;
    }

    public boolean existeCliente(String cedula) throws IOException {
        boolean existe = false;
        try {
            dis = new DataInputStream(new FileInputStream(archivo));
            while (dis.available() > 0) {
                String datosCliente = dis.readUTF();
                String[] campos = datosCliente.split(";");
                String cedulaCliente = campos[0];

                if (cedulaCliente.equals(cedula)) {
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

    public Cliente obtenerClientePorCc(String cedula) {
        this.mensaje = null;
        Cliente unCliente = null;
        try {
            // dos = new FileReader(archivo);
            //br = new BufferedReader(dos);
            String[] datos;
            while (br.ready()) {
                datos = (br.readLine()).split(";");
                if (datos[0].equals(cedula)) {
                    unCliente = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4]);
                    break;
                }
            }
            dos.close();
            br.close();
        } catch (IOException ex) {
            this.mensaje = "Problemas al datos del archivo Clientes";
        }
        return unCliente;
    }

}
