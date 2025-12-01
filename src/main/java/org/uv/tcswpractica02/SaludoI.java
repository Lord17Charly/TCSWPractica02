/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sinoe
 */
public class SaludoI implements IMensaje{

    @Override
    public void imprimir() {
        Logger.getLogger(SaludoI.class.getName()).log(Level.INFO, "HOLA MUNDO");
    }
}
