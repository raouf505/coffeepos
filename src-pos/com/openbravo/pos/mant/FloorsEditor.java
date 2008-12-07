//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007 Openbravo, S.L.
//    http://sourceforge.net/projects/openbravopos
//
//    This program is free software; you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation; either version 2 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package com.openbravo.pos.mant;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.UUID;
import javax.swing.*;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.format.Formats;
import com.openbravo.basic.BasicException;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.DirtyManager;


/**
 *
 * @author adrianromero
 */
public class FloorsEditor extends JPanel implements EditorRecord {
    
//    private DirtyManager m_Dirty = new DirtyManager();    
    private String m_sID;
    
    /** Creates new form FloorsEditor */
    public FloorsEditor(DirtyManager dirty) {
        initComponents();
         
        m_jName.getDocument().addDocumentListener(dirty);
        m_jImage.addPropertyChangeListener("image", dirty);
        
        writeValueEOF();
    }

    public void writeValueEOF() {
        
        m_sID = null;
        m_jName.setText(null);
        m_jImage.setImage(null);

        m_jName.setEnabled(false);
        m_jImage.setEnabled(false);
    }  
    public void writeValueInsert() {
        
        m_sID = UUID.randomUUID().toString(); 
        m_jName.setText(null);
        m_jImage.setImage(null);

        m_jName.setEnabled(true);
        m_jImage.setEnabled(true);
    }
    public void writeValueDelete(Object value) {
        
        Object[] floor = (Object[]) value;
        m_sID = Formats.STRING.formatValue(floor[0]);
        m_jName.setText(Formats.STRING.formatValue(floor[1]));
        m_jImage.setImage((BufferedImage) floor[2]);

        m_jName.setEnabled(false);
        m_jImage.setEnabled(false);
    }    
    public void writeValueEdit(Object value) {
        
        Object[] floor = (Object[]) value;
        m_sID = Formats.STRING.formatValue(floor[0]);
        m_jName.setText(Formats.STRING.formatValue(floor[1]));
        m_jImage.setImage((BufferedImage) floor[2]);

        m_jName.setEnabled(true);
        m_jImage.setEnabled(true);
    }

    public Object createValue() throws BasicException {
        
        Object[] floor = new Object[3];

        floor[0] = m_sID;
        floor[1] = m_jName.getText();
        floor[2] = m_jImage.getImage();
        return floor;
    }    
    
    public Component getComponent() {
        return this;
    }
    
    public void refresh() {
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        m_jName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        m_jImage = new com.openbravo.data.gui.JImageEditor();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(150, 100));
        jPanel1.setLayout(null);

        jLabel3.setText(AppLocal.getIntString("Label.Name")); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 20, 90, 20);
        jPanel1.add(m_jName);
        m_jName.setBounds(110, 20, 180, 18);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(m_jImage, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private com.openbravo.data.gui.JImageEditor m_jImage;
    private javax.swing.JTextField m_jName;
    // End of variables declaration//GEN-END:variables
    
}
