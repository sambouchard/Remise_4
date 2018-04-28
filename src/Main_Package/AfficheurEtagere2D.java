/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Package;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.event.MouseAdapter;

/**
 *
 * @author SABOU350
 */
public class AfficheurEtagere2D extends JPanel {

    private Etagere etagere;
    private double scale = 1.0;
    private Graphics2D g2d;
    private AffineTransform tx = new AffineTransform();
    
     Movingadapter ma = new Movingadapter();

    public AfficheurEtagere2D() {
        this.addMouseMotionListener(ma);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                for (Piece piece : etagere.getListe_piece()) {
                    if (piece.contains(me.getX(), me.getY())) {
                        System.out.println(piece.getNom());
                        System.out.println(piece.getMinX());
                        System.out.println(piece.getMaxX());
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent m) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });
        this.addMouseWheelListener(new ZoomHandler());
        this.addMouseListener(ma);
        
    }

    public void drawing() {
        repaint();
    }

    private class ZoomHandler implements MouseWheelListener {

        double scale = 1.0;

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {

                Point2D p1 = e.getPoint();
                Point2D p2 = null;
                try {
                    p2 = tx.inverseTransform(p1, null);
                } catch (NoninvertibleTransformException ex) {
                    return;
                }

                scale -= (0.1 * e.getWheelRotation());
                scale = Math.max(0.1, scale);

                tx.setToIdentity();
                tx.translate(p1.getX(), p1.getY());
                tx.scale(scale, scale);
                tx.translate(-p2.getX(), -p2.getY());

                AfficheurEtagere2D.this.revalidate();
                AfficheurEtagere2D.this.repaint();
            }
        }
    }

    private class Movingadapter extends MouseAdapter {

        private int x;

        private int y;

        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }

        public void mouseDragged(MouseEvent e) {

            int dx = e.getX() - x;
            int dy = e.getY() - y;
            for(Piece piece:etagere.getListe_piece()){
                piece.getDrawingcoin().setCoord_x(piece.getDrawingcoin().getCoord_x()+dx/25);
                piece.getDrawingcoin().setCoord_y(piece.getDrawingcoin().getCoord_y()+dy/25 );
            }
            
            
            repaint();
        }

    }

    /**
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;
        if (this.etagere != null) {

            for (Piece piece : this.etagere.getListe_piece()) {
                piece.setRect((piece.getDrawingcoin().getCoord_x())*10 , (piece.getDrawingcoin().getCoord_y())*10 , piece.getLargeur()*10 , piece.getHauteur()*10 );
                g2d.setColor(Color.BLACK);
                g2d.draw(tx.createTransformedShape(piece));

            }
        } else {
            g2d.setColor(Color.BLACK);
            Rectangle2D.Double rect = new Rectangle2D.Double(50, 50, 50, 50);
            g2d.fill(rect);
        }

    }

    /**
     * @return the etagere
     */
    public Etagere getEtagere() {
        return etagere;
    }

    /**
     * @param etagere the etagere to set
     */
    public void setEtagere(Etagere etagere) {
        this.etagere = etagere;
        revalidate();
        repaint();
    }

}
