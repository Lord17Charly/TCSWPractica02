/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sinoe
 */
public class DAOEmpleado implements IDAOGeneral<PojoEmpleado, Long> {

    private String esc(String s) {
        return s == null ? "" : s.replace("'", "''");
    }

    @Override
    public boolean guardar(PojoEmpleado pojo) {
        ConexionDB cx = ConexionDB.getInstance();

        TransactionDB<PojoEmpleado, Long> t = new TransactionDB<>(pojo) {
            @Override
            public boolean execute(Connection con) {
                final String sql = "INSERT INTO empleados2 (clave, nombre, direccion, telefono) VALUES (?,?,?,?)";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setLong(1, pojo.getClave());
                    pst.setString(2, pojo.getNombre());
                    pst.setString(3, pojo.getDireccion());
                    pst.setString(4, pojo.getTelefono());
                    pst.executeUpdate();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName())
                            .log(Level.SEVERE, "Error guardando empleado", ex);
                    return false;
                }
            }
        };

        return cx.execute(t);
    }

    private void closeQuietly(ResultSet rs) {
        if (rs != null) {
            try {
                if (rs.getStatement() != null) {
                    rs.getStatement().close();
                }
            } catch (SQLException ignored) {
            }
            try {
                rs.close();
            } catch (SQLException ignored) {
            }
        }
    }


    @Override
    public PojoEmpleado eliminar(Long id) {
        PojoEmpleado existente = findByID(id);
        if (existente == null) {
            return null;
        }

        String sql = "DELETE FROM empleados2 WHERE clave = " + id;
        boolean ok = ConexionDB.getInstance().execute(sql);
        return ok ? existente : null;
    }

    @Override
    public PojoEmpleado modificar(PojoEmpleado pojo, Long id) {
        PojoEmpleado actual = findByID(id);
        if (actual == null) {
            return null;
        }

        String sql = "UPDATE empleados2 SET "
                + "clave = " + pojo.getClave() + ", "
                + "nombre = '" + esc(pojo.getNombre()) + "', "
                + "direccion = '" + esc(pojo.getDireccion()) + "', "
                + "telefono = '" + esc(pojo.getTelefono()) + "' "
                + "WHERE clave = " + id;

        boolean ok = ConexionDB.getInstance().execute(sql);
        if (!ok) {
            return null;
        }

        return findByID(pojo.getClave());
    }

    @Override
    public PojoEmpleado findByID(Long id) {
        String sql = "SELECT clave, nombre, direccion, telefono FROM empleados2 WHERE clave = " + id;
        ResultSet res = null;
        try {
            ConexionDB con = ConexionDB.getInstance();
            res = con.select(sql);
            if (res != null && res.next()) {
                PojoEmpleado pojo = new PojoEmpleado();
                pojo.setClave(res.getLong("clave"));
                pojo.setNombre(res.getString("nombre"));
                pojo.setDireccion(res.getString("direccion"));
                pojo.setTelefono(res.getString("telefono"));
                return pojo;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, "EERROR EN FINDBYID", ex);
            return null;
        } finally {
            closeQuietly(res);
        }
    }

    @Override
    public List<PojoEmpleado> findAll() {
        String sql = "SELECT clave, nombre, direccion, telefono FROM empleados2 ORDER BY clave";
        List<PojoEmpleado> lista = new ArrayList<>();
        ResultSet res = null;
        try {
            ConexionDB con = ConexionDB.getInstance();
            res = con.select(sql);
            while (res != null && res.next()) {
                PojoEmpleado p = new PojoEmpleado();
                p.setClave(res.getLong("clave"));
                p.setNombre(res.getString("nombre"));
                p.setDireccion(res.getString("direccion"));
                p.setTelefono(res.getString("telefono"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, "ERROR EN FINDALL", ex);
        } finally {
            closeQuietly(res);
        }
        return lista;
    }
}
