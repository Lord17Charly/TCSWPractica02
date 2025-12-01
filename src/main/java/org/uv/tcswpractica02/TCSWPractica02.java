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
    
    
    

//    private static final DAOEmpleado dao = new DAOEmpleado();
//    private static final Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args) {
//
//        ControllerMensaje controller = new ControllerMensaje();
//
//        IMensaje msg = new SaludoI();
//        controller.mostrar(msg);
//        controller.mostrar(new SaludoI());
//        controller.mostrar(new DespedidaI());
//
//        controller.mostrar(new IMensaje() {
//            @Override
//            public void imprimir() {
//                Logger.getLogger(IMensaje.class.getName()).log(Level.INFO, "HOLA MUNDO");
//            }
//        });
//
//        int op;
//        do {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "\n=== GESTION DE EMPLEADOS ===");
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "1) ALTA (CREAR)");
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "2) BAJA (ELIMINAR)");
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "3) MODIFICACIONES (ACTUALIZAR)");
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "4) CONSULTA POR ID");
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "5) LISTAR TODOS");
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "0) SALIR");
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "OPCION: ");
//            op = leerEntero();
//
//            switch (op) {
//                case 1 ->
//                    alta();
//                case 2 ->
//                    baja();
//                case 3 ->
//                    modificacion();
//                case 4 ->
//                    consultaPorId();
//                case 5 ->
//                    listarTodos();
//                case 0 ->
//                    Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "SALIENDO...");
//                default ->
//                    Logger.getLogger(TCSWPractica02.class.getName()).log(Level.WARNING, "OPCION NO VALIDA");
//            }
//        } while (op != 0);
//    }
//
//    private static void alta() {
//        Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "\n-- ALTA DE EMPLEADO --");
//        PojoEmpleado p = new PojoEmpleado();
//        p.setClave(leerLong("CLAVE (NUMERICA): "));
//        p.setNombre(leerTexto("NOMBRE: "));
//        p.setDireccion(leerTexto("DIRECCION: "));
//        p.setTelefono(leerTexto("TELEFONO: "));
//        boolean ok = dao.guardar(p);
//        if (ok) {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "SE GUARDO: {0}", p);
//        } else {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.WARNING, "NO SE GUARDO");
//        }
//    }
//
//    private static void baja() {
//        Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "\n-- BAJA DE EMPLEADO --");
//        long id = leerLong("CLAVE A ELIMINAR: ");
//        PojoEmpleado eliminado = dao.eliminar(id);
//        if (eliminado != null) {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "ELIMINADO: {0}", eliminado);
//        } else {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.WARNING, "NO EXISTE CLAVE: {0}", id);
//        }
//    }
//
//    private static void modificacion() {
//        Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "\n-- MODIFICACION DE EMPLEADO --");
//        long id = leerLong("CLAVE EXISTENTE A MODIFICAR: ");
//        PojoEmpleado actual = dao.findByID(id);
//        if (actual == null) {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.WARNING, "NO EXISTE LA CLAVE {0}", id);
//            return;
//        }
//        Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "ACTUAL: {0}", actual);
//
//        long nuevaClave = leerLongOpcional("NUEVA CLAVE (ENTER PARA CONSERVAR " + actual.getClave() + "): ", actual.getClave());
//        String nuevoNombre = leerTextoOpcional("NUEVO NOMBRE (ENTER PARA CONSERVAR '" + actual.getNombre() + "'): ", actual.getNombre());
//        String nuevaDir = leerTextoOpcional("NUEVA DIRECCION (ENTER PARA CONSERVAR '" + actual.getDireccion() + "'): ", actual.getDireccion());
//        String nuevoTel = leerTextoOpcional("NUEVO TELEFONO (ENTER PARA CONSERVAR '" + actual.getTelefono() + "'): ", actual.getTelefono());
//
//        PojoEmpleado p = new PojoEmpleado();
//        p.setClave(nuevaClave);
//        p.setNombre(nuevoNombre);
//        p.setDireccion(nuevaDir);
//        p.setTelefono(nuevoTel);
//
//        PojoEmpleado actualizado = dao.modificar(p, id);
//        if (actualizado != null) {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "ACTUALIZADO: {0}", actualizado);
//        } else {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.WARNING, "NO SE ACTUALIZO");
//        }
//    }
//
//    private static void consultaPorId() {
//        Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "\n-- CONSULTA POR ID --");
//        long id = leerLong("CLAVE: ");
//        PojoEmpleado p = dao.findByID(id);
//        if (p != null) {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "ENCONTRADO: {0}", p);
//        } else {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.WARNING, "NO EXISTE LA CLAVE {0}", id);
//        }
//    }
//
//    private static void listarTodos() {
//        Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "\n-- LISTADO DE EMPLEADOS --");
//        List<PojoEmpleado> lista = dao.findAll();
//        if (lista.isEmpty()) {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "(SIN REGISTROS)");
//        } else {
//            lista.forEach(e
//                    -> Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "{0}", e)
//            );
//        }
//    }
//
//    private static int leerEntero() {
//        while (true) {
//            try {
//                String s = sc.nextLine().trim();
//                return Integer.parseInt(s);
//            } catch (NumberFormatException e) {
//                Logger.getLogger(TCSWPractica02.class.getName()).log(Level.WARNING, "NUMERO INVALIDO, INTENTA DE NUEVO: ");
//            }
//        }
//    }
//
//    private static long leerLong(String prompt) {
//        Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "{0}", prompt);
//        while (true) {
//            try {
//                String s = sc.nextLine().trim();
//                return Long.parseLong(s);
//            } catch (NumberFormatException e) {
//                Logger.getLogger(TCSWPractica02.class.getName()).log(Level.WARNING, "NUMERO INVALIDO, INTENTA DE NUEVO: ");
//            }
//        }
//    }
//
//    private static long leerLongOpcional(String prompt, long valorPorDefecto) {
//        Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "{0}", prompt);
//        String s = sc.nextLine().trim();
//        if (s.isEmpty()) {
//            return valorPorDefecto;
//        }
//        try {
//            return Long.parseLong(s);
//        } catch (NumberFormatException e) {
//            Logger.getLogger(TCSWPractica02.class.getName()).log(Level.WARNING, "ENTRADA INVALIDA, SE CONSERVA: {0}", valorPorDefecto);
//            return valorPorDefecto;
//        }
//    }
//
//    private static String leerTexto(String prompt) {
//        Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "{0}", prompt);
//        return sc.nextLine();
//    }
//
//    private static String leerTextoOpcional(String prompt, String defecto) {
//        Logger.getLogger(TCSWPractica02.class.getName()).log(Level.INFO, "{0}", prompt);
//        String s = sc.nextLine();
//        return s.isBlank() ? defecto : s;
//    }
}

