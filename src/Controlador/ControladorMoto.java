package Controlador;

import Modelo.Moto;
import Modelo.DatosMoto;
import Vista.FrmAggMoto;
import java.io.IOException;

public class ControladorMoto {

    private DatosMoto dMoto;
    private String mensaje;

    public ControladorMoto() {
        dMoto = new DatosMoto();
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean agregar(FrmAggMoto frm) throws IOException {

        boolean agregado = false;
        String placa = frm.jTxtPlaca.getText();
        String marca = frm.cbMarca.getSelectedItem().toString();
        int modelo = Integer.parseInt(frm.cbModelo.getSelectedItem().toString());
        String color = frm.cbColor.getSelectedItem().toString();

        boolean existe = dMoto.existeMoto(placa);

        if (!existe) {
            Moto unaMoto = new Moto(placa, marca, modelo, color);
            agregado = dMoto.agregar(unaMoto);
        } else {
            frm.existe = true;
        }
        return agregado;
    }

}
