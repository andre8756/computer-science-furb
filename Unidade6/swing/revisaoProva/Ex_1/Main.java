package swing.revisaoProva.Ex_1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class Main extends JFrame{

    private JTextField txtNome = new JTextField(12);
    private JButton btnSaudar = new JButton("Saudar");
    private JLabel lblMensagem = new JLabel("...");

    public Main() {
        super("Saudação");
        setLayout(new FlowLayout());
        add(txtNome); add(btnSaudar); add(lblMensagem);
        btnSaudar.addActionListener(e -> saudar());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(330, 110);
    }

    private void saudar() {
        lblMensagem.setText("Olá, " + txtNome.getText() + "!");
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

}
