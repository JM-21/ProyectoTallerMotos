
package Controlador;

import Modelo.Cliente;
import Modelo.DatosCliente;
import Vista.FrmAggCliente;
import java.io.IOException;


public class ControladorCliente {
    private DatosCliente dCliente;
    private String mensaje;

    
    public ControladorCliente() {
        dCliente = new DatosCliente();
    }

    
    
    public String getMensaje(){
        return mensaje;
    }
    
    public boolean agregar(FrmAggCliente frm) throws IOException{
        
        boolean agregado=false;
        String cedula = frm.jTxtCedula.getText();
        String nombre = frm.jTxtNombre.getText();
        String apellido = frm.jTxtApellido.getText();
        String correo = frm.jTxtCorreo.getText();
        String celular = frm.jTxtCelular.getText();
        
        boolean existe = dCliente.existeCliente(cedula);
        
        if (!existe) {
            Cliente unCliente = new Cliente(cedula,nombre,apellido,correo,celular);
            agregado = dCliente.agregar(unCliente);
        }else{
            frm.existe=true;
        }
        return agregado;
    }
    
    
    
    
}
