/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkiran.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author 
 */
public class ModelTabelParkiran extends AbstractTableModel {
    private List<ModelParkiran> parkiranList;
    private String[] columnNames = {"Jenis Kendaraan", "Nomor Plat", "Waktu Masuk"};

    public ModelTabelParkiran(List<ModelParkiran> parkiranList) {
        this.parkiranList = parkiranList;
    }

    @Override
    public int getRowCount() {
        return parkiranList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelParkiran parkiran = parkiranList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                int jenis = parkiran.getJenisKendaraan();
                return jenis == 1 ? "Motor" : "Mobil";
            case 1:
                return parkiran.getPlatNomor();
            case 2:
                return parkiran.getWaktuMasuk();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void setParkiranList(List<ModelParkiran> parkiranList) {
        this.parkiranList = parkiranList;
        fireTableDataChanged();
    }
}