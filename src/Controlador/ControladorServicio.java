package Controlador;

import Modelo.Cliente;
import Modelo.DatosCliente;
import Modelo.DatosMoto;
import Modelo.DatosServicioPrestado;
import Modelo.Moto;
import Modelo.ServicioPrestado;
import Vista.FrmAggCliente;
import Vista.FrmListasServicios;
import Vista.FrmServicio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

public class ControladorServicio {

    private final DatosServicioPrestado dServicio;
    private final DatosMoto dMoto = new DatosMoto();
    private final DatosCliente dCliente = new DatosCliente();
    private String mensaje;

    public ControladorServicio() {
        dServicio = new DatosServicioPrestado();
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean agregar(FrmServicio frm) throws IOException {

        boolean agregado = false;
        String placa = frm.jTxtPlacaMoto.getText();
        String cedula = frm.jTxtCedulaCliente.getText();
        String servicio = frm.cbServicio.getSelectedItem().toString();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-YYYY");
        String fechaHoy = formato.format(Calendar.getInstance().getTime());

        Moto unaMoto = new Moto();
        unaMoto.setPlaca(placa);

        Cliente unCliente = new Cliente();
        unCliente.setCedula(cedula);

        boolean existeCliente = dCliente.existeCliente(cedula);

        boolean existeMoto = dMoto.existeMoto(placa);

        if (!existeMoto) {
            this.mensaje = "No existe Moto con esta placa";
        } else if (!existeCliente) {
            this.mensaje = "No existe cliente con esta cedula";
        } else {
            ServicioPrestado unServicio = new ServicioPrestado(unaMoto, unCliente, fechaHoy, servicio);
            agregado = dServicio.agregar(unServicio);
            this.mensaje = dServicio.getMensaje();
        }
        return agregado;
    }

    public void eliminarServicio(FrmListasServicios frm) throws IOException, ClassNotFoundException {
        int selectRow = frm.tblServicios.getSelectedRow();
        if (selectRow == -1) {
            return;
        }
        ArrayList<ServicioPrestado> lista = dServicio.listaServicioPrestados();
        DefaultTableModel modelo = (DefaultTableModel) frm.tblServicios.getModel();
        modelo.removeRow(selectRow);
        ServicioPrestado servicio = lista.get(selectRow);
        lista.remove(servicio);
        dServicio.guardarCambiosEnArchivo(lista);
    }

    public void guardarCambios(FrmListasServicios frm) throws IOException, FileNotFoundException, ClassNotFoundException {
        int selectRow = frm.tblServicios.getSelectedRow();
        if (selectRow == -1) {
            return;
        }

        ArrayList<ServicioPrestado> lista = dServicio.listaServicioPrestados();
        DefaultTableModel modelo = (DefaultTableModel) frm.tblServicios.getModel();

        // Obtener el objeto ServicioPrestado seleccionado
        ServicioPrestado servicio = lista.get(selectRow);

        // Realizar las modificaciones en el objeto servicio según los valores en la tabla
        // Guardar los cambios en el archivo
        dServicio.guardarCambiosEnArchivo(lista);

        // Actualizar la tabla con los cambios
        modelo.setValueAt(servicio.getMoto().getPlaca(), selectRow, 0);
        modelo.setValueAt(servicio.getCliente().getCedula(), selectRow, 1);
        modelo.setValueAt(servicio.getFecha(), selectRow, 2);
        modelo.setValueAt(servicio.getTipoServicio(), selectRow, 3);
    }

    public void listaServicios(FrmListasServicios frm) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<ServicioPrestado> lista = dServicio.listaServicioPrestados();
        DefaultTableModel modelo = (DefaultTableModel) frm.tblServicios.getModel();
        String[] datos = new String[4];
        for (ServicioPrestado ser : lista) {
            datos[0] = ser.getMoto().getPlaca().toUpperCase();
            datos[1] = ser.getCliente().getCedula();
            datos[2] = ser.getFecha();
            datos[3] = ser.getTipoServicio();
            modelo.addRow(datos);
        }

    }
}
