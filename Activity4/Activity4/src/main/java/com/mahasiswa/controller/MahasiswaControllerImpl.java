/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahasiswa.controller;

import com.mahasiswa.model.ModelMahasiswa;
import com.mahasiswa.model.HibernateUtil;
import org.hibernate.*;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author karna
 */
public class MahasiswaControllerImpl implements MahasiswaController {

    @Override
    public void addMhs(ModelMahasiswa mhs) {
        Transaction trx = null;
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            trx = session.beginTransaction();
            session.save(mhs);
            trx.commit();
        } catch (Exception e) {
            if(trx != null) {
                trx.rollback();
            }
            e.printStackTrace();
        }
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ModelMahasiswa getMhs(int id) {
        
       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateMhs(ModelMahasiswa mhs) {
        Transaction trx = null;
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            trx = session.beginTransaction();
            session.update(mhs);
            trx.commit();
        } catch (Exception e) {
            if(trx != null) {
                trx.rollback();
            }
            e.printStackTrace();
        }
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteMhs(int id) {
        Transaction trx = null;
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            trx = session.beginTransaction();
            ModelMahasiswa mhs = session.get(ModelMahasiswa.class, id);
            session.delete(mhs);
            trx.commit();
        } catch (Exception e) {
            if(trx != null) {
                trx.rollback();
            }
            e.printStackTrace();
        }
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    @Override
    public List<ModelMahasiswa> searchMahasiswa(String nama) {
    Transaction trx = null;
    List<ModelMahasiswa> listMhs = null;
    
    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
        trx = session.beginTransaction();
        
        // Menggunakan HQL untuk mencari mahasiswa berdasarkan nama
        Query<ModelMahasiswa> query = session.createQuery("from ModelMahasiswa where nama like :nama", ModelMahasiswa.class);
        query.setParameter("nama", "%" + nama + "%"); // Menggunakan wildcard untuk pencarian yang fleksibel
        
        listMhs = query.list(); // Dapatkan hasil pencarian
        trx.commit();
        
        if (listMhs.isEmpty()) {
            System.out.println("Tidak ada mahasiswa yang ditemukan dengan nama: " + nama);
        }
    } catch (Exception e) {
        if (trx != null) {
            trx.rollback();
        }
        e.printStackTrace();
    }
    
    return listMhs;
}



    @Override
    public List<ModelMahasiswa> getAllMahasiswa() {
        Transaction trx = null;
        List<ModelMahasiswa> listMhs = null;
        
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            trx = session.beginTransaction();
            Query<ModelMahasiswa>query = session.createQuery("from ModelMahasiswa", ModelMahasiswa.class);
            listMhs = query.list();
            trx.commit();
        } catch (Exception e) {
            if(trx != null) {
                trx.rollback();
            }
            e.printStackTrace();
        }
        return listMhs;
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
