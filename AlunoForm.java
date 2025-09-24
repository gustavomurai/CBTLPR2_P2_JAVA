import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoForm extends JFrame {
    private JTextField tfNome;
    private JTextField tfIdade;
    private JTextField tfEndereco;
    private JButton btnOk, btnLimpar, btnMostrar, btnSair;
    private List<Aluno> alunos = new ArrayList<>();

    public AlunoForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("TP02 - Cadastro de Alunos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior: GridLayout 3 linhas x 2 colunas (labels + campos)
        JPanel panelFields = new JPanel(new GridLayout(3, 2, 10, 10));
        panelFields.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        panelFields.add(new JLabel("Nome:"));
        tfNome = new JTextField();
        panelFields.add(tfNome);

        panelFields.add(new JLabel("Idade:"));
        tfIdade = new JTextField();
        panelFields.add(tfIdade);

        panelFields.add(new JLabel("Endereço:"));
        tfEndereco = new JTextField();
        panelFields.add(tfEndereco);

        add(panelFields, BorderLayout.CENTER);

        // Painel inferior: 4 botões em GridLayout (1 x 4)
        JPanel panelButtons = new JPanel(new GridLayout(1, 4, 10, 10));
        panelButtons.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        btnOk = new JButton("Ok");
        btnLimpar = new JButton("Limpar");
        btnMostrar = new JButton("Mostrar");
        btnSair = new JButton("Sair");

        panelButtons.add(btnOk);
        panelButtons.add(btnLimpar);
        panelButtons.add(btnMostrar);
        panelButtons.add(btnSair);

        add(panelButtons, BorderLayout.SOUTH);

        // Ações dos botões
        btnOk.addActionListener(e -> onOk());
        btnLimpar.addActionListener(e -> onLimpar());
        btnMostrar.addActionListener(e -> onMostrar());
        btnSair.addActionListener(e -> onSair());

        // Tamanho conforme print e centralizar
        setSize(400, 180);
        setLocationRelativeTo(null);
    }

    private void onOk() {
        String nome = tfNome.getText().trim();
        String idadeStr = tfIdade.getText().trim();
        String endereco = tfEndereco.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o nome.", "Erro", JOptionPane.ERROR_MESSAGE);
            tfNome.requestFocus();
            return;
        }

        if (idadeStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha a idade.", "Erro", JOptionPane.ERROR_MESSAGE);
            tfIdade.requestFocus();
            return;
        }

        int idade;
        try {
            idade = Integer.parseInt(idadeStr);
            if (idade < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Idade inválida. Informe um número inteiro não-negativo.", "Erro", JOptionPane.ERROR_MESSAGE);
            tfIdade.requestFocus();
            return;
        }

        if (endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o endereço.", "Erro", JOptionPane.ERROR_MESSAGE);
            tfEndereco.requestFocus();
            return;
        }

        // Cria e armazena em memória
        Aluno a = new Aluno(nome, idade, endereco);
        alunos.add(a);

        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!\nID: " + a.getUuid());
        onLimpar();
    }

    private void onLimpar() {
        tfNome.setText("");
        tfIdade.setText("");
        tfEndereco.setText("");
        tfNome.requestFocus();
    }

    private void onMostrar() {
        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Aluno a : alunos) {
            sb.append("ID: ").append(a.getUuid().toString()).append("\n");
            sb.append("Nome: ").append(a.getNome()).append("\n");
            sb.append("Idade: ").append(a.getIdade()).append("\n");
            sb.append("Endereço: ").append(a.getEndereco()).append("\n");
            sb.append("-------------------------------\n");
        }

        // Coloca em JTextArea dentro de JScrollPane para pop-up redimensionável
        JTextArea ta = new JTextArea(sb.toString());
        ta.setEditable(false);
        JScrollPane sp = new JScrollPane(ta);
        sp.setPreferredSize(new Dimension(360, 220));

        JOptionPane.showMessageDialog(this, sp, "Alunos cadastrados", JOptionPane.INFORMATION_MESSAGE);
    }

    private void onSair() {
        int opt = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AlunoForm().setVisible(true);
        });
    }
}
