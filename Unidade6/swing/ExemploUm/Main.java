import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main extends JFrame {

    JTextField tfNome = new JTextField("");
    JButton bt = new JButton("Clicar");
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
        super("titulo");
        setLayout(new BorderLayout(10, 10));

        

        add(new JLabel("Nome: "), BorderLayout.WEST);
        add(tfNome, BorderLayout.CENTER);
        add(bt, BorderLayout.EAST);

        
        bt.addActionListener(e -> executarClique());

        setSize(640, 240);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void executarClique(){
        new JOptionPane().showMessageDialog(null, "Olá " + tfNome.getText());
    }

}