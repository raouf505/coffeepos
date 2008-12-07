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

package com.openbravo.pos.forms;

import javax.swing.JComponent;
import javax.swing.JPanel;
import com.openbravo.basic.BasicException;

/**
 *
 * @author adrianromero
 */
public class JPanelNull extends JPanel implements JPanelView {

    /** Creates new form JPanelNull */
    public JPanelNull(AppView oApp, Object o) {
       
        initComponents ();
        if (o instanceof Exception) {
            ((Exception) o).printStackTrace();
        }
        jtxtException.setText(o.toString());
    }

    public JComponent getComponent() {
        return this;
    }
    public String getTitle() {
        return null;
    }
    public void activate() throws BasicException {
    }
    public boolean deactivate() {
        return true;
    }    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        m_jLabelError = new javax.swing.JLabel();
        jscrException = new javax.swing.JScrollPane();
        jtxtException = new javax.swing.JTextArea();

        setLayout(null);

        m_jLabelError.setText(AppLocal.getIntString("Label.LoadError"));
        add(m_jLabelError);
        m_jLabelError.setBounds(30, 30, 490, 20);

        jtxtException.setEditable(false);
        jtxtException.setLineWrap(true);
        jtxtException.setWrapStyleWord(true);
        jscrException.setViewportView(jtxtException);

        add(jscrException);
        jscrException.setBounds(30, 70, 550, 180);

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jscrException;
    private javax.swing.JTextArea jtxtException;
    private javax.swing.JLabel m_jLabelError;
    // End of variables declaration//GEN-END:variables

}
