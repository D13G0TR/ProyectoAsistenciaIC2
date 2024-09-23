package cl.ipst.sca.main;

import cl.ipst.sca.frames.*;
import com.formdev.flatlaf.FlatIntelliJLaf;

/**
 *
 * @author Roberto Vargas Vargas <rvargas@dparica.cl>
 */
public class IPST_SCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Cargamos el Look&Feel versión IntelliJ
        FlatIntelliJLaf.setup();
        
        //frmUser v = new frmUser();
        //v.setSize(1200, 900);
        frmLogin v = new frmLogin();        
        v.setSize(340, 400);        
        v.setLocationRelativeTo(null);
        v.setVisible(true);        
    }

}
