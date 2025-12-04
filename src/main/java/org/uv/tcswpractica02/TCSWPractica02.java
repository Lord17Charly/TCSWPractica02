/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.tcswpractica02;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TCSWPractica02 {
    DAOEmpleado dao = new DAOEmpleado();
        public static void main(String[] args) {
        
        DAOEmpleado dao = new DAOEmpleado();
        PojoEmpleado pojo = new PojoEmpleado();
        pojo.setClave(4);
        pojo.setNombre("Gabriel");
        pojo.setDireccion("AV. 11");
        pojo.setTelefono("7777777");
        boolean res = dao.guardar(pojo);
        if (res) {
            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "SE GUARDO");
        } else {
            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "ERROR...");
        }
    }
    
}