package Main_Package;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFrame;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SABOU350
 */
public class test {
    public static void main(String[] args){
        Etagere etagere = new Etagere(400, 400, 300, 5, true,true,false);
        AfficheurEtagere2D afficheur = new AfficheurEtagere2D(etagere);
        
            etagere.getListeetages()[0].AjouteCaisson(0.2);
            etagere.getListeetages()[0].AjouteCaisson(0.2);
            etagere.getListeetages()[0].AjouteCaisson(0.2);
            etagere.getListeetages()[0].AjouteCaisson(0.4);
            etagere.getListeetages()[1].AjouteCaisson(1.0/3.0);
            etagere.getListeetages()[1].AjouteCaisson(1.0/3.0);
            etagere.getListeetages()[1].AjouteCaisson(1.0/3.0);
            etagere.getListeetages()[2].AjouteCaisson(1.0/3.0);
            etagere.getListeetages()[2].AjouteCaisson(1.0/3.0);
            etagere.getListeetages()[2].AjouteCaisson(1.0/3.0);
            etagere.getListeetages()[3].AjouteCaisson(1.0/3.0);
            etagere.getListeetages()[3].AjouteCaisson(1.0/3.0);
            etagere.getListeetages()[3].AjouteCaisson(1.0/3.0);
            etagere.getListeetages()[4].AjouteCaisson(1.0/3.0);
            etagere.getListeetages()[4].AjouteCaisson(1.0/3.0);
            etagere.getListeetages()[4].AjouteCaisson(1.0/3.0);
        
        //etagere.getListeetages()[2].AjouteCaisson(50);
        JFrame Jf = new JFrame();
        Jf.setTitle("Test");
        Jf.setSize(6000,6000);
        Jf.setVisible(true);
        Jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Jf.add(afficheur);
        afficheur.drawing();
    }
    
}