/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DatosServicioPrestado {

    private File archivo;
    private DataOutputStream dos;
    private DataInputStream dis;
    private BufferedReader br;
    private BufferedWriter bw;
    private String mensaje;

    public DatosServicioPrestado() {
        archivo = new File("src/Modelo/Archivos/Servicio.bin");
        if (!archivo.exists()) {
            try {
                dos = new DataOutputStream(new FileOutputStream(archivo));
                dos.close();
            } catch (IOException ex) {
                this.mensaje = ex.getMessage();
            }
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean agregar(ServicioPrestado unServicio) {
        boolean agregado = false;
        this.mensaje = "";
        try {
            dos = new DataOutputStream(new FileOutputStream(archivo, true));
            String datosServicio = unServicio.getMoto().getPlaca() + ";"
                    + unServicio.getCliente().getCedula() + ";"
                    + unServicio.getFecha() + ";"
                    + unServicio.getTipoServicio() + "\n";

            dos.writeUTF(datosServicio);
            dos.close();
            agregado = true;
        } catch (IOException ex) {
            this.mensaje = ex.getMessage();
        }
        return agregado;
    }

    public void guardarCambiosEnArchivo(ArrayList<ServicioPrestado> listaServicios) {
        try {
            FileOutputStream fos = new FileOutputStream(archivo,false);
            DataOutputStream dos = new DataOutputStream(fos);

            for (ServicioPrestado servicio : listaServicios) {
                String datosServicio = servicio.getMoto().getPlaca() + ";"
                        + servicio.getCliente().getCedula() + ";"
                        + servicio.getFecha() + ";"
                        + servicio.getTipoServicio() + "\n";
                dos.writeUTF(datosServicio);
            }

            dos.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }

    public ArrayList<ServicioPrestado> listaServicioPrestados() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<ServicioPrestado> lista = new ArrayList<>();
        this.mensaje = "";

        try {
            FileInputStream fis = new FileInputStream(archivo);
            DataInputStream dis = new DataInputStream(fis);

            while (dis.available() > 0) {
                String datosServicio = dis.readLine();
                String[] datos = datosServicio.split(";");

                String placa = datos[0];
                String cedula = datos[1];
                String fecha = datos[2];
                String tipoServicio = datos[3];

                Moto unaMoto = new Moto();
                unaMoto.setPlaca(placa);
                Cliente unCliente = new Cliente();
                unCliente.setCedula(cedula);
                ServicioPrestado unServicio = new ServicioPrestado(unaMoto, unCliente, fecha, tipoServicio);
                lista.add(unServicio);
            }

            dis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
