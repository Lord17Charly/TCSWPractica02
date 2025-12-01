/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica02;

import java.util.List;

/**
 *
 * @author sinoe
 */
public interface IDAOGeneral<T, ID> {

    public boolean guardar(T pojo);

    public T eliminar(ID id);

    public T modificar(T pojo, ID id);

    public T findByID(ID id);

    public List<T> findAll();
}
