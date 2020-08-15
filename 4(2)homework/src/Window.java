import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame {


    public Window(){
        setTitle("Chat");


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        JPanel chatPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        
        textArea.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        chatPanel.add(scrollPane);
        add(chatPanel);

        JPanel Panel = new JPanel(new BorderLayout());

        JTextField input = new JTextField();
        input.addActionListener(new ActionListener() {
            private StringBuilder sb = new StringBuilder(textArea.getText());

            @Override
            public void actionPerformed(ActionEvent e) {
                if (input.getText().isBlank()) {
                    return;
                }
                sb.append(textArea.getText())
                        .append("\n").append("You: ")
                        .append(input.getText());
                textArea.setText(sb.toString());
                input.setText("");
                sb.setLength(0);
            }
        });


        Panel.add(input);

        JButton submit = new JButton("Enter");
        submit.addActionListener(new ButtonListener(input, textArea));
        Panel.add(submit, BorderLayout.EAST);

        add(Panel, BorderLayout.SOUTH);


        setVisible(true);
            }
        }




