package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;
 

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(new pushListener());
        boutons.add(add);   add.addActionListener(new addListener());
        boutons.add(sub);   sub.addActionListener(new minListener());
        boutons.add(mul);   mul.addActionListener(new mulListener());
        boutons.add(div);   div.addActionListener(new divListener());
        boutons.add(clear); clear.addActionListener(new clearListener());
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
         if (pile.estPleine())
            push.setEnabled(false);
        else if (pile.estVide()){
            push.setEnabled(true);
            clear.setEnabled(false);
            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        } 
        else if (pile.taille() == 1){
            push.setEnabled(true);
            clear.setEnabled(true);
            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        } 
        else {
            push.setEnabled(true);
            clear.setEnabled(true);
            add.setEnabled(true);
            sub.setEnabled(true);
            mul.setEnabled(true);
            div.setEnabled(true);
        }
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    // à compléter
    // en cas d'exception comme division par zéro, 
    // mauvais format de nombre suite à l'appel de la méthode operande
    // la pile reste en l'état (intacte)
    
    public class pushListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            try{
                pile.empiler(operande());
            }catch (NumberFormatException exception){}
            catch (PilePleineException exception){}
            actualiserInterface();
            donnee.setText("");
        }
    }
    public class addListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            try{
                int x = pile.depiler();
                int y = pile.depiler();
                int s = x + y;
                pile.empiler(s);
                
            }catch (PileVideException exception){}
            catch (PilePleineException exception){}
            actualiserInterface();
            donnee.setText("");
    }
}
    public class minListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            try{
                int x = pile.depiler();
                int y = pile.depiler();
                int s = x - y;
                pile.empiler(s);
                
            }catch (PileVideException exception){}
            catch (PilePleineException exception){}
            actualiserInterface();
            donnee.setText("");
    }
}
    public class mulListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            
            try {
                int x = pile.depiler();
                int y = pile.depiler();
                int s = x * y;
                pile.empiler(s);
            }
            catch (PileVideException exception){}
            catch (PilePleineException exception){}

            actualiserInterface();
            donnee.setText("");
    }
}
    public class divListener implements ActionListener {
        public void actionPerformed (ActionEvent event){
            try{
                int x = pile.depiler();
                int y = pile.depiler();
                if (y != 0){
                int s = x / y;    
                }else {
                    JOptionPane.showMessageDialog(null, "You can't devide by 0");
                    pile.empiler(x);
                    pile.empiler(y);
                }
               
                
            }catch (PileVideException exception){}
            catch (PilePleineException exception){}
             actualiserInterface();
             donnee.setText("");
    }
}
public class clearListener implements ActionListener {
    public void actionPerformed (ActionEvent event){
        while (!pile.estVide()){
            try{
                pile.depiler();
            }catch(PileVideException exception){}
            actualiserInterface();
        }
    }
}
   
}
    
            /*Object ob = event.getSource();
            if (ob == push){
                 try {
                pile.empiler(operande());
            }
            catch (NumberFormatException exception){}
            catch (PilePleineException exception){}
            actualiserInterface();
            }else if (ob == add){
                try {
                int x = pile.depiler();
                int y = pile.depiler();
                int s = x+y;
                pile.empiler(s);
            }
            catch (PileVideException exception){}
            catch (PilePleineException exception){}

            actualiserInterface();
            }else if (ob == mul) {
                    try {
                int x = pile.depiler();
                int y = pile.depiler();
                int s = x*y;
                pile.empiler(s);
            }
            catch (PileVideException exception){}
            catch (PilePleineException exception){}

            actualiserInterface();
                
            }else if (ob == div){
                    try {
                int x = pile.depiler();
                int y = pile.depiler();
                if (y != 0){
                    int s = x/y;
                    pile.empiler(s);
                }else {
                    pile.empiler(x);
                    pile.empiler(y);
                }
                
            }
            catch (PileVideException event){}
            catch (PilePleineException event){}

            actualiserInterface();
                
            }else if (ob == clear){
                while(!pile.estVide()){
                    try{
                        pile.depiler();
                    }catch (PileVideException event){}
                    actualiserInterface();
                }
            }else if (ob == sub){
                    try {
                int x = pile.depiler();
                int y = pile.depiler();
                int s = x-y;
                pile.empiler(s);
            }
            catch (PileVideException exception){}
            catch (PilePleineException exception){}

            actualiserInterface();
            }
        }
    }*/
    


